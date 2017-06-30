package com.example.jiyoungkim.tutorial8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> arrayList=new ArrayList<String>();
        arrayList.add("월");
        arrayList.add("화");
        arrayList.add("수");
        arrayList.add("목");
        arrayList.add("금");
        arrayList.add("토");
        arrayList.add("일");

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
        ListView lv = (ListView) findViewById(R.id.listview);
        lv.setAdapter(adapter);
    }
}

