package com.example.jiyoungkim.tutorial7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static int ACTIVITY_KEY = 3;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);
    }

    public void click (View v) {
        Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);

        switch(v.getId()) {
            case R.id.button1 :
                Intent intent1 = new Intent(MainActivity.this, SecondActivity.class);
                intent1.putExtra("id","abc");
                intent1.putExtra("password",1234);
                startActivity(intent1);
                break;

            case R.id.button2 :
                Intent intent2 = new Intent(MainActivity.this, ThirdActivity.class);
                intent2.putExtra("id","abcdddddd");
                intent2.putExtra("password",1234);
                startActivityForResult(intent2, 33333);
                break;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
//        switch(requestCode) {
//            case 33333:
            if (requestCode == 33333) {
                if (("abc").equals(intent.getStringExtra("correct_id"))) {
                    result.setText("Login Success!");
                } else {
                    result.setText("Login Fail!");
                }
            }

//                if (resultCode == 1) {
//                    result.setText("Login Success!" + " " + intent.getStringExtra("correct_id") + " " + intent.getIntExtra("correct_password",0));
//                } else if (resultCode == 0) {
//                    result.setText("Login Fail!" + " " + intent.getStringExtra("correct_id") + " " + intent.getIntExtra("correct_password",0));
//            }
//                break;
    }
}
