package com.example.jiyoungkim.tutorial7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textId = (TextView) findViewById(R.id.userId);
        TextView textPassword = (TextView) findViewById(R.id.userPassword);

        Intent intent = getIntent();
        String userId = intent.getStringExtra("id");
        int userPassword = intent.getIntExtra("password",0);

        textId.setText(userId);
        textPassword.setText(Integer.toString(userPassword));
    }

    public void click(View v) {
        finish();
    }

}