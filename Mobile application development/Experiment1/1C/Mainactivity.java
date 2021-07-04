package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText e;
    Button b;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e = (EditText)findViewById(R.id.EditText);
        b = (Button)findViewById(R.id.button);
        t = (TextView)findViewById(R.id.textView3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = e.getText().toString();
                t.setText("Hi "+s);
            }
        });
    }
}
