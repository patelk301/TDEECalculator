package com.keyurmpatel.keyur.tdeecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;

import static com.keyurmpatel.keyur.tdeecalculator.R.id.heightEditText;
import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Switch maleSwitch =(Switch) findViewById(R.id.maleSwitch);
        final Switch femaleSwitch = (Switch) findViewById(R.id.femaleSwitch);


        final RadioButton actRadioBtn1 =(RadioButton) findViewById(R.id.actRadioBtn1);
        final RadioButton actRadioBtn2 =(RadioButton) findViewById(R.id.actRadioBtn2);
        final RadioButton actRadioBtn3 =(RadioButton) findViewById(R.id.actRadioBtn3);
        final RadioButton actRadioBtn4 =(RadioButton) findViewById(R.id.actRadioBtn4);

        final EditText ageEditText = (EditText) findViewById(R.id.ageEditText);
        final EditText heightEditText1 = (EditText) findViewById(R.id.heightEditText);
        final EditText heightEditText2 = (EditText) findViewById(R.id.heightEditText2);
        final EditText weightEditText = (EditText) findViewById(R.id.weightEditText);

        Button calcButton = (Button) findViewById(R.id.calcButton);
        calcButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {


                Double TDEE;
                Double femaleBMR;
                Double maleBMR;


                //int age = Integer.parseInt(ageEditText.getText().toString());
                String xAge = ageEditText.getText().toString();
                String xFeet = heightEditText1.getText().toString();
                String xInches = heightEditText2.getText().toString();
                String xPounds = weightEditText.getText().toString();

                double pounds;
                int feet;
                int inches;
                int age;


                try {
                    age = parseInt(xAge);
                }
                catch(NumberFormatException ex) {
                    ageEditText.setError("Can't be blank!");
                    return;
                }


                try {
                    pounds = Double.parseDouble(xPounds);
                }
                catch(NumberFormatException ex) {
                    weightEditText.setError("Can't be blank!");
                    return;
                }


                try {
                    feet = parseInt(xFeet);
                }
                catch(NumberFormatException ex) {
                    heightEditText1.setError("Can't be blank!");
                    return;
                }


                try {
                    inches = parseInt(xInches);
                }
                catch(NumberFormatException ex) {
                    heightEditText2.setError("Can't be blank!");
                    return;
                }



                Double heightInCM = (feet * 30.48) + (inches * 2.54);
                Double heightInMeter = heightInCM/100;
                Double weightInKG = (pounds * 0.453592);
                Double divider = heightInMeter*heightInMeter;
                Double bmi = weightInKG/divider;
                maleBMR = 66 + (13.7 * weightInKG) + (5 * heightInCM) - (6.8 * age);
                femaleBMR = 655 + (9.6 * weightInKG) + (1.8 * heightInCM) - (4.7 * age);


                Intent startIntent = new Intent(getApplicationContext(),ResultActivity.class);

                startIntent.putExtra("com.keyurmpatel.keyur.tdeecalculator.MALEBMR", maleBMR);
                startIntent.putExtra("com.keyurmpatel.keyur.tdeecalculator.BMI", bmi);


                if (maleSwitch.isChecked()) {


                    if (actRadioBtn1.isChecked()) {
                        TDEE = 1.2 * maleBMR;
                        startIntent.putExtra("com.keyurmpatel.keyur.tdeecalculator.TDEE", TDEE);


                    } else if (actRadioBtn2.isChecked()) {
                        TDEE = 1.375 * maleBMR;
                        startIntent.putExtra("com.keyurmpatel.keyur.tdeecalculator.TDEE", TDEE);


                    } else if (actRadioBtn3.isChecked()) {
                        TDEE = 1.55 * maleBMR;

                        startIntent.putExtra("com.keyurmpatel.keyur.tdeecalculator.TDEE", TDEE);

                    } else {
                        TDEE = 1.725 * maleBMR;

                        startIntent.putExtra("com.keyurmpatel.keyur.tdeecalculator.TDEE", TDEE);

                    }
                } else if (femaleSwitch.isChecked()) {
                    startIntent.putExtra("com.keyurmpatel.keyur.tdeecalculator.FEMALEBMR", femaleBMR);

                    if (actRadioBtn1.isChecked()) {
                        TDEE = 1.2 * femaleBMR;
                        startIntent.putExtra("com.keyurmpatel.keyur.tdeecalculator.TDEE", TDEE);



                    } else if (actRadioBtn2.isChecked()) {
                        TDEE = 1.375 * femaleBMR;
                        startIntent.putExtra("com.keyurmpatel.keyur.tdeecalculator.TDEE", TDEE);


                    } else if (actRadioBtn3.isChecked()) {
                        TDEE = 1.55 * femaleBMR;
                        startIntent.putExtra("com.keyurmpatel.keyur.tdeecalculator.TDEE", TDEE);

                    } else {
                        TDEE = 1.725 * femaleBMR;

                        startIntent.putExtra("com.keyurmpatel.keyur.tdeecalculator.TDEE", TDEE);

                    }


                }

                startActivity(startIntent);





            }
        });
    }











    ;
}

