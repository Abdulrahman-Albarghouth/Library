package com.bnaeirtlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AForgetPasswordActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_forget_password);
        button = (Button) findViewById(R.id.btLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ALoginActivity();
            }
        });
        button = (Button) findViewById(R.id.btSifraGonder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PasswordReset();
            }
        });
    }
    public void ALoginActivity() {
        Intent intent = new Intent(this, ALoginActivity.class);
        startActivity(intent);
    }
    public void PasswordReset() {
        EditText etEmail = (EditText) findViewById(R.id.txEmail);
        TextView tvSMessage = findViewById(R.id.tvSMessage);
        String email = etEmail.getText().toString().trim();

        if (email.equals("")){
            tvSMessage.setText("Emailiniz giriniz.");
            tvSMessage.setVisibility(View.VISIBLE);
            tvSMessage.setTextColor(Color.RED);
            etEmail.requestFocus();
            return;
        }
        if (email.equals("admin@admin.com")) {
            Intent intent = new Intent(this, ALoginActivity.class);
            //Intent.putExtra();
            startActivity(intent);
        }
        else {
            tvSMessage.setText("Doğru bilgiler giriniz.");
            tvSMessage.setVisibility(View.VISIBLE);
            tvSMessage.setTextColor(Color.RED);
            etEmail.requestFocus();
            return;
        }
    }
}