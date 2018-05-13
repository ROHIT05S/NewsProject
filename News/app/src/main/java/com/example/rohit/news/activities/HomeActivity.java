package com.example.rohit.news.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rohit.news.R;
import com.example.rohit.news.adapter.NewsCategoryAdapter;
import com.example.rohit.news.util.CheckInternetConnection;
import com.example.rohit.news.util.ConnectivityReceiver;
import com.example.rohit.news.util.ShowAlert;
import com.example.rohit.news.util.URL;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity  {
   // TextView tv ;
    ListView news_category_list_view;
    String[] listSymbole;
    String[] listSymbole_category;
private  NewsCategoryAdapter news_category_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
      //  tv = (TextView)findViewById(R.id.textview_home);
        news_category_list_view = (ListView)findViewById(R.id.list_news_category);
        listSymbole = getResources().getStringArray(R.array.news_symbol);
        listSymbole_category = getResources().getStringArray(R.array.news_symbol_category);
        news_category_adapter = new NewsCategoryAdapter(this,listSymbole,listSymbole_category);

        // Call isNetworkAvailable class
        if (!isNetworkAvailable()) {
            // Create an Alert Dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            // Set the Alert Dialog Message
            builder.setMessage("Internet Connection Required")
                    .setCancelable(false)
                    .setPositiveButton("Retry",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    // Restart the Activity
                                    Intent dialogIntent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                                    dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(dialogIntent);
                                    dialog.dismiss();
                                  /*  Intent intent = getIntent();
                                    finish();
                                    startActivity(intent);*/
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }else {
            news_category_list_view.setAdapter(news_category_adapter);
        }

        news_category_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(),""+i,Toast.LENGTH_SHORT).show();

                if (!CheckInternetConnection.checkConnection(getApplicationContext())) {
                    ShowAlert.showNetDisabledAlertToUser(getApplicationContext());
                }

                Intent intent = new Intent(HomeActivity.this, NewsDetailActivity.class);
                switch (i) {

                    case 0:
                        intent.putExtra("url", URL.business_news_url);
                        intent.putExtra("title", "Business");
                        startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra("url", URL.entertainment_news_url);
                        intent.putExtra("title", "Entertainment");
                        startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra("url", URL.health_news_url);
                        intent.putExtra("title", "Health");
                        startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra("url", URL.science_news_url);
                        intent.putExtra("title", "Science");
                        startActivity(intent);
                        break;
                    case 4:
                        intent.putExtra("url", URL.sports_news_url);
                        intent.putExtra("title", "Sports");
                        startActivity(intent);
                        break;
                    case 5:
                        intent.putExtra("url", URL.technology_news_url);
                        intent.putExtra("title", "Technology");
                        startActivity(intent);
                        break;
                    case 6:
                        intent.putExtra("url", URL.national_geographic_news_url);
                        intent.putExtra("title", "Geography");
                        startActivity(intent);
                        break;
                }

                }

        });


    }

    // Private class isNetworkAvailable
    private boolean isNetworkAvailable() {
        // Using ConnectivityManager to check for Network Connection
        ConnectivityManager connectivityManager = (ConnectivityManager) this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (isNetworkAvailable()) {
            news_category_list_view.setAdapter(news_category_adapter);
        }
    }
}
