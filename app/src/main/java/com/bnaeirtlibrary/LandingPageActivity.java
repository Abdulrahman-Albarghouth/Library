package com.bnaeirtlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LandingPageActivity extends AppCompatActivity {

    FirebaseDatabase firebasedB;
    DatabaseReference myRef ;
    FirebaseAuth auth;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
    }

    public void select_Science_Books(View v) {

        String value = "Science";
        Intent intent = new Intent( LandingPageActivity.this, BookActivityPage.class);
        intent.putExtra("key", value);

        startActivity(intent);

    }

    public void select_Literature_Books(View v) {

        String value = "Literature";
        Intent intent = new Intent(LandingPageActivity.this, BookActivityPage.class);
        intent.putExtra("key", value);

        startActivity(intent);

    }

    public void select_Coding_Books(View v) {

        String value = "Coding";
        Intent intent = new Intent(LandingPageActivity.this, BookActivityPage.class);
        intent.putExtra("key", value);

        startActivity(intent);

    }

    public void select_Network_Books(View v) {

        String value = "Network";
        Intent intent = new Intent(LandingPageActivity.this, BookActivityPage.class);
        intent.putExtra("key", value);

        startActivity(intent);

    }

    public void select_Security_Books(View v) {

        String value = "Coding";
        Intent intent = new Intent(LandingPageActivity.this, BookActivityPage.class);
        intent.putExtra("key", value);

        startActivity(intent);

    }

    public void select_Technology_Books(View v) {

        String value = "Technology";
        Intent intent = new Intent(LandingPageActivity.this, BookActivityPage.class);
        intent.putExtra("key", value);

        startActivity(intent);

    }

    public void select_Architecture_Books(View v) {

        String value = "Architecture";
        Intent intent = new Intent(LandingPageActivity.this, BookActivityPage.class);
        intent.putExtra("key", value);

        startActivity(intent);

    }

    public void select_Engineering_Books(View v) {

        String value = "Engineering";
        Intent intent = new Intent(LandingPageActivity.this, BookActivityPage.class);
        intent.putExtra("key", value);

        startActivity(intent);

    }

    public void select_Art_Books(View v) {

        String value = "Art";
        Intent intent = new Intent(LandingPageActivity.this, BookActivityPage.class);
        intent.putExtra("key", value);

        startActivity(intent);

    }

    public void select_Turkish_Books(View v) {

        String value = "Turkish";
        Intent intent = new Intent(LandingPageActivity.this, BookActivityPage.class);
        intent.putExtra("key", value);

        startActivity(intent);

    }


    public void select_Health_Books(View v) {

        String value = "Health";
        Intent intent = new Intent(LandingPageActivity.this, BookActivityPage.class);
        intent.putExtra("key", value);

        startActivity(intent);

    }

    public void select_Communication_Books(View v) {

        String value = "Communication";
        Intent intent = new Intent(LandingPageActivity.this, BookActivityPage.class);
        intent.putExtra("key", value);

        startActivity(intent);

    }

     public void select_Economi_Books(View v) {

        String value = "Economics";
        Intent intent = new Intent(LandingPageActivity.this, BookActivityPage.class);
        intent.putExtra("key", value);

        startActivity(intent);

    }

    public void select_Business_Books(View v) {

        String value = "Business";
        Intent intent = new Intent(LandingPageActivity.this, BookActivityPage.class);
        intent.putExtra("key", value);

        startActivity(intent);

    }

    public void select_African_Books(View v) {

        String value = "African";
        Intent intent = new Intent(LandingPageActivity.this, BookActivityPage.class);
        intent.putExtra("key", value);

        startActivity(intent);

    }


    public void select_Romans_Books(View v) {

        String value = "Romans";
        Intent intent = new Intent(LandingPageActivity.this, BookActivityPage.class);
        intent.putExtra("key", value);

        startActivity(intent);

    }


    public void select_Others_Books(View v) {

        String value = "Other";
        Intent intent = new Intent(LandingPageActivity.this, BookActivityPage.class);
        intent.putExtra("key", value);

        startActivity(intent);

    }
















    //------------------------------------------------------------

    public void logOut(View v){

        auth.signOut();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

        finish();

    }

    public void showProfile(View view){

        startActivity(new Intent(getApplicationContext(),Userinformations.class));

    }


}