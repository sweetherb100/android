package com.example.jiyoungkim.tutorial10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v) {
        EditText editText1 = (EditText) findViewById(R.id.id);
        EditText editText2 = (EditText) findViewById(R.id.password);
        String id = editText1.getText().toString();
        String password = editText2.getText().toString();

        if (id.equals("steve1209") && password.equals("1209")) {
            Toast.makeText(MainActivity.this,"login success",Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(MainActivity.this, SecondActivity.class);
            intent1.putExtra("id",id);
            intent1.putExtra("password",password);
            startActivity(intent1);
        } else {
            Toast.makeText(MainActivity.this,"login fail. Try again.",Toast.LENGTH_SHORT).show();
        }
    }
}
