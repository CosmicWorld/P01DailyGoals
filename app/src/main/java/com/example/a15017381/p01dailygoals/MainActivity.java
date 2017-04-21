package com.example.a15017381.p01dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button1);

        //When clicking on the button to proceed to the next activity
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {

                //RadioGroup
                RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                RadioButton rb1 = (RadioButton) findViewById(selectedButtonId1);

                RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                RadioButton rb2 = (RadioButton) findViewById(selectedButtonId2);

                RadioGroup rg3 = (RadioGroup) findViewById(R.id.radioGroup3);
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();
                RadioButton rb3 = (RadioButton) findViewById(selectedButtonId3);

                //EditText for Reflection
                EditText et = (EditText) findViewById(R.id.editText);

                //Making all the variables in to an array
                String[] info = {rb1.getText().toString(),
                        rb2.getText().toString(),
                        rb3.getText().toString(),
                        et.getText().toString()};

                //Intent for the next class (SummaryActivity)
                Intent i = new Intent(MainActivity.this,
                        SummaryActivity.class);
                i.putExtra("info", info);
                startActivity(i);
            }
        });
    }

    //Advanced Enhancement
    @Override
    protected void onPause() {
        super.onPause();
        // Getting Files
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
        int selectedButtonId1 = rg1.getCheckedRadioButtonId();

        RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        int selectedButtonId2 = rg2.getCheckedRadioButtonId();

        RadioGroup rg3 = (RadioGroup) findViewById(R.id.radioGroup3);
        int selectedButtonId3 = rg3.getCheckedRadioButtonId();

        EditText et = (EditText) findViewById(R.id.editText);
        String str = et.getText().toString();

        //Saving

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = pref.edit();
        //Saving Data
        prefEdit.putInt("RadioButton1", selectedButtonId1);
        prefEdit.putInt("RadioButton2", selectedButtonId2);
        prefEdit.putInt("RadioButton3", selectedButtonId3);
        prefEdit.putString("et", str);

        //Commit
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Get Data
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        int rb1 = pref.getInt("RadioButton1", 0);
        int rb2 = pref.getInt("RadioButton2", 0);
        int rb3 = pref.getInt("RadioButton3", 0);
        String str = pref.getString("et", "");

        //Getting the Views
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        RadioGroup rg3 = (RadioGroup) findViewById(R.id.radioGroup3);
        EditText et = (EditText) findViewById(R.id.editText);

        //Setting back to the Views
        et.setText(str);
        rg1.check(rb1);
        rg2.check(rb2);
        rg3.check(rb3);
    }
}
