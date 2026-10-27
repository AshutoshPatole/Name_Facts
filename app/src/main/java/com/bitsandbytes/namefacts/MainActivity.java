package com.bitsandbytes.namefacts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import hotchemi.android.rate.AppRate;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewUtils.applySystemWindowInsetsPadding(findViewById(R.id.activity_main));

        AppRate.with(this)
                .setInstallDays(0)
                .setLaunchTimes(2)
                .setRemindInterval(1)
                .setShowLaterButton(true)
                .setDebug(false)
                .monitor();

        AppRate.showRateDialogIfMeetsConditions(this);

        Button btnGetStarted = findViewById(R.id.btnGetStarted);
        btnGetStarted.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, Name_Details.class)));
    }
}
