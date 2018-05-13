package com.example.rohit.news.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.rohit.news.R;

public class ViewNewsActivity extends AppCompatActivity
{
    String news_url;
    WebView webView;
    ImageView share;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_news);
        webView = (WebView)findViewById(R.id.news_webview);
        share = (ImageView)findViewById(R.id.share_news);
        news_url = getIntent().getStringExtra("url");
        webView.loadUrl(news_url);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, news_url);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);

               // startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_to)));
            }
        });
    }
}
