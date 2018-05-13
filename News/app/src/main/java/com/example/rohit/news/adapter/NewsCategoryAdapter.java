package com.example.rohit.news.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rohit.news.R;
import com.example.rohit.news.model.ArticleModel;

import java.util.ArrayList;

/**
 * Created by Rohit on 21-04-2018.
 */

public class NewsCategoryAdapter extends BaseAdapter
{
    private Context context;
    private String[] news_category_list;
    private String[] news_category_Symbol_list;
    public NewsCategoryAdapter(Context context, String[] news_category_Symbol_list,String[] news_category_list)
    {
        this.context = context;
        this.news_category_list = news_category_list;
        this.news_category_Symbol_list = news_category_Symbol_list;
    }

    @Override
    public int getCount() {
        return news_category_list.length;
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
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1;
        view1 = new View(context);
        if (i%2==0) {
            view1 = inflater.inflate(R.layout.news_category_adapter, null);
            TextView symbol = (TextView) view1.findViewById(R.id.text_view_news_ct);
            TextView category = (TextView) view1.findViewById(R.id.title_text_news_cat);
            symbol.setText(news_category_Symbol_list[i]);
            category.setText(news_category_list[i]);
        }
        else
        {
            view1 = inflater.inflate(R.layout.news_category_adapter_layout1, null);
            TextView symbol = (TextView) view1.findViewById(R.id.text_view_news_ct);
            TextView category = (TextView) view1.findViewById(R.id.title_text_news_cat);
            symbol.setText(news_category_Symbol_list[i]);
            category.setText(news_category_list[i]);
        }

        return view1;
    }
}
