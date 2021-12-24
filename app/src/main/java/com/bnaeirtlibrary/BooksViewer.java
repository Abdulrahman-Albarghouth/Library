package com.bnaeirtlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

public class BooksViewer extends AppCompatActivity {
    private TextView linkey;
    private ProgressBar progressBar;
    WebView webView;
    String val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_viewer);
        Intent secondintent = getIntent();
        val = secondintent.getStringExtra("key");


        webView = findViewById(R.id.mywebviewer);
        // progressBar = findViewById(R.id.myprogressbar);
        //progressBar.setVisibility(View.VISIBLE);
/*
        webView = findViewById(R.id.mywebviewer);
        webView .getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.loadUrl("https://docs.google.com/viewerng/viewer?embedded=true&url=" + val);
       // progressBar.setVisibility(View.GONE);

 */

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.setWebChromeClient(new WebChromeClient());
        Intent intent = getIntent();
        final int position = intent.getIntExtra("position",0);
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageFinished(WebView view, String url) {
                webView.loadUrl("javascript:(function() { " +
                        "document.querySelector('[role=\"toolbar\"]').remove();})()");
                //progressBar.setVisibility(View.GONE);
            }
        });
        //https://docs.google.com/viewerng/viewer?embedded=true&url=
        webView.loadUrl("https://docs.google.com/viewerng/viewer?embedded=true&url=" + val);
/*
        WebView wv = root.findViewById(R.id.webView);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUseWideViewPort(true);
        wv.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + postUrl);
*/

        /*
        linkey = findViewById(R.id.testeur);
        Intent secondintent = getIntent();
        val = secondintent.getStringExtra("key");
        linkey.setText(val);
        myWebView = (WebView) findViewById(R.id.mywebviewer);
        myWebView = new WebView(this);
        setContentView(myWebView);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/mylibrary-9f78b.appspot.com/o/Art.pdf?alt=media&token=08d2d697-49e6-4a46-a8ce-bee2d7df976b");
*/

    }
}