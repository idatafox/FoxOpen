package com.idatafox.foxopen;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

public class SmallArticlePage extends AppCompatActivity {
    String arc_body=null;
    String arc_title=null;
    TextView ahtmlV=null;
    TextView btv=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small_article_page);

        final ActionBar actionBar =  getSupportActionBar();
        actionBar.setTitle("文章详情");

        arc_body = getIntent().getStringExtra("arc_body");
        arc_title = getIntent().getStringExtra("arc_title");
        Log.d("arc_body",arc_body);

        //setup textview
        ahtmlV= (TextView) findViewById(R.id.textView5);
        btv= (TextView) findViewById(R.id.textView6);

        btv.setText(arc_title);
        ahtmlV.setText(Html.fromHtml(arc_body));
       // ahtmlV.setMovementMethod(new ScrollingMovementMethod());


    }
}
