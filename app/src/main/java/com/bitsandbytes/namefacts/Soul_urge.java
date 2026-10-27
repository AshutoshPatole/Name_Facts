package com.bitsandbytes.namefacts;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Soul_urge extends AppCompatActivity {

    private TextStreamer soulStreamer;

    @android.annotation.SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soul_urge);

        ViewUtils.applySystemWindowInsetsPadding(findViewById(R.id.root_soul_urge));

        Intent intent = getIntent();
        String soulName = (intent != null && intent.hasExtra("Soul"))
                ? intent.getStringExtra("Soul")
                : "";
        if (soulName == null) {
            soulName = "";
        }

        TextView soulNumberView = findViewById(R.id.soulUrge_Number);
        TextView soulDataView = findViewById(R.id.SoulUrge_data);
        TextView factsAbout = findViewById(R.id.facts_about);
        ImageView next = findViewById(R.id.nextScreen);

        next.setOnClickListener(v -> {
            Intent nextIntent = new Intent(Soul_urge.this, MainActivity.class);
            nextIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(nextIntent);
            finish();
        });

        factsAbout.setText(getString(R.string.about) + " " + soulName);

        int vowelSum = calculateVowelSum(soulName);
        int finalResult = NumerologyUtils.reduce(vowelSum);

        soulNumberView.setText(String.valueOf(finalResult));

        int stringRes = getSoulStringRes(finalResult);
        if (stringRes != 0) {
            String html = "Hi " + soulName + ",  " + getString(R.string.soul_definition) + getString(stringRes);
            soulStreamer = TextStreamer.stream(soulDataView, html);
        } else {
            soulDataView.setText("");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (soulStreamer != null) {
            soulStreamer.cancel();
        }
    }

    private int calculateVowelSum(String text) {
        if (TextUtils.isEmpty(text)) {
            return 0;
        }
        int sum = 0;
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char a = text.charAt(i);
            if (a == 'a' || a == 'A') {
                sum += 1;
            } else if (a == 'u' || a == 'U') {
                sum += 3;
            } else if (a == 'e' || a == 'E') {
                sum += 5;
            } else if (a == 'o' || a == 'O') {
                sum += 6;
            } else if (a == 'i' || a == 'I') {
                sum += 9;
            }
        }
        return sum;
    }

    private int getSoulStringRes(int soulNumber) {
        return switch (soulNumber) {
            case 1 -> R.string.soul_1;
            case 2 -> R.string.soul_2;
            case 3 -> R.string.soul_3;
            case 4 -> R.string.soul_4;
            case 5 -> R.string.soul_5;
            case 6 -> R.string.soul_6;
            case 7 -> R.string.soul_7;
            case 8 -> R.string.soul_8;
            case 9 -> R.string.soul_9;
            case 11 -> R.string.soul_11;
            case 22 -> R.string.soul_22;
            default -> 0;
        };
    }
}
