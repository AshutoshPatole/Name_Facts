package com.bitsandbytes.namefacts;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DOB_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dob__details);

        TextView textView = findViewById(R.id.Texr);
        ImageView penNext = findViewById(R.id.btn_name);
        TextView date_of_birth = findViewById(R.id.DOB);
        Intent intent = getIntent();
        int message = intent.getIntExtra("DOB", 0);

        date_of_birth.setText(String.valueOf(message));

        int value = Integer.parseInt(date_of_birth.getText().toString());

        if (value == 1) {
            textView.setText(getString(R.string.life_1));
        } else if (value == 2) {
            textView.setText(getString(R.string.life_2));
        } else if (value == 3) {
            textView.setText(getString(R.string.life_3));
        } else if (value == 4) {
            textView.setText(getString(R.string.life_4));
        } else if (value == 5) {
            textView.setText(getString(R.string.life_5));
        } else if (value == 6) {
            textView.setText(getString(R.string.life_6));
        } else if (value == 7) {
            textView.setText(getString(R.string.life_7));
        } else if (value == 8) {
            textView.setText(getString(R.string.life_8));
        } else if (value == 9) {
            textView.setText(getString(R.string.life_9));
        } else if (value == 11) {
            textView.setText(getString(R.string.life_11));
        } else if (value == 22) {
            textView.setText(getString(R.string.life_22));
        }

        penNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DOB_Details.this, Name_Details.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
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
