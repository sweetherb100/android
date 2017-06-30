package com.example.jiyoungkim.tutorial5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String firstNum = "";
    String secondNum = "";
    boolean firstOrSecond = true;
    String whichOne = "";

    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnDecimal;
    Button btnEqual;
    Button btnPlus;
    Button btnMinus;
    Button btnMultiply;
    Button btnDivide;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnDecimal = (Button) findViewById(R.id.btnDecimal);
        btnEqual = (Button) findViewById(R.id.btnEqual);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        textResult= (TextView) findViewById(R.id.result);
    }


    public void click(View v) {
//        Button btn0 = (Button) findViewById(R.id.btn0);
//        Button btn1 = (Button) findViewById(R.id.btn1);
//        Button btn2 = (Button) findViewById(R.id.btn2);
//        Button btn3 = (Button) findViewById(R.id.btn3);
//        Button btn4 = (Button) findViewById(R.id.btn4);
//        Button btn5 = (Button) findViewById(R.id.btn5);
//        Button btn6 = (Button) findViewById(R.id.btn6);
//        Button btn7 = (Button) findViewById(R.id.btn7);
//        Button btn8 = (Button) findViewById(R.id.btn8);
//        Button btn9 = (Button) findViewById(R.id.btn9);
//        Button btnDecimal = (Button) findViewById(R.id.btnDecimal);
//        Button btnEqual = (Button) findViewById(R.id.btnEqual);
//        Button btnPlus = (Button) findViewById(R.id.btnPlus);
//        Button btnMinus = (Button) findViewById(R.id.btnMinus);
//        Button btnMultiply = (Button) findViewById(R.id.btnMultiply);
//        Button btnDivide = (Button) findViewById(R.id.btnDivide);
//        TextView textResult= (TextView) findViewById(R.id.result);


        String btnText= ((Button) v).getText().toString();
//        Button btn = (Button) v;
//        String btnText = btn.getText().toString();
//        String btnText= btn0.getText().toString();

        switch(v.getId()) {
            case R.id.btn0:
            case R.id.btn1:
            case R.id.btn2:
            case R.id.btn3:
            case R.id.btn4:
            case R.id.btn5:
            case R.id.btn6:
            case R.id.btn7:
            case R.id.btn8:
            case R.id.btn9:
                if (firstOrSecond) { //firstNum
                    firstNum = firstNum + btnText;
                    textResult.setText(firstNum);
                } else { //secondNum
                    secondNum = secondNum + btnText;
                    textResult.setText(secondNum);

                }
                break;

            case R.id.btnEqual:
                String strResult="";
                if ("+".equals(whichOne)) {
                    strResult = (Integer.toString(Integer.parseInt(firstNum) + Integer.parseInt(secondNum)));
                } else if ("-".equals(whichOne)) {
                    strResult =(Integer.toString(Integer.parseInt(firstNum) - Integer.parseInt(secondNum)));
                } else if ("*".equals(whichOne)) {
                    strResult =(Integer.toString(Integer.parseInt(firstNum) * Integer.parseInt(secondNum)));
                } else if ("/".equals(whichOne)) {
                    strResult =(Integer.toString(Integer.parseInt(firstNum) / Integer.parseInt(secondNum)));
                }

                textResult.setText(strResult);
                firstNum = "";
                secondNum = "";
                firstOrSecond = true;
                btnText = "";
                //reset firstNum and secondNum,
                // btnText
                break;
            case R.id.btnPlus:
            case R.id.btnMinus:
            case R.id.btnMultiply:
            case R.id.btnDivide:
                firstOrSecond = false;
                whichOne = btnText;
                break;

//            case R.id.btnDecimal:
//                break;
        }
    }
}
