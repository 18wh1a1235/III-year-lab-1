package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    TextView tv;
    Button buttonSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv =  (TextView) findViewById(R.id. textView);
        buttonSubmit = (Button)findViewById(R.id.button);
        editName = (EditText) findViewById(R.id.editName);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String st =  editName.getText().toString();
                tv.setText("Hello " + st + "!");
            }
        });
    }}
