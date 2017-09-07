package com.example.jiyoungkim.blindtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FourthActivity extends Activity {
    CheckBox ch1;
    CheckBox ch2;
    CheckBox ch3;
    CheckBox ch4;
    String result1="";
    String result2="";
    String result3="";
    String result4="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_main);

        Intent intent = getIntent();
        result1 = intent.getStringExtra("result1");
        result2 = intent.getStringExtra("result2");
        result3 = intent.getStringExtra("result3");

        ch1 = (CheckBox)findViewById(R.id.fourthTest1);
        ch2 = (CheckBox)findViewById(R.id.fourthTest2);
        ch3 = (CheckBox)findViewById(R.id.fourthTest3);
        ch4 = (CheckBox)findViewById(R.id.fourthTest4);
    }

    public void nextClick(View v) {
        Intent intent = new Intent(FourthActivity.this, FifthActivity.class);
        //원, 세모:정상인, 세모:황청색맹

        if (!ch1.isChecked() && !ch2.isChecked() && !ch3.isChecked() && !ch4.isChecked()) {
            Toast.makeText(FourthActivity.this, "보기를 선택해주세요.", Toast.LENGTH_SHORT).show();
        } else {
            if (ch2.isChecked() && ch3.isChecked() && !ch1.isChecked() && !ch4.isChecked()) {
                result4 = getString(R.string.normal);
            } else if (!ch2.isChecked() && ch3.isChecked() && !ch1.isChecked() && !ch4.isChecked()) {
                result4 = getString(R.string.redblue_meng); //황청색맹
            }
            intent.putExtra("result1", result1);
            intent.putExtra("result2", result2);
            intent.putExtra("result3", result3);
            intent.putExtra("result4", result4);
            startActivity(intent);
        }
    }
}
