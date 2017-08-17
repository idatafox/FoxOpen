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
