package com.bitsandbytes.namefacts;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Name_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name__details);

        final LinearLayout Hide = findViewById(R.id.hide);
        final EditText fullName = findViewById(R.id.full_name);
        ImageView btn_submit = findViewById(R.id.penNameDetails);
        final TextView nameCalculate = findViewById(R.id.NameCalculate);
        final TextView Expression = findViewById(R.id.expression);
        final TextView FactsAbout = findViewById(R.id.facts_about);
        ImageView soul = findViewById(R.id.soulUrge);



       btn_submit.setOnClickListener(new View.OnClickListener() {
           @SuppressLint("SetTextI18n")
           @Override
           public void onClick(View v) {
               String userName = fullName.getText().toString().trim();
               if (!TextUtils.isEmpty(userName)) {

                   FactsAbout.setText("about"+" "+userName);

                   if (Hide.getVisibility() == View.VISIBLE) {
                       Hide.setVisibility(View.INVISIBLE);


                   } else {
                       Hide.setVisibility(View.VISIBLE);
                   }


               } else {
                   Toast.makeText(Name_Details.this, "Please enter your full name", Toast.LENGTH_SHORT).show();
                   Expression.setText("");
                   Hide.setVisibility(View.INVISIBLE);
                   FactsAbout.setText(" ");
               }

               int size, counter = 0, number = 0;
               char a;
               size = userName.length();
               while (counter < size) {
                   a = userName.charAt(counter);
                   if (a == 'a' || a == 'j' || a == 's'
                           || a == 'A' || a == 'J' || a == 'S') {
                       number += 1;
                   } else if (a == 'b' || a == 'k' || a == 't'
                           || a == 'B' || a == 'K' || a == 'T') {
                       number += 2;
                   } else if (a == 'c' || a == 'l' || a == 'u'
                           || a == 'C' || a == 'L' || a == 'U') {
                       number += 3;
                   } else if (a == 'd' || a == 'm' || a == 'v'
                           || a == 'D' || a == 'M' || a == 'V') {
                       number += 4;
                   } else if (a == 'e' || a == 'n' || a == 'w'
                           || a == 'E' || a == 'N' || a == 'W') {
                       number += 5;
                   } else if (a == 'f' || a == 'o' || a == 'x'
                           || a == 'F' || a == 'O' || a == 'X') {
                       number += 6;
                   } else if (a == 'g' || a == 'p' || a == 'y'
                           || a == 'G' || a == 'P' || a == 'Y') {
                       number += 7;
                   } else if (a == 'h' || a == 'q' || a == 'z'
                           || a == 'H' || a == 'Q' || a == 'Z') {
                       number += 8;
                   } else if (a == 'i' || a == 'r'
                           || a == 'I' || a == 'R') {
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
               int finalist = 0, rem, finalResult = 0;
               finalist += result;
               while (finalist > 0) {
                   rem = finalist % 10;
                   finalResult += rem;
                   finalist = finalist / 10;

               }
               if (number == 11 || number == 22) {
                   finalist = number;

               } else {
                   finalist = finalResult;
               }

               nameCalculate.setText(Integer.toString(finalist));
               int ExpressionInt = Integer.parseInt(nameCalculate.getText().toString());

               if (ExpressionInt == 3) {
                   Expression.setText(Html.fromHtml("Hi" + " " + fullName.getText().toString() + " " + getString(R.string.you_are) + getString(R.string.expression_3)+ getString(R.string.click_pen)));
               } else if (ExpressionInt == 2) {
                   Expression.setText(Html.fromHtml("Hi" + " " + fullName.getText().toString() + " " + getString(R.string.you_are) + getString(R.string.expression_2)+ getString(R.string.click_pen)));
               } else if (ExpressionInt == 4) {
                   Expression.setText(Html.fromHtml("Hi" + " " + fullName.getText().toString() + " " + getString(R.string.you_are) + getString(R.string.expression_4)+ getString(R.string.click_pen)));
               } else if (ExpressionInt == 5) {
                   Expression.setText(Html.fromHtml("Hi" + " " + fullName.getText().toString() + " " + getString(R.string.you_are) + getString(R.string.expression_5)+ getString(R.string.click_pen)));
               } else if (ExpressionInt == 6) {
                   Expression.setText(Html.fromHtml("Hi" + " " + fullName.getText().toString() + " " + getString(R.string.you_are)+ getString(R.string.expression_6)+ getString(R.string.click_pen)));
               } else if (ExpressionInt == 7) {
                   Expression.setText(Html.fromHtml("Hi" + " " + fullName.getText().toString() + " " + getString(R.string.you_are) + getString(R.string.expression_7)+ getString(R.string.click_pen)));
               } else if (ExpressionInt == 8) {
                   Expression.setText(Html.fromHtml("Hi" + " " + fullName.getText().toString() + " " + getString(R.string.you_are)+ getString(R.string.expression_8)+ getString(R.string.click_pen)));
               } else if (ExpressionInt == 9) {
                   Expression.setText(Html.fromHtml("Hi" + " " + fullName.getText().toString() + " " + getString(R.string.you_are) + getString(R.string.expression_9)+ getString(R.string.click_pen)));
               } else if (ExpressionInt == 1) {
                   Expression.setText(Html.fromHtml("Hi" + " " + fullName.getText().toString() + " " + getString(R.string.you_are) + getString(R.string.expression_1)+ getString(R.string.click_pen)));
               } else if (ExpressionInt == 11) {
                   Expression.setText(Html.fromHtml("Hi" + " " + fullName.getText().toString() + " " +R.string.you_are + getString(R.string.expression_11)+ getString(R.string.click_pen)));
               } else if (ExpressionInt == 22) {
                   Expression.setText(Html.fromHtml("Hi" + " " + fullName.getText().toString() + " " + getString(R.string.you_are) + getString(R.string.expression_22)+ getString(R.string.click_pen)));
               }

           }

       });
        soul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserName = fullName.getText().toString();
                Intent intent = new Intent(getApplicationContext(), Soul_urge.class);
                intent.putExtra("Soul", UserName);
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
