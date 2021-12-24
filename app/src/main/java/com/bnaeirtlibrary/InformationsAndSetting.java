package com.bnaeirtlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

public class InformationsAndSetting extends AppCompatActivity {
     ScrollView scrollView;
    TextView page;
    String mykey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scrollView = (ScrollView) findViewById(R.id.scrolview);
        setContentView(R.layout.activity_informations_and_setting);
        page = findViewById(R.id.ortakinfo);
        Intent secondintent = getIntent();
        mykey = secondintent.getStringExtra("key");
        //scrollView.setText(mykey);
        page.setText(mykey);
        if(mykey.contains("Let's")){
            page.setTextColor(Color.BLUE);
            page.setTextSize(30);
        }


    }
}