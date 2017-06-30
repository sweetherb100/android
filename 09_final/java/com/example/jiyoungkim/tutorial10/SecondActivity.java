package com.example.jiyoungkim.tutorial10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by JIYOUNGKIM on 2017-06-27.
 */

public class SecondActivity extends Activity {

    Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnGo = (Button) findViewById(R.id.btnGo);
        EditText txtURL = (EditText) findViewById(R.id.txtURL);

        txtURL.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    btnGo.performClick();
                }
                return true;
            }
        });
    }

    public void click(View v) {
        EditText tvURL = (EditText)findViewById(R.id.txtURL);
        String url = tvURL.getText().toString();

        RadioButton r1 = (RadioButton) findViewById(R.id.wwwYes);
        RadioButton r2 = (RadioButton) findViewById(R.id.wwwNo);
        if (r2.isChecked()) {
            url = "http://www." + url;
        }

        RadioButton rr1 = (RadioButton) findViewById(R.id.userUrl);
        RadioButton rr2 = (RadioButton) findViewById(R.id.com);
        RadioButton rr3 = (RadioButton) findViewById(R.id.org);
        if (rr2.isChecked()) {
            url = url + ".com";
        } else if (rr3.isChecked()) {
            url = url+".org";
        }

        WebView webView = (WebView)findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient()); // 이걸 안해주면 새창이 뜸
        webView.loadUrl(url);
    }
}
