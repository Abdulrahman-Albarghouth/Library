package com.bnaeirtlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserEditAccount extends AppCompatActivity {

    FirebaseDatabase firebasedB = FirebaseDatabase.getInstance();
    DatabaseReference myRef ;
    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit_account);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
    }

    public void editeUserAccount(View v) {

        Toast.makeText(getApplicationContext(), "You Can not edit your account, for more information contact Admin", Toast.LENGTH_LONG).show();

/*
        //---------- Data Member İD TAKİNG------------------
        EditText fullname = (EditText) findViewById(R.id.editextfullname);
        EditText oldphonenumber = (EditText) findViewById(R.id.oldnumber);
        EditText newtelphone = (EditText) findViewById(R.id.newnumber);


        TextView choError = (TextView) findViewById(R.id.k_Erreur_display);

        String k_nom = fullname.getText().toString().trim();
        String k_oldnumber = oldphonenumber.getText().toString().trim();
        String k_newphne = newtelphone.getText().toString().trim();


        if (k_nom.equals("")) {
            Toast.makeText(getApplicationContext(), "Enter Name", Toast.LENGTH_LONG).show();
            return;
        }


        if (k_oldnumber.equals("")) {
            Toast.makeText(getApplicationContext(), "Enter Old Number", Toast.LENGTH_LONG).show();
            return;
        }
        if (k_newphne.equals("")) {
            Toast.makeText(getApplicationContext(), "Enter New Number", Toast.LENGTH_LONG).show();
            return;
        }

        Users newuser = new Users(k_nom, k_oldnumber, k_newphne);
        myRef = firebasedB.getReference("BookUsers").child(k_oldnumber);

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.getValue() == null) {
                    // The child doesn't exist
                    Toast.makeText(getApplicationContext(), "Invalide old Number", Toast.LENGTH_LONG).show();
                  return;
                }
                else{

                    //myRef.setValue(newuser);
                    Toast.makeText(getApplicationContext(), "Account Editting not Avaible Actually please Contact system administrateur", Toast.LENGTH_LONG).show();
                    fullname.setText("");
                    oldphonenumber.setText("");
                    newtelphone.setText("");
                    startActivity(new Intent(getApplicationContext(),LandingPageActivity.class));
                     finish();
                }

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }

        });

 */
    }


    }