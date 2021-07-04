package com.example.experiment4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent i = new Intent(this, DialNumber.class);
                startActivity(i);
               // Toast.makeText(this,"Dial Number",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Intent i2 = new Intent(this, SendSMS.class);
                startActivity(i2);
                //Toast.makeText(this,"Send SMS",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Intent i3 = new Intent(this, OpenWebsite.class);
                startActivity(i3);
            //    Toast.makeText(this,"Open Website",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
