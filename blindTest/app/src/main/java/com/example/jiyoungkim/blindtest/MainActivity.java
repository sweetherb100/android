package com.example.jiyoungkim.blindtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton btn;
    String result1="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg= (RadioGroup)findViewById(R.id.firstTest);
    }

    public void nextClick(View v) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        //15:정상인, 17:적녹색약, 읽지못함:적녹색맹
        btn = (RadioButton) findViewById(rg.getCheckedRadioButtonId());

        if (btn == null) {
            Toast.makeText(MainActivity.this, "보기를 선택해주세요.", Toast.LENGTH_SHORT).show();
        } else {
            if ("15".equals(btn.getText().toString())) {
                result1 = getString(R.string.normal);
            } else if ("17".equals(btn.getText().toString())) {
                result1 = getString(R.string.redgreen_yak); //적녹색약
            } else {
                result1 = getString(R.string.redgreen_meng); //적녹색맹
            }
            intent.putExtra("result1", result1);
            startActivity(intent);
        }
    }

    public void resetClick(View v) {
        Intent service = new Intent( this, ScreenFilterService.class );
        stopService( service );
    }
}
