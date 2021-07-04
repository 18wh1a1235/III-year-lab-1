package com.example.experiment2b;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button buttonSubmit;
    EditText name;
    EditText password;
    EditText address;
    EditText age;
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView op;

    String date;
    String error;
    String gender;
    String state;
    private int year, month, day;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        op =  (TextView) findViewById(R.id.output);
        name = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.editTextTextPassword);
        address = (EditText) findViewById(R.id.editTextTextPersonName3);
        age = (EditText) findViewById(R.id.editTextTextPersonName4);

        buttonSubmit = (Button)findViewById(R.id.button);

        radioGroup = (RadioGroup)findViewById(R.id.gender);

        Spinner spinner = (Spinner) findViewById(R.id.country);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.countrynames, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                if(name.getText().toString() != null && password.getText().toString() != null && address.getText().toString() != null && age.getText().toString() != null && gender != null && date != null && state != null) {
                    op.setText("Name: " + name.getText().toString() + "\n" + "Password: " + password.getText().toString() + "\n" +
                            "Address: " + address.getText().toString() + "\n" + "Age: " + age.getText().toString() + "\n" +
                            "Gender: " + gender + "\n" + "Date: " + date + "\n" +
                            "State: " + state);
                }else{
                    Toast.makeText(MainActivity.this,"Enter all the details", Toast.LENGTH_SHORT).show();

                }
            }
        });

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;

    }


    public void onRadioButtonClicked(View view) {
        int selectedId=radioGroup.getCheckedRadioButtonId();
        radioButton=(RadioButton)findViewById(selectedId);
        Toast.makeText(MainActivity.this,radioButton.getText(), Toast.LENGTH_SHORT).show();
        gender = (String) radioButton.getText();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        state = (String)parent.getItemAtPosition(position);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(MainActivity.this,"Select the state", Toast.LENGTH_SHORT).show();

    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        date = String.valueOf((new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year)));
    }

}
