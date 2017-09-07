package com.example.jiyoungkim.blindtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ThirdActivity extends Activity {
    RadioGroup rg;
    RadioButton btn;
    String normal;
    String redgreen_meng; //적녹색맹
    String meng; //전색맹
    String result1="";
    String result2="";
    String result3="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_main);

        Intent intent = getIntent();
        result1 = intent.getStringExtra("result1");
        result2 = intent.getStringExtra("result2");
        rg= (RadioGroup)findViewById(R.id.thirdTest);
    }

    public void nextClick(View v) {
        Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
        //74:정상인, 21:적녹색맹, 읽지못함:전색맹
        btn = (RadioButton) findViewById(rg.getCheckedRadioButtonId());

        if(btn ==null) {
            Toast.makeText(ThirdActivity.this, "보기를 선택해주세요.", Toast.LENGTH_SHORT).show();
        } else {
            if ("74".equals(btn.getText().toString())) {
                result3 = getString(R.string.normal);
            } else if ("21".equals(btn.getText().toString())) {
                result3 = getString(R.string.redgreen_meng);
            } else {
                result3 = getString(R.string.meng);
            }
            intent.putExtra("result1", result1);
            intent.putExtra("result2", result2);
            intent.putExtra("result3", result3);
            startActivity(intent);
        }
    }
}
