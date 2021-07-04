package com.example.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
        public void callSecondActivity(View view){
            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
            i.putExtra("Value1", "Intent Example");
            i.putExtra("Value2", "Explicit intent");
            startActivity(i);
        }

    }
