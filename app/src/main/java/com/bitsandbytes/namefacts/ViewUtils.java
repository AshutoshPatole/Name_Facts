package com.bitsandbytes.namefacts;

import android.view.View;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public final class ViewUtils {

    private ViewUtils() {
        // Utility class
    }

    /**
     * Applies system bar insets (status bar, navigation bar, cutouts) as padding
     * to the given view to guarantee content is never clipped under edge-to-edge system bars.
     */
    public static void applySystemWindowInsetsPadding(View view) {
        if (view == null) {
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(view, (v, windowInsets) -> {
            Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(insets.left, insets.top, insets.right, insets.bottom);
            return windowInsets;
        });
    }
}
