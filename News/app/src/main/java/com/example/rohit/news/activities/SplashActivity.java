package com.example.rohit.news.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rohit.news.R;
import com.hanks.htextview.rainbow.RainbowTextView;

public class SplashActivity extends AppCompatActivity {
    MediaPlayer music;
    Animation animTogether, aniLeft;
    RainbowTextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        textView = (RainbowTextView) findViewById(R.id.text_view_splash);

        textView.animateText(getString(R.string.app_name));
        animTogether = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.together);

        textView.startAnimation(animTogether);

        Thread timer = new Thread() {
            @Override
            public void run() {
                try {
                    music = MediaPlayer.create(SplashActivity.this, R.raw.news);
                    music.start();
                    sleep(2043);

                    Intent i = new Intent(SplashActivity.this, HomeActivity.class);
                    overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                    startActivity(i);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Log.d("Interrupted Exception", "Exception Occurs");
                }





            }
        };

        timer.start();

    }

    }




