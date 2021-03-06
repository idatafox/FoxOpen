package com.idatafox.foxopen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
    }


    public void openEditTextDemoWin(View v){
        Intent intentObj=new Intent(this,EditTextDemoA.class);
        startActivity(intentObj);
    }

    //add bootom bar
    public void addBottomBar(View v){

        Intent intentObj=new Intent(this,MulActionBarsDemo.class);
        startActivity(intentObj);
    }
    //add customer listview demo
    public void addListViewA(View v){
        Intent intentObj=new Intent(this,TopNewsReporter.class);
        startActivity(intentObj);
    }

    //add custom viewpager demo
    public void addPageViewer(View v){
        Intent intentObj = new Intent(this,pageViewDemo.class);
        startActivity(intentObj);

    }
    //add bktask demo
    public void addBKTaskDemo(View v){
        Intent intentObj = new Intent(this,StartMyBkTaskDemo.class);
        startActivity(intentObj);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.abc,menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_read:
                Toast.makeText(getApplicationContext(),"read...",Toast.LENGTH_SHORT).show();
                 return true;
            case R.id.action_del:
                Toast.makeText(getApplicationContext(),"delete...",Toast.LENGTH_SHORT).show();
                 return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
