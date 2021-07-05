package com.example.programm6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    public static String file="Exp6MAD.txt";
    EditText uname,password;
    Button save,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname=(EditText)findViewById(R.id.editText1);
        password=(EditText)findViewById(R.id.editText2);
        save=(Button)findViewById(R.id.button);
        login=(Button)findViewById(R.id.button2);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileOutputStream fout = openFileOutput(file,MODE_PRIVATE);
                    String data = uname.getText().toString()+" "+password.getText().toString();
                    fout.write(data.getBytes());
                    fout.close();
                    Toast.makeText(getBaseContext(),"details saved"+getFileStreamPath(file),Toast.LENGTH_SHORT).show();


                }catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname_ = uname.getText().toString();
                String password_=password.getText().toString();
                try{

                    FileInputStream fin = openFileInput(file);
                    int c;
                    String temp="";
                    while((c=fin.read())!=-1){
                        temp=temp+Character.toString((char)c);
                    }
                    String file_read[]=temp.split("\n");
                    boolean isFound=false;
                    for(String record:file_read){
                        String details[]=record.split(" ");
                        if(details[0].equalsIgnoreCase(uname_) && details[1].equalsIgnoreCase(password_)){
                            isFound=true;
                            break;
                        }
                    }
                    if(isFound){
                        Toast.makeText(getBaseContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getBaseContext(),"Invalid Credentials",Toast.LENGTH_SHORT).show();
                    }

                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        });
    }
}
