package com.example.rohit.news.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rohit.news.R;
import com.example.rohit.news.URLCall;
import com.example.rohit.news.adapter.NewsListAdapter;
import com.example.rohit.news.model.ArticleModel;

import java.util.ArrayList;

public class NewsDetailActivity extends AppCompatActivity
{
    String news_url;
    String news_title;
    TextView title_text;
    ListView listView_news;
    URLCall urlCall;
    private ArrayList<ArticleModel> newsList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        title_text = (TextView)findViewById(R.id.text_view_title);
        listView_news = (ListView)findViewById(R.id.list_view);
        Intent intent = getIntent();
        if (intent.hasExtra("url"))
        {
            news_url = intent.getStringExtra("url");
            news_title = intent.getStringExtra("title");
            //Toast.makeText(getApplicationContext(),news_url, Toast.LENGTH_SHORT).show();
        }
        title_text.setText(news_title+" News ");
        urlCall = new URLCall();
        newsList = new ArrayList<>();
        newsList = urlCall.getOther_news(news_url);
        ListAdapter newsListAdapter = new NewsListAdapter(getApplicationContext(), newsList);

        listView_news.setAdapter(newsListAdapter);


        listView_news.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String url = newsList.get(i).getUrl();
                Intent intent = new Intent(getApplicationContext(), ViewNewsActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);


            }
        });
    }
}
