package com.bitsandbytes.namefacts;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

public class SpalshScreen extends AppCompatActivity {

    private Handler handler;
    private Runnable transitionRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        handler = new Handler(Looper.getMainLooper());
        transitionRunnable = () -> {
            if (!isFinishing() && !isDestroyed()) {
                startActivity(new Intent(SpalshScreen.this, MainActivity.class));
                finish();
            }
        };
        // Shortened from 1200ms to 500ms so the forced splash wait is much briefer.
        handler.postDelayed(transitionRunnable, 500);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null && transitionRunnable != null) {
            handler.removeCallbacks(transitionRunnable);
        }
    }
}
