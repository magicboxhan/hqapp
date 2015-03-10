package com.example.hqapp;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by hanqing on 2015/3/10.
 */
public class Activity_2 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        //设置Webview的URL
        WebView wv1 = (WebView) findViewById(R.id.webView_2);
        wv1.setWebChromeClient(new WebChromeClient());
        wv1.setWebViewClient(new WebViewClient());
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.loadUrl("http://www.bing.com");
    }
}