package com.example.hqapp;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //创建按钮单击事件监听器
        Button button = (Button)findViewById(R.id.button_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //设置Webview的URL
                WebView.setWebContentsDebuggingEnabled(true);
                WebView wv1 = (WebView) findViewById(R.id.webView_1);
                wv1.setWebChromeClient(new WebChromeClient());
                wv1.setWebViewClient(new WebViewClient());
                wv1.getSettings().setJavaScriptEnabled(true);
                wv1.loadUrl("http://www.baidu.com");
            }
        });
        //创建按钮单击事件监听器
        Button button2 = (Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //打开Activity_2
                Intent it = new Intent(MainActivity.this, Activity_2.class);
                startActivity(it);
            }
        });
    }
}
