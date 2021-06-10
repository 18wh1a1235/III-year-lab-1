package com.example.experiment2a;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    TextView tv7;
    Button b;
    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    RadioGroup radioSexGroup;
    RadioButton radioSexButton;
    DatePicker dob;
    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.TextView7);
        tv2 = findViewById(R.id.TextView9);
        tv3 = findViewById(R.id.TextView10);
        tv4 = findViewById(R.id.TextView12);
        tv5 = findViewById(R.id.TextView11);
        tv6 = findViewById(R.id.TextView12);
        tv7 = findViewById(R.id.TextView14);
        b = findViewById(R.id.button1);
        et1 = findViewById(R.id.EditText1);
        et2 = findViewById(R.id.EditText2);
        et3 = findViewById(R.id.EditText3);
        et4 = findViewById(R.id.EditText4);
        dob = findViewById(R.id.datepicker);
        sp =(Spinner)findViewById(R.id.spinner);
        TextView details;
        details = findViewById(R.id.details);
        details.setText("Check your Details here");
        b.setOnClickListener(new View.OnClickListener() {
            @NonNull
            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }

            @Override
            public void onClick(View v) {
                String st = et1.getText().toString();
                String st1 = et2.getText().toString();
                String st2 = et3.getText().toString();
                String st3 = et4.getText().toString();
                tv1.setText("Username: " +st);
                tv2.setText("Password: " + st1);
                tv3.setText("Address: " +st2);
                tv4.setText("Age: " + st3);
                onRadioButtonClicked();
                int st5 = dob.getDayOfMonth();
                int st6 = dob.getMonth()+1;
                int st7 = dob.getYear();
                tv6.setText("The Date of Birth is: " + st5 +"/" + st6 + "/" + st7);
                String size = sp.getSelectedItem().toString();
                tv7.setText("Country: " + size);
            }
        });
    }
    public void onRadioButtonClicked() {
        radioSexGroup = findViewById(R.id.radioGrp);
        int selectedId = radioSexGroup.getCheckedRadioButtonId();
        radioSexButton = (RadioButton) findViewById(selectedId);
        String st4 = radioSexButton.getText().toString();
        tv5.setText("Gender: " + st4);
    }
}
