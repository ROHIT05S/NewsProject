package com.example.rohit.news;

import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import com.example.rohit.news.model.ArticleModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Rohit on 18-03-2018.
 */

public class URLCall
{
    OkHttpClient client = new OkHttpClient();
    public ArrayList<ArticleModel> article_news_list = new ArrayList<>();

    public  ArrayList<ArticleModel> getOther_news(String news_url)
    {
        StrictMode.ThreadPolicy policy =
                new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Request request = new Request.Builder()
                .url(news_url)
                .build();
        Response response = null;

        try {

            response = client.newCall(request).execute();

                String status = null;
                //JSONObject obj = new JSONObject(response.body().toString());

                Log.d("resp", response.toString());
                try {
                    JSONObject obj = new JSONObject(response.body().string());
                    JSONArray array = obj.getJSONArray("articles");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject obj1 = array.getJSONObject(i);
                        article_news_list.add(new ArticleModel(obj1.getString("author"), obj1.getString("title"), obj1.getString("description"), obj1.getString("url"), obj1.getString("urlToImage"), obj1.getString("publishedAt")));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                return article_news_list;


        }

        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
