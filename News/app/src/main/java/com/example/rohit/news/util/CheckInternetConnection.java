package com.example.rohit.news.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Rohit on 08-04-2018.
 */

public class CheckInternetConnection
{
    private Context context;
    public static Boolean checkConnection(Context context)
    {
        if(isOnline(context)){
          //  Toast.makeText(context, "You are connected to Internet", Toast.LENGTH_SHORT).show();
            return true;
        }
        else
            {
          //  Toast.makeText(context, "You are not connected to Internet", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public static boolean isOnline(Context context)
    {
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }


}
