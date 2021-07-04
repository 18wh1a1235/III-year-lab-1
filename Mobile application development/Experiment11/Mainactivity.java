package com.example.shareedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText name, age;
    private RadioButton radiomale, radiofemale;
    private RadioGroup radioGroupGender;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.edit1);
        age = findViewById(R.id.edit2);
        radiofemale = findViewById(R.id.radioFemale);
        radiomale = findViewById(R.id.radioMale);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        prefs = getSharedPreferences("sharedPref", MODE_PRIVATE);
    }


    public void saveContent(View view) {
        if (name.getText().toString().equals("") || age.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Enter the details", Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferences.Editor myEdit = prefs.edit();
            myEdit.putString("name", name.getText().toString());
            myEdit.putInt("age", Integer.parseInt(age.getText().toString()));
            myEdit.putBoolean("gender_female", radiofemale.isChecked());
            myEdit.putBoolean("gender_male", radiomale.isChecked());
            myEdit.apply();
            Toast.makeText(getApplicationContext(),"Data saved/updated",Toast.LENGTH_LONG).show();

        }
    }
    public void showContent(View view) {

        String s1 = prefs.getString("name", "");
        int a = prefs.getInt("age", 0);
        boolean f = prefs.getBoolean("gender_female",false);
        boolean m = prefs.getBoolean("gender_male",false);
        name.setText(s1);
        age.setText(String.valueOf(a));
        radioGroupGender.clearCheck();
        radiofemale.setChecked(f);
        radiomale.setChecked(m);
        Toast.makeText(getApplicationContext(),"Data displayed",Toast.LENGTH_LONG).show();

    }
    public void clearContent(View view){
        if (name.getText().toString().equals("") || age.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(),"Nothing to Clear",Toast.LENGTH_LONG).show();

        name.setText("");
        age.setText("");
        radiofemale.setChecked(false);
        radiomale.setChecked(false);
        Toast.makeText(getApplicationContext(),"Data cleared",Toast.LENGTH_LONG).show();
    }
}
