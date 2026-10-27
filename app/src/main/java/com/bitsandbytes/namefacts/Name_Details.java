package com.bitsandbytes.namefacts;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Name_Details extends AppCompatActivity {

    private static final String KEY_USER_NAME = "saved_user_name";
    private static final String KEY_RESULT_VISIBLE = "saved_result_visible";

    private LinearLayout hideSection;
    private LinearLayout linear1;
    private EditText fullName;
    private TextView nameCalculate;
    private TextView expression;
    private TextView expressionHeading;
    private TextStreamer expressionStreamer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name__details);

        ViewUtils.applySystemWindowInsetsPadding(findViewById(R.id.root_name_details));

        hideSection = findViewById(R.id.hide);
        linear1 = findViewById(R.id.linear1);
        fullName = findViewById(R.id.full_name);
        ImageView btnSubmit = findViewById(R.id.penNameDetails);
        nameCalculate = findViewById(R.id.NameCalculate);
        expression = findViewById(R.id.expression);
        expressionHeading = findViewById(R.id.expression_heading);
        ImageView soul = findViewById(R.id.soulUrge);

        btnSubmit.setOnClickListener(v -> calculateAndDisplay());

        soul.setOnClickListener(v -> {
            String userName = fullName.getText().toString().trim();
            Intent intent = new Intent(Name_Details.this, Soul_urge.class);
            intent.putExtra("Soul", userName);
            startActivity(intent);
        });

        if (savedInstanceState != null) {
            String savedName = savedInstanceState.getString(KEY_USER_NAME);
            boolean wasVisible = savedInstanceState.getBoolean(KEY_RESULT_VISIBLE, false);
            if (!TextUtils.isEmpty(savedName)) {
                fullName.setText(savedName);
                if (wasVisible) {
                    calculateAndDisplay();
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (expressionStreamer != null) {
            expressionStreamer.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_USER_NAME, fullName.getText().toString());
        outState.putBoolean(KEY_RESULT_VISIBLE, hideSection.getVisibility() == View.VISIBLE);
    }

    @android.annotation.SuppressLint("SetTextI18n")
    private void calculateAndDisplay() {
        // Cancel any in-progress stream before starting a new calculation.
        if (expressionStreamer != null) {
            expressionStreamer.cancel();
        }

        String userName = fullName.getText().toString().trim();
        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(Name_Details.this, "Please enter your full name", Toast.LENGTH_SHORT).show();
            expression.setText("");
            expressionHeading.setVisibility(View.GONE);
            hideSection.setVisibility(View.GONE);
            nameCalculate.setText("");
            return;
        }

        TransitionManager.beginDelayedTransition(linear1);
        hideSection.setVisibility(View.VISIBLE);
        expressionHeading.setVisibility(View.VISIBLE);

        int number = calculateLetterSum(userName);
        int finalNumber = NumerologyUtils.reduce(number);

        nameCalculate.setText(String.valueOf(finalNumber));

        int stringResId = getExpressionStringRes(finalNumber);
        if (stringResId != 0) {
            String messageHtml = "Hi " + userName + " " + getString(R.string.you_are) + " "
                    + getString(stringResId) + getString(R.string.click_pen);
            expressionStreamer = TextStreamer.stream(expression, messageHtml);
        } else {
            expression.setText("");
        }
    }

    private int calculateLetterSum(String name) {
        int sum = 0;
        int length = name.length();
        for (int i = 0; i < length; i++) {
            char c = name.charAt(i);
            if (c == 'a' || c == 'j' || c == 's' || c == 'A' || c == 'J' || c == 'S') {
                sum += 1;
            } else if (c == 'b' || c == 'k' || c == 't' || c == 'B' || c == 'K' || c == 'T') {
                sum += 2;
            } else if (c == 'c' || c == 'l' || c == 'u' || c == 'C' || c == 'L' || c == 'U') {
                sum += 3;
            } else if (c == 'd' || c == 'm' || c == 'v' || c == 'D' || c == 'M' || c == 'V') {
                sum += 4;
            } else if (c == 'e' || c == 'n' || c == 'w' || c == 'E' || c == 'N' || c == 'W') {
                sum += 5;
            } else if (c == 'f' || c == 'o' || c == 'x' || c == 'F' || c == 'O' || c == 'X') {
                sum += 6;
            } else if (c == 'g' || c == 'p' || c == 'y' || c == 'G' || c == 'P' || c == 'Y') {
                sum += 7;
            } else if (c == 'h' || c == 'q' || c == 'z' || c == 'H' || c == 'Q' || c == 'Z') {
                sum += 8;
            } else if (c == 'i' || c == 'r' || c == 'I' || c == 'R') {
                sum += 9;
            }
        }
        return sum;
    }

    private int getExpressionStringRes(int expressionNumber) {
        switch (expressionNumber) {
            case 1:
                return R.string.expression_1;
            case 2:
                return R.string.expression_2;
            case 3:
                return R.string.expression_3;
            case 4:
                return R.string.expression_4;
            case 5:
                return R.string.expression_5;
            case 6:
                return R.string.expression_6;
            case 7:
                return R.string.expression_7;
            case 8:
                return R.string.expression_8;
            case 9:
                return R.string.expression_9;
            case 11:
                return R.string.expression_11;
            case 22:
                return R.string.expression_22;
            default:
                return 0;
        }
    }
}
