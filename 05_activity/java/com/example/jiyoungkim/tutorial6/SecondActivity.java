package com.example.jiyoungkim.tutorial6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void clickIntent2 (View v) {
        finish();
    }
}
//Error running tracerbad
//The activity must be exported or contain an intent-filter