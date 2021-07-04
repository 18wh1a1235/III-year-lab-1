package com.example.experiment8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditRecord extends AppCompatActivity {
    DBHelper db;
    EditText e1,e2,e3;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_record);
        db = new DBHelper(this);
        e1 = findViewById(R.id.editTextTextEmailAddress);
        e2 = findViewById(R.id.editTextTextPassword2);
        e3 = findViewById(R.id.editTextTextPersonName7);
        b = findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailid = e1.getText().toString();
                String name = e2.getText().toString();
                String password = e3.getText().toString();
                boolean isUpdated = db.updateRecord(emailid,name,password);
                if(isUpdated){
                    Toast.makeText(EditRecord.this,"Record updated",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(EditRecord.this,"Email id not found",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
