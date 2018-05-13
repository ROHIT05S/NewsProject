package com.example.rohit.news.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rohit.news.R;
import com.example.rohit.news.model.ArticleModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Rohit on 30-03-2018.
 */

public class NewsListAdapter extends BaseAdapter
{
    private Context context;
    private ArrayList<ArticleModel> articleList;
    public NewsListAdapter(Context context,ArrayList<ArticleModel> articleList)
    {
        this.context = context;
        this.articleList = articleList;
    }
    @Override
    public int getCount() {
        return articleList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1;
        view1 = new View(context);
        view1 = inflater.inflate(R.layout.list_item_news, null);
        ImageView newsImage = (ImageView) view1.findViewById(R.id.image_view_list);
        TextView text_view_title = (TextView) view1.findViewById(R.id.text_view_title);
        TextView text_view_description = (TextView) view1.findViewById(R.id.text_view_description);

        if (!articleList.get(i).getUrlToImage().equals("")&&!articleList.get(i).getDescription().equals("null")||articleList.get(i).getDescription().equals(null)) {
            Picasso.get().load(articleList.get(i).getUrlToImage()).into(newsImage);
            String description_text = articleList.get(i).getDescription();
            Log.d("desc",""+description_text.length());

            if (description_text.length()>=80)
            {
                String description_news = description_text.substring(0,80);
                text_view_description.setText(description_news+"...");
            }
            else
            {
                text_view_description.setText(description_text);
            }
        }
        else
        {
            newsImage.setVisibility(View.GONE);
            text_view_description.setVisibility(View.GONE);
        }
        text_view_title.setText(articleList.get(i).getTitle());



        //published_at.setText(articleList.get(i).getPublishedAt());

        return view1;
    }
}
