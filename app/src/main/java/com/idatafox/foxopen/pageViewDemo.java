package com.idatafox.foxopen;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class pageViewDemo extends AppCompatActivity {

    ViewPager viewPager;
    CustomSwipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_view_demo);
        viewPager = (ViewPager)findViewById(R.id.myViewPager);
        adapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);
        Log.d("pageViewDemo:","running ...");


    }
}
