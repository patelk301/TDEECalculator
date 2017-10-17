package com.keyurmpatel.keyur.tdeecalculator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        if(getIntent().hasExtra("com.keyurmpatel.keyur.tdeecalculator.TDEE"))
        {
            TextView tdeeTextView = (TextView) findViewById(R.id.tdeeTextView);
            TextView bmrTextView = (TextView) findViewById(R.id.bmrTextView);
            TextView bmiTextView = (TextView) findViewById(R.id.bmiTextView);


            int TDEE = (int)getIntent().getExtras().getDouble("com.keyurmpatel.keyur.tdeecalculator.TDEE");
            int BMR = (int)getIntent().getExtras().getDouble("com.keyurmpatel.keyur.tdeecalculator.MALEBMR");
            double bmi = getIntent().getExtras().getDouble("com.keyurmpatel.keyur.tdeecalculator.BMI");
            bmi = (double)Math.round(bmi * 10d) / 10d;
            tdeeTextView.setText(TDEE +"");
            tdeeTextView.setTextColor(Color.parseColor("#FFFFFF"));

            bmrTextView.setText(BMR +"");
            bmrTextView.setTextColor(Color.parseColor("#FFFFFF"));

            bmiTextView.setText(bmi +"");{
            if(bmi >18.5 && bmi < 24.9){
                bmiTextView.setTextColor(Color.parseColor("#37a50b"));

            }
            else if(bmi <18.5){
                bmiTextView.setTextColor(Color.parseColor("#1a4d6b"));

            }

            else if(bmi > 24.9 && bmi <29.4){
                bmiTextView.setTextColor(Color.parseColor("#efc109"));

            }
            else if(bmi > 29.4 && bmi <39){
                bmiTextView.setTextColor(Color.parseColor("#ef7409"));

            }
            else{
                bmiTextView.setTextColor(Color.parseColor("#ef0909"));

            }


        }


        }


    }
}
