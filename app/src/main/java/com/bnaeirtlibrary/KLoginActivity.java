 package com.bnaeirtlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

 public class KLoginActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SignInButton signInButton;
    private GoogleApiClient googleApiClient;
    private static final int RC_SIGN_IN = 1;
    String name, email;
    String idToken;

    FirebaseDatabase firebasedB ;
    FirebaseAuth auth;
    FirebaseUser user;
    GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth.AuthStateListener authStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_k_login);
       // TextView textid = (TextView) findViewById(R.id.testid);
        FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
       // user = auth.getCurrentUser();




    }


    public void K_Create_Account(View v) {

        Intent intent = new Intent(this, KSihnupActivity .class);

        startActivity(intent);
    }



    public void login(String email,String password) {
        user = auth.getCurrentUser();
        TextView textid = (TextView) findViewById(R.id.testid);


            auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Users newuser = new Users();
                                //  checkIfEmailVerified();
                                if(user.isEmailVerified()) {
                                   // textid.setText("Email is Verified");// Testing
                                    Intent intent = new Intent(KLoginActivity.this, LandingPageActivity.class);
                                   startActivity(intent);
                                  finish();
                                }
                                else{

                                    //textid.setText("Veillez verifier le message de confirmation envoyé sur cet Email");//Testing
                                    Toast.makeText(getApplicationContext(), "Veillez verifier le message de confirmation envoyé sur cet Email", Toast.LENGTH_LONG).show();
                                    return;
                                }



                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(getApplicationContext(), "Ce compte n'existe pas", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }


    public void Users_Login(View v){
        EditText u_mail = (EditText) findViewById(R.id.K_login_email);
        EditText u_passwrd= (EditText) findViewById(R.id.k_login_password);
        TextView sms = (TextView) findViewById(R.id.K_LoginErrorShowi);

        String u_email = u_mail.getText().toString().trim();
        String u_password = u_passwrd.getText().toString().trim();

        if (!u_email.equals("") && !u_password.equals("")){

                  login(u_email, u_password);
              } else {

                  if (u_email.equals("")) {
                      Toast.makeText(getApplicationContext(), "Enter your Email ", Toast.LENGTH_LONG).show();
                      return;
                  }
                  if (u_password.equals("")) {
                      Toast.makeText(getApplicationContext(), "Enter your password ", Toast.LENGTH_LONG).show();
                      return;
                  }
              }




    }//-----------------End Of Login Function------------------


    public void ForgotPwrdPageopen(View v) {
        Intent intent = new Intent(this, KForgotActivity.class);
        startActivity(intent);
    }
    /*

    public void loginWithGoogle(View view){
        // auth = com.google.firebase.auth.FirebaseAuth.getInstance();

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
       mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }
    */

}