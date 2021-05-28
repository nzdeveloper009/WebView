package com.nzdeveloper009.webview2021;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {


    WebView webView;
    private String webUrl="https://console.firebase.google.com/u/1/project/waylink-management-syste-802c7/database/waylink-management-syste-802c7-default-rtdb/data";
    ProgressBar progressBarweb;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        webView=(WebView)findViewById(R.id.webview);
        progressBarweb=(ProgressBar)findViewById(R.id.progressBar);
        webView.loadUrl(webUrl);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient()
        {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBarweb.setVisibility(view.VISIBLE);
                progressBarweb.setProgress(newProgress);
                if(newProgress==100){

                    progressBarweb.setVisibility(view.GONE);

                }
                super.onProgressChanged(view, newProgress);
            }
        });
    }
}

