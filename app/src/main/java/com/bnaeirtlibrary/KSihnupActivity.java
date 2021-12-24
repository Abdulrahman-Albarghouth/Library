package com.bnaeirtlibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class KSihnupActivity extends AppCompatActivity {

    FirebaseDatabase firebasedB = FirebaseDatabase.getInstance();
    DatabaseReference myRef ;
    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_k_sihnup);
       // auth = FirebaseAuth.getInstance();
        //user = auth.getCurrentUser();


    }


    public void login(String email,String password){

        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task){
                        if (task.isSuccessful()){
                            Users newuser = new Users();

                            Intent intent = new Intent(KSihnupActivity.this,LandingPageActivity.class);
                            startActivity(intent);

                            finish();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(), "This User is not in dB",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }



    public void Signin(View v){
        Intent intent = new Intent(this,KLoginActivity.class);
        startActivity(intent);
    }

    public void Create_User_Account(View v) {

        //---------- Data Member İD TAKİNG------------------
        EditText fullname = (EditText) findViewById(R.id.k_name);
        EditText mail = (EditText) findViewById(R.id.k_Email);
        EditText motdepasse = (EditText) findViewById(R.id.k_Regist_password);
        EditText telphone = (EditText) findViewById(R.id.k_phone);


        TextView choError = (TextView) findViewById(R.id.k_Erreur_display);

        String k_nom = fullname.getText().toString().trim();
        String u_email = mail.getText().toString().trim();
        String u_password = motdepasse.getText().toString().trim();
        String k_phne = telphone.getText().toString().trim();


        if (k_nom.equals("")) {
            choError.setText("please enter Fullname");
            choError.setTextColor(Color.RED);
            return;
        }


        if (u_email.equals(""))  {
            choError.setText("please enter Email");
            choError.setTextColor(Color.RED);
            return;
        }

        if (u_email.contains("@gmail.com")==false)  {
            choError.setText("gmail is not correct");
            choError.setTextColor(Color.RED);
            return;
        }



        if (u_password.equals("")) {

            String value = "Regles du mot de passe:\n" +
                    "caractere minimum: 8\n"+
                    "doit contenir une Grande caractere";
            choError.setText(value);
            choError.setTextColor(Color.RED);
            return;
        }

        if (u_password.length()<8) {
            choError.setText("Password character must be 8 or more");
            choError.setTextColor(Color.RED);
            return;
        }

        if (!u_password.contains("A") & !u_password.contains("B") & !u_password.contains("C")
                & !u_password.contains("D")& !u_password.contains("E") & !u_password.contains("F")
                & !u_password.contains("G") & !u_password.contains("H")& !u_password.contains("I")
        & !u_password.contains("J")& !u_password.contains("K")& !u_password.contains("L")
        & !u_password.contains("M")& !u_password.contains("N")& !u_password.contains("O")
        & !u_password.contains("P")& !u_password.contains("Q")& !u_password.contains("R")
        & !u_password.contains("S")& !u_password.contains("T")& !u_password.contains("U")
        & !u_password.contains("V")& !u_password.contains("W")& !u_password.contains("X")
        & !u_password.contains("Y")& !u_password.contains("Z")){
            choError.setText("Ajoutez une lettre majuscule");
            choError.setTextColor(Color.RED);
            return;
        }

        if (k_phne.equals("")) {
            choError.setText("please enter Number");
            choError.setTextColor(Color.RED);
            return;
        }

        if (k_phne.length()<10 || k_phne.length()>12 || k_phne.length()==11) {
            choError.setText("please Phone must be 10 or 12");
            choError.setTextColor(Color.RED);
            return;
        }

        auth = FirebaseAuth.getInstance();

        auth.fetchSignInMethodsForEmail(u_email)
                .addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                    @Override
                    public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {

                        boolean isNewUser = task.getResult().getSignInMethods().isEmpty();

                        if (isNewUser) {


                            auth.createUserWithEmailAndPassword(u_email, u_password)
                                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (task.isSuccessful()) {

                                                Users newuser = new Users(k_nom,u_email,u_password,k_phne);
                                                myRef = firebasedB.getReference("BookUsers").child(k_phne);

                                                myRef.setValue(newuser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                                                        if(task.isSuccessful()){
                                                            Toast.makeText(getApplicationContext(), "Signup Successful",Toast.LENGTH_LONG).show();
                                                            //Email verification Method
                                                            user = auth.getCurrentUser();
                                                            user.sendEmailVerification();
                                                            Toast.makeText(getApplicationContext(), "Veillez verifier votre Email pour confirmer votre compte",Toast.LENGTH_LONG).show();

                                                           /* if(user.isEmailVerified()==true){

                                                                login(u_email,u_password);
                                                            }

                                                            */
                                                            fullname.setText("");
                                                             mail.setText("");
                                                             telphone.setText("");
                                                             motdepasse.setText("");

                                                            startActivity(new Intent(getApplicationContext(),KLoginActivity.class));//Email verification Method

                                                        }
                                                        else{
                                                            Toast.makeText(getApplicationContext(), "Compte pas créé, re-essayez  ",Toast.LENGTH_LONG).show();

                                                        }
                                                    }
                                                });



                                                //updateUI(user);

                                            } else {

                                                Toast.makeText(getApplicationContext(), "Errorr",Toast.LENGTH_LONG).show();

                                            }
                                        }
                                    });




                            /*
                            auth.createUserWithEmailAndPassword(u_email, u_password);

                            Users newuser = new Users(k_nom,u_email,u_password,k_phne);
                            myRef= firebasedB.getReference("BookUsers").child(k_phne);

                            myRef.setValue(newuser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull @NotNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(getApplicationContext(), "Signup Successful",Toast.LENGTH_LONG).show();

                                        fullname.setText("");
                                        mail.setText("");
                                        telphone.setText("");
                                        motdepasse.setText("");

                                        startActivity(new Intent(getApplicationContext(),KLoginActivity.class));
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(), "Error",Toast.LENGTH_LONG).show();

                                    }
                                }
                            });
                            */

                        } else {
                            Toast.makeText(getApplicationContext(), "This Email is already exist",Toast.LENGTH_LONG).show();

                            return;
                        }

                    }
                });






    }

}