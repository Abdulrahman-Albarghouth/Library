package com.bnaeirtlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase firebasedB;
    DatabaseReference myRef ;
    FirebaseAuth auth;
    FirebaseUser user;


    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //(user.isEmailVerified() == true)
        FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

            if(user!=null){
                user.reload();
              if(  (user.isEmailVerified())){
                  // User is sign in
                  Intent intent = new Intent(this, LandingPageActivity.class);
                  startActivity(intent);
                  finish();
              }

            }


       // onStart();

        //-----------------------------------------------------
        button = (Button) findViewById(R.id.btKullanicilar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openKullaniciActivity();
            }
        });
        //--------------------------------------------------------------
       /* button = (Button) findViewById(R.id.btAdmin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdminActivity();
            }
        });

        */
        //--------------------------------------------------------------



    }
    public void openKullaniciActivity() {
        Intent intent = new Intent(this, KLoginActivity.class);
        startActivity(intent);
    }
    //-----------------------------------------------------------------------------
    /*public void openAdminActivity() {
        Intent intent = new Intent(this, AHomeActivity.class);
        startActivity(intent);
    }

     */
    //-----------------------------------------------------------------------------

}