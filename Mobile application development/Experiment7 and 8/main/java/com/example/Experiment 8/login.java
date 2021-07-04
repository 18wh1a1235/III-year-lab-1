package com.example.experiment8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    boolean isPresent;

    DBHelper openhelper;
    EditText e1,e2;
    Button b1;
    public String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1 = (EditText)findViewById(R.id.Email);
        e2 = (EditText)findViewById(R.id.Password);
        b1 = (Button)findViewById(R.id.Login);
        openhelper = new DBHelper(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = e1.getText().toString();
                String pass = e2.getText().toString();
                isPresent = openhelper.isValidLogin(email,pass);
                if(isPresent) {
                    Toast.makeText(getApplicationContext(), "Logged in successfully", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Looks like you have entered something wrong,check and refill the details", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}