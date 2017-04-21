package com.example.a15017381.p01dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Button btn = (Button) findViewById(R.id.buttonDone);
        Intent i = getIntent();
        String[] info = i.getStringArrayExtra("info");
        TextView tv = (TextView) findViewById(R.id.textView);
        //Printing out on the TextView by calling out the array
        tv.setText("Read up on materials before class : " + info[0] + "\nArrive on time so as not to miss important part of the lesson : " + info[1] + "\nAttempt the problem myself : " + info[2] + "\nReflection : " + info[3]);

        //Intermediate Enhancement (Button that allow to close the Summary Activity
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }
}
