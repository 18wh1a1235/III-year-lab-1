package com.example.experiment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OpenWebsite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      //  EditText editText =  findViewById(R.id.website);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_website);
        Button b = findViewById(R.id.visitGoogle);
        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://103.241.136.97/"));
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.example_menu, menu);
        return true;
    }
}
