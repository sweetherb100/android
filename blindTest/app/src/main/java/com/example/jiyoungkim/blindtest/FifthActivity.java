package com.example.jiyoungkim.blindtest;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Iterator;

public class FifthActivity extends Activity {
    RadioGroup rg;
    RadioButton btn;
    String result1="";
    String result2="";
    String result3="";
    String result4="";
    String result5="";
    String normal= "";
    String redgreen_yak = "";
    String redgreen_meng = "";
    String yak = "";
    String meng = "";
    String redblue_meng = "";
    String green_meng = "";
    String red_meng = "";
    String blue_meng = "";
    HashMap hashMap = new HashMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth_main);

        Intent intent = getIntent();
        result1 = intent.getStringExtra("result1");
        result2 = intent.getStringExtra("result2");
        result3 = intent.getStringExtra("result3");
        result4 = intent.getStringExtra("result4");
        rg= (RadioGroup)findViewById(R.id.fifthTest);
        normal= getString(R.string.normal);
        redgreen_yak = getString(R.string.redgreen_yak);
        redgreen_meng = getString(R.string.redgreen_meng);
        yak = getString(R.string.yak);
        meng = getString(R.string.meng);
        redblue_meng = getString(R.string.redblue_meng);
        green_meng = getString(R.string.green_meng);
        red_meng = getString(R.string.red_meng);
        blue_meng = getString(R.string.blue_meng);
    }

    public void resultClick(View v) {
        btn = (RadioButton) findViewById(rg.getCheckedRadioButtonId());

        if(btn == null) {
            Toast.makeText(FifthActivity.this, "보기를 선택해주세요.", Toast.LENGTH_SHORT).show();
        } else {
            if (R.id.num1 == btn.getId()) {
                result5 = getString(R.string.green_meng); //녹색맹 (rainbow1)
            } else if (R.id.num2 == btn.getId()) {
                result5 = getString(R.string.red_meng); //적색맹(rainbow2)
            } else if (R.id.num3 == btn.getId()) {
                result5 = getString(R.string.normal); //정상(rainbow3)
            } else if (R.id.num4 == btn.getId()) {
                result5 = getString(R.string.blue_meng); //청색맹(rainbow4)
            }
            Log.d("result1", result1);
            Log.d("result2", result2);
            Log.d("result3", result3);
            Log.d("result4", result4);
            Log.d("result5", result5);
            validate();
        }
    }

    public void validate() {
        if (normal.equals(result1) && normal.equals(result2) && normal.equals(result3) && normal.equals(result4) && normal.equals(result5)) {
            //정상인
            hashMap.put(getString(R.string.normal),getString(R.string.normal));
        }
        if (redgreen_yak.equals(result1)) {
            //적녹색약
            hashMap.put(getString(R.string.redgreen_yak),getResources().getIntArray(R.array.redgreen_yak_rgb));
        }
        if (redgreen_meng.equals(result1) && redgreen_meng.equals(result2) && redgreen_meng.equals(result3)) {
            //적녹색맹
            hashMap.put(getString(R.string.redgreen_meng),getResources().getIntArray(R.array.redgreen_meng_rgb));
        }
        if (yak.equals(result2)) {
            //전색약
            hashMap.put(getString(R.string.yak),getResources().getIntArray(R.array.yak_rgb));
        }
        if (meng.equals(result3)) {
            //전색맹
            hashMap.put(getString(R.string.meng),getResources().getIntArray(R.array.meng_rgb));
        }
        if (redblue_meng.equals(result4)) {
            //황청색맹
            hashMap.put(getString(R.string.redblue_meng),getResources().getIntArray(R.array.redblue_meng_rgb));
        }
        if (green_meng.equals(result5)) {
            //녹색맹
            hashMap.put(getString(R.string.green_meng),getResources().getIntArray(R.array.green_meng_rgb));
        }
        if (red_meng.equals(result5)) {
            //적색맹
            hashMap.put(getString(R.string.red_meng),getResources().getIntArray(R.array.red_meng_rgb));
        }
        if (blue_meng.equals(result5)) {
            //청색맹
            hashMap.put(getString(R.string.blue_meng),getResources().getIntArray(R.array.blue_meng_rgb));
        }


        if (hashMap.size() != 1) {
            //잘못 선택 (조건에 없는 조합 선택 또는 2개 이상의 유전병 선택)
            popupOK(getString(R.string.wrong));
        } else if (hashMap.size() == 1){
            if (hashMap.containsKey(getString(R.string.normal))) {
                //정상인
                popupOK(getString(R.string.normal));
            } else {
                //유전병 보유
                Iterator iterator = hashMap.keySet().iterator();
                while(iterator.hasNext()) {
                    String  key = (String) iterator.next();
                    popupBlind((int[])hashMap.get(key), key);
                }
            }
        }
    }

    public void popupBlind(int[] blindRgb, String message) {
        final int[] rgb = blindRgb;
        AlertDialog.Builder dialog = new AlertDialog.Builder(FifthActivity.this);
        dialog.setTitle(message);
        dialog.setMessage("디스플레이 변경을 하겠습니까?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                changeDisplay(rgb);
                goback();
            }
        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                goback();
            }
        });
        dialog.show();
    }

    public void popupOK(String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(FifthActivity.this);
        dialog.setTitle(message);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                goback();
            }
        });
        dialog.show();
    }

    public void changeDisplay(int[] blindRgb){
        Intent service = new Intent( this, ScreenFilterService.class );
        service.putExtra("a",80);
        service.putExtra("r",blindRgb[0]);
        service.putExtra("g",blindRgb[1]);
        service.putExtra("b",blindRgb[2]);
        startService( service );
    }

    public void gobackClick (View v) {
        goback();
    }

    public void goback() {
        Intent intent = new Intent(FifthActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity( intent );
    }
}
