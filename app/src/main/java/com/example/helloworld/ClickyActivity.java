package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClickyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicky);
        Button buttonA = findViewById(R.id.buttonA);
        buttonA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button A");

                ((TextView)findViewById(R.id.pressText)).setText("Press: A");
            }
        });
        Button buttonB = findViewById(R.id.buttonB);
        buttonB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button B");

                ((TextView)findViewById(R.id.pressText)).setText("Press: B");
            }
        });
        Button buttonC = findViewById(R.id.buttonC);
        buttonC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button C");

                ((TextView)findViewById(R.id.pressText)).setText("Press: C");
            }
        });
        Button buttonD = findViewById(R.id.buttonD);
        buttonD.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button D");

                ((TextView)findViewById(R.id.pressText)).setText("Press: D");
            }
        });
        Button buttonE = findViewById(R.id.buttonE);
        buttonE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button E");

                ((TextView)findViewById(R.id.pressText)).setText("Press: E");
            }
        });
        Button buttonF = findViewById(R.id.buttonF);
        buttonF.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button F");

                ((TextView)findViewById(R.id.pressText)).setText("Press: F");
            }
        });
    }
}