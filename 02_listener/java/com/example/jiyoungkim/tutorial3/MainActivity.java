package com.example.jiyoungkim.tutorial3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "onClick", Toast.LENGTH_SHORT).show();
            }
        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "onLongClick", Toast.LENGTH_SHORT).show();
                return true;
            }
        });


        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Toast.makeText(MainActivity.this, "onKey", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Toast.makeText(MainActivity.this, "onFocusChange", Toast.LENGTH_SHORT).show();
            }
        });

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Toast.makeText(MainActivity.this, "ACTION_DOWN", Toast.LENGTH_SHORT).show();
                        break;

                    case MotionEvent.ACTION_UP:
                        Toast.makeText(MainActivity.this, "ACTION_UP", Toast.LENGTH_SHORT).show();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        Toast.makeText(MainActivity.this, "ACTION_MOVE", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        View view = findViewById(R.id.layout);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(MainActivity.this, "onTouch", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    public void click2 (View v) {
        Toast.makeText(MainActivity.this, "onClick 2", Toast.LENGTH_SHORT).show();
    }
}





