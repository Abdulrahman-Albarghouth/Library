package com.bnaeirtlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class HelpCenterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);
    }

    public void openWhatApp(View view){

        TextView whatspp = (TextView) findViewById(R.id.whatsapp);
        whatspp.setMovementMethod(LinkMovementMethod.getInstance());

    }

    public void openFacebook(View view){

        TextView facebook = (TextView) findViewById(R.id.facebook);
        facebook.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void openInstagram(View view){

        TextView instagram = (TextView) findViewById(R.id.instagram);
        instagram.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void openTwitter(View view){

        TextView twiter = (TextView) findViewById(R.id.twittere);
        twiter.setMovementMethod(LinkMovementMethod.getInstance());
    }
}