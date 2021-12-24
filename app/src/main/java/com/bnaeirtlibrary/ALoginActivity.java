package com.bnaeirtlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ALoginActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_login);
        button = (Button) findViewById(R.id.btSifraUn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForgetPasswordActivity();
            }
        });
        button = (Button) findViewById(R.id.btGiris);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openAHomeActivity();
            }
        });
    }
    public void openForgetPasswordActivity(){
        Intent intent = new Intent(this, AForgetPasswordActivity.class);
        startActivity(intent);
    }
    public void openAHomeActivity(View v) {
        EditText etAdminName = (EditText) findViewById(R.id.txKuAd);
        EditText etAdminSifra = (EditText) findViewById(R.id.txSifra);
        TextView tvMessage = findViewById(R.id.tvMessage);
        String username = etAdminName.getText().toString().trim();
        String password = etAdminSifra.getText().toString().trim();

        if (username.equals("")){
            tvMessage.setText("Kulanci adı giriniz.");
            tvMessage.setVisibility(View.VISIBLE);
            tvMessage.setTextColor(Color.RED);
            etAdminName.requestFocus();
            return;
        }
        if (password.equals("")){
            tvMessage.setText("Şifra giriniz.");
            tvMessage.setVisibility(View.VISIBLE);
            tvMessage.setTextColor(Color.RED);
            etAdminSifra.requestFocus();
            return;
        }
        if (username.equals("admin")&&password.equals("123")) {
            Intent intent = new Intent(this, AHomeActivity.class);
            //Intent.putExtra();
            startActivity(intent);
        }
        else {
            tvMessage.setText("Doğru bilgiler giriniz.");
            tvMessage.setVisibility(View.VISIBLE);
            tvMessage.setTextColor(Color.RED);
            etAdminName.requestFocus();
            return;
        }
    }
}