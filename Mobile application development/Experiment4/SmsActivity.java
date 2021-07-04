package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsActivity  extends AppCompatActivity {
    EditText phoneNum,message;
    Button Send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        phoneNum = (EditText)findViewById(R.id.editText1);
        message = (EditText)findViewById(R.id.editText2);
        Send = (Button)findViewById(R.id.button);
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no=phoneNum.getText().toString();
                String msg=message.getText().toString();


                Intent intent=new Intent(getApplicationContext(),SmsActivity.class);
                PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),0,intent,0);


                SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage(no, null, msg, pi,null);

                Toast.makeText(getApplicationContext(), "Message Sent successfully!",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
