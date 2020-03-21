package com.bitsandbytes.namefacts;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Soul_urge extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soul_urge);

        Intent intent = getIntent();
        String vowels = intent.getStringExtra("Soul");
        Log.d("Ashutosh", "String Loaded: " + vowels);

        TextView soulNumber = findViewById(R.id.soulUrge_Number);
        TextView soulData = findViewById(R.id.SoulUrge_data);
        ImageView share = findViewById(R.id.buttonShareImage);
        final TextView FactsAbout = findViewById(R.id.facts_about);


        FactsAbout.setText(R.string.about + " " + intent.getStringExtra("Soul"));
        int size, counter = 0, number = 0;
        char a;
        size = vowels.length();
        while (counter < size) {
            a = vowels.charAt(counter);
            if (a == 'a' || a == 'A') {
                number += 1;
            } else if (a == 'u' || a == 'U') {
                number += 3;
            } else if (a == 'e' || a == 'E') {
                number += 5;
            } else if (a == 'o' || a == 'O') {
                number += 6;
            } else if (a == 'i' || a == 'I') {
                number += 9;
            }
            counter++;
        }
        int total = 0, remainder, result = 0;
        total += number;
        while (total > 0) {
            remainder = total % 10;
            result += remainder;
            total = total / 10;

        }
        int tot, finalResult = 0;
        while (result != 0) {
            tot = result % 10;
            finalResult += tot;
            result /= 10;

        }
        soulNumber.setText(String.valueOf(finalResult));

        if (finalResult == 1) {
            soulData.setText(Html.fromHtml("Hi" + " " + intent.getStringExtra("Soul") + ",  " + getString(R.string.soul_definition) + getString(R.string.soul_1)));
        } else if (finalResult == 2) {
            soulData.setText(Html.fromHtml("Hi" + " " + intent.getStringExtra("Soul") + ",  " + getString(R.string.soul_definition) + getString(R.string.soul_2)));

        } else if (finalResult == 3) {
            soulData.setText(Html.fromHtml("Hi" + " " + intent.getStringExtra("Soul") + ",  " + getString(R.string.soul_definition) + getString(R.string.soul_3)));

        } else if (finalResult == 4) {
            soulData.setText(Html.fromHtml("Hi" + " " + intent.getStringExtra("Soul") + ",  " + getString(R.string.soul_definition) + getString(R.string.soul_4)));

        } else if (finalResult == 5) {
            soulData.setText(Html.fromHtml("Hi" + " " + intent.getStringExtra("Soul") + ",  " + getString(R.string.soul_definition) + getString(R.string.soul_5)));

        } else if (finalResult == 6) {
            soulData.setText(Html.fromHtml("Hi" + " " + intent.getStringExtra("Soul") + ",  " + getString(R.string.soul_definition) + getString(R.string.soul_6)));

        } else if (finalResult == 7) {
            soulData.setText(Html.fromHtml("Hi" + " " + intent.getStringExtra("Soul") + ",  " + getString(R.string.soul_definition) + getString(R.string.soul_7)));

        } else if (finalResult == 8) {
            soulData.setText(Html.fromHtml("Hi" + " " + intent.getStringExtra("Soul") + ",  " + getString(R.string.soul_definition) + getString(R.string.soul_8)));

        } else if (finalResult == 9) {
            soulData.setText(Html.fromHtml("Hi" + " " + intent.getStringExtra("Soul") + ",  " + getString(R.string.soul_definition) + getString(R.string.soul_9)));

        } else if (finalResult == 11) {
            soulData.setText(Html.fromHtml("Hi" + " " + intent.getStringExtra("Soul") + ",  " + getString(R.string.soul_definition) + getString(R.string.soul_11)));

        } else if (finalResult == 22) {
            soulData.setText(Html.fromHtml("Hi" + " " + intent.getStringExtra("Soul") + ",  " + getString(R.string.soul_definition) + getString(R.string.soul_22)));

        }

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "Support and follow our page https://www.instagram.com/bits._.and._.bytes/\n\n\n" +
                        "Download our app https://play.google.com/store/apps/details?id=com.bitbytes.namefacts";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share using"));
            }
        });

    }


    private Boolean exit = false;

    @Override
    public void onBackPressed() {
        if (exit) {
            finish();
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }

    }
}
