package com.bitsandbytes.namefacts;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Shared "press back twice to exit" behavior using the AndroidX back dispatcher,
 * so it keeps working with predictive back on Android 13+.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private boolean exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (exit) {
                    finish();
                } else {
                    Toast.makeText(BaseActivity.this, "Press Back again to Exit.",
                            Toast.LENGTH_SHORT).show();
                    exit = true;
                    new Handler(Looper.getMainLooper()).postDelayed(() -> exit = false, 3000);
                }
            }
        });
    }
}
