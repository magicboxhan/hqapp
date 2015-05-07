package com.example.hqapp;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        WebView.setWebContentsDebuggingEnabled(true);
//        Context context = this;

        //创建按钮单击事件监听器
        Button button = (Button) findViewById(R.id.button_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                initWebView();
//                saveCustomSharedPreferences();
//                saveDefaultSharedPreferences();
//                saveInternalFile();
//                saveInternalCacheFile();
//                saveExternalPublicDir();
//                saveExternalPrivateDir();
                createFolderOnSDCard();
            }
        });
        //创建按钮单击事件监听器
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                //打开Activity_2
//                Intent it = new Intent(MainActivity.this, Activity_2.class);
//                startActivity(it);

                //获取SharedPreferences
                System.out.println("Get SharedPreferences");
                SharedPreferences sharedPref = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
                System.out.println(String.format("SharedPreferences int value: %d", sharedPref.getInt("testInt", 0)));
                System.out.println(String.format("SharedPreferences string value: %s", sharedPref.getString("testString", "defaultStringValue")));
                System.out.println(String.format("SharedPreferences string value: %b", sharedPref.getBoolean("testBool", true)));
            }
        });
    }

    /**
     * 初始化 webview
     */
    public void initWebView() {
        //设置Webview的URL
        WebView wv1 = (WebView) findViewById(R.id.webView_1);
        wv1.setWebChromeClient(new WebChromeClient());
        wv1.setWebViewClient(new WebViewClient());
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.loadUrl("http://www.baidu.com");
    }

    /**
     * 设置自定义 SharedPreferences
     */
    public void saveCustomSharedPreferences() {
        //设置SharedPreferences
        System.out.println("Set SharedPreferences");
        SharedPreferences sharedPref = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("testInt", 10);
        editor.putString("testString", "stringValue");
        editor.putBoolean("testBool", true);
        editor.commit();
        System.out.println("Done");
    }

    /**
     * 设置默认 SharedPreferences
     */
    public void saveDefaultSharedPreferences() {
        System.out.println("Set default SharedPreferences");
        SharedPreferences sharedPref2 = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sharedPref2.edit();
        editor2.putInt("testInt", 10);
        editor2.putString("testString", "stringValue");
        editor2.putBoolean("testBool", true);
        editor2.commit();
    }

    /**
     * 在内部存储中保存普通文件
     */
    public void saveInternalFile() {
        System.out.println("Save internal file");
        String fileName = "myFile.txt";
        String string = "Hello world!";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 在内部存储中保存缓存文件
     */
    public void saveInternalCacheFile() {
        System.out.println("Set internal cache file");
        String fileName = "myCacheFile.txt";
        try {
            File.createTempFile(fileName, "hq", getCacheDir());
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 在外部存储中创建公共目录
     */
    public void saveExternalPublicDir() {
        System.out.println("Save external public dir");
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "testExternalPublicDir");
        if (!file.mkdirs()) {
            System.out.println("Directory not created");
        }
        System.out.println("Done");
    }

    /**
     * 在外部存储中创建私有目录
     */
    public void saveExternalPrivateDir() {
        System.out.println("Save external private dir");
        File file = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "testExternalPrivateDir");
        if (!file.mkdirs()) {
            System.out.println("Directory not created");
        }
        System.out.println("Done");
    }

    /**
     * 在sd卡上创建目录
     */
    public void createFolderOnSDCard() {
        System.out.println("Create dir on SDCard");
        File testDirectory = new File("/sdcard/HQQ/");
        testDirectory.mkdirs();
        System.out.println("Done");
    }
}
