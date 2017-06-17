package com.example.rovince.websitetest;

import android.net.http.SslError;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WebView webView = (WebView) findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                handler.proceed("xlat","tub20141008");
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });

        webView.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == event.ACTION_DOWN){
                    if(keyCode == event.KEYCODE_BACK && webView.canGoBack()){
                        webView.goBack();
                        return true;
                    }
                }
                return false;
            }
        });
//        webView.loadUrl("http://xlat:tub20141008@202.112.35.231:8080/raspberry%20management/active/");
        webView.loadUrl("http://202.112.35.231:8080/raspberry%20management/active/");
    }
}
