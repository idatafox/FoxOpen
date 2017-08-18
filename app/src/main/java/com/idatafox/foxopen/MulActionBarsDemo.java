package com.idatafox.foxopen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MulActionBarsDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mul_action_bars_demo);
    }

    public void testData(View v){
        Toast.makeText(getApplicationContext(),"alert button...",Toast.LENGTH_SHORT).show();

    }
}
