package com.example.jiyoungkim.tutorial7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends Activity {

    final static int LOGIN_SUCCESS = 1;
    final static int LOGIN_FAIL = 0;
    boolean login = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        TextView textId = (TextView) findViewById(R.id.userId);
        TextView textPassword = (TextView) findViewById(R.id.userPassword);
        Intent intent = getIntent();
        String userId = intent.getStringExtra("id");
        int userPassword = intent.getIntExtra("password",0);
        textId.setText(userId);
        textPassword.setText(Integer.toString(userPassword));


        if ((("abc")==(userId)) && (1234 == userPassword)) {
            login = true;
        } else {
                login = false;
            }
        }

        public void click (View v) {
            Intent intent = new Intent();
            intent.putExtra("correct_id","abc");
            intent.putExtra("correct_password",1234);
            setResult(1,intent);

//            if (login) {
//                setResult(1, intent);
//            } else {
//                setResult(0, intent);
//            }
            finish();
        }
    }


