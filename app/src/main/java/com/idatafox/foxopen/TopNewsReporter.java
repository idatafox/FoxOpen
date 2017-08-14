package com.idatafox.foxopen;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TopNewsReporter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_news_reporter);
        final ActionBar actionBar =  getSupportActionBar();
        actionBar.setTitle(R.string.topA);

    }
}
