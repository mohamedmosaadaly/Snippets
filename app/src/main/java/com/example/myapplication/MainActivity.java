package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    Button btn, sub;
    ToggleButton tgb;
    EditText et;
    TextView tv;
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "This is one", Toast.LENGTH_LONG).show();
            }
        });
        tgb = (ToggleButton) findViewById(R.id.toggleButton);
        tgb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "I am on", Toast.LENGTH_SHORT).show();
                } else Toast.makeText(MainActivity.this, "I am off", Toast.LENGTH_SHORT).show();
            }
        });
        et = (EditText) findViewById(R.id.editText);
        tv = (TextView) findViewById(R.id.textView);
        sub = (Button) findViewById(R.id.button2);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Hello " + et.getText());
            }
        });
        wv = (WebView) findViewById(R.id.webView);
        wv.loadUrl("http://www.google.com");
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if (wv.canGoBack()) {
            wv.goBack();
        } else finish();
    }
}
