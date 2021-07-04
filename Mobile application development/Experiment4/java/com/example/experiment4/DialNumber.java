package com.example.experiment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DialNumber extends AppCompatActivity {
    EditText edittext1;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial_number);
        edittext1=(EditText)findViewById(R.id.number);
        button1=(Button)findViewById(R.id.call);
        button1.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                String number=edittext1.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+number));
                startActivity(callIntent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.example_menu, menu);
        return true;
    }
}
