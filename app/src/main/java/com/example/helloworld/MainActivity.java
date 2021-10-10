package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    //create the main activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //A3 Assignment ClickyClikcy
        Button buttonClicky = findViewById(R.id.clicky);
        buttonClicky.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");

                Intent activity2Intent = new Intent(getApplicationContext(), ClickyActivity.class);
                startActivity(activity2Intent);
            }
        });
        //A4 Assignment Link Collector
        Button buttonLinkCollector = findViewById(R.id.linkCollector);
        buttonLinkCollector.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Link Collector");

                Intent activity3Intent = new Intent(getApplicationContext(), LinkCollector.class);
                startActivity(activity3Intent);
            }
        });
        //A5 Assignment Locator
        Button buttonLocator = findViewById(R.id.Locator);
        buttonLocator.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Locator");

                Intent activity4Intent = new Intent(getApplicationContext(), LocatorActivity.class);
                startActivity(activity4Intent);
            }
        });
    }
    //Click button and show the Toast Msg
    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }
    public void displayToastMsg(View v) {
        toastMsg("Name: Zhen Xu" +'\n'+"Email: xu.zhen2@northeastern.edu");
    }
}