package com.example.jiyoungkim.blindtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
    RadioGroup rg;
    RadioButton btn;
    String result1="";
    String result2="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);

        Intent intent = getIntent();
        result1 = intent.getStringExtra("result1");

        rg= (RadioGroup)findViewById(R.id.secondTest);
    }

    public void nextClick(View v) {
        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
        //5:정상인, 2:적녹색맹, 읽지못함:전색약
        btn = (RadioButton) findViewById(rg.getCheckedRadioButtonId());

        if(btn == null) {
            Toast.makeText(SecondActivity.this, "보기를 선택해주세요.", Toast.LENGTH_SHORT).show();
        } else {
            if ("5".equals(btn.getText().toString())) {
                result2 = getString(R.string.normal);
            } else if ("2".equals(btn.getText().toString())) {
                result2 = getString(R.string.redgreen_meng); //적녹색맹
            } else {
                result2 = getString(R.string.yak); //전색약
            }
            intent.putExtra("result1", result1);
            intent.putExtra("result2", result2);
            startActivity(intent);
        }
    }
}
