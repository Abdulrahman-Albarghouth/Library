package com.bnaeirtlibrary;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;

import org.jetbrains.annotations.NotNull;

public class KForgotActivity extends AppCompatActivity {

   // FirebaseDatabase firebasedB = FirebaseDatabase.getInstance();
   // DatabaseReference myRef ;
    //FirebaseAuth auth;
   // FirebaseUser user;

    //AlertDialog.Builder builder = new AlertDialog.Builder(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_k_forgot);

        //auth = FirebaseAuth.getInstance();
        //user = auth.getCurrentUser();
    }

    public void UersChangeİsPassword(View v){

        EditText ForgotenTextBox = (EditText) findViewById(R.id.kforgotenPwrdTextBox);
        TextView TexboxEmptiSms    = (TextView) findViewById(R.id.GotenPwrdsms);

        String email     = ForgotenTextBox.getText().toString().trim();

        if(email.equals("")){
            TexboxEmptiSms.setText("Fill the gap");
            TexboxEmptiSms.setTextColor(Color.BLACK);
            return;
        }
        else{
            FirebaseAuth auth;
            auth = FirebaseAuth.getInstance();
            auth.fetchSignInMethodsForEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                        @Override
                        public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {

                            boolean isNewUser = task.getResult().getSignInMethods().isEmpty();

                            if (isNewUser) {

                                Toast.makeText(getApplicationContext(), "This Email has not an existing account",Toast.LENGTH_LONG).show();

                                return;

                            } else {

                                auth.sendPasswordResetEmail(email)
                                        .addOnCompleteListener(new OnCompleteListener() {
                                            @Override
                                            public void onComplete(@NonNull @NotNull Task task) {
                                                if (task.isSuccessful()) {
                                                    // do something when mail was sent successfully.
                                                    Toast.makeText(getApplicationContext(), "password Reset link has been sent to your email adress",Toast.LENGTH_LONG).show();

                                                } else {
                                                    // ...

                                                    Toast.makeText(getApplicationContext(), "password Reset Process fails",Toast.LENGTH_LONG).show();
                                                    ForgotenTextBox.setText("");
                                                }

                                            }
                                        });
                            }

                        }
                    });
        }
    }

}