package com.bitsandbytes.namefacts;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

/**
 * Streams text into a {@link TextView} one word at a time (~200 WPM = 300 ms per word),
 * giving the reading a premium, typewriter-style reveal instead of dumping everything at once.
 */
public final class TextStreamer {

    private static final long WORD_DELAY_MS = 50; // 200 words per minute

    private final TextView textView;
    private final Handler handler;
    private final String[] words;
    private int index;
    private boolean cancelled;

    private TextStreamer(TextView textView, String fullText) {
        this.textView = textView;
        this.handler = new Handler(Looper.getMainLooper());
        // Strip HTML tags before splitting into words for a clean plain-text stream.
        String plain = fullText.replaceAll("<[^>]*>", " ");
        this.words = plain.trim().split("\\s+");
        this.index = 0;
        this.cancelled = false;
        this.textView.setText("");
    }

    /**
     * Starts streaming the given text into the text view, one word at a time.
     * Returns the streamer so the caller can cancel it (e.g. on new calculation or destroy).
     */
    public static TextStreamer stream(TextView textView, String fullText) {
        TextStreamer streamer = new TextStreamer(textView, fullText);
        streamer.start();
        return streamer;
    }

    private void start() {
        cancelled = false;
        index = 0;
        textView.setText("");
        streamNextWord();
    }

    /** Cancels any pending word deliveries. Call this when the view is recycled or a new calculation starts. */
    public void cancel() {
        cancelled = true;
        handler.removeCallbacksAndMessages(null);
    }

    private void streamNextWord() {
        if (cancelled || index >= words.length) {
            return;
        }

        String current = textView.getText().toString();
        String next = current.isEmpty() ? words[index] : current + " " + words[index];
        textView.setText(next);
        index++;

        if (index < words.length && !cancelled) {
            handler.postDelayed(this::streamNextWord, WORD_DELAY_MS);
        }
    }
}
