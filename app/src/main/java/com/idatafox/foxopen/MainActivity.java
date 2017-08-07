package com.idatafox.foxopen;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.TextInputLayout;

import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {

    TextView mytView=null;
    private Vibrator vib;
    Animation animation;
    private EditText signInputName;
    private TextInputLayout mLayout;
    private Button mButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytView = (TextView)findViewById(R.id.textView);
        Shader myshader=new LinearGradient(0,0,0,mytView.getTextSize(), Color.RED,Color.BLUE,Shader.TileMode.CLAMP);
        mytView.getPaint().setShader(myshader);
        mLayout=(TextInputLayout)findViewById(R.id.signup);
        signInputName=(EditText)findViewById(R.id.editText);


        /*
        signInputName.setText(null);
        signInputName.setHintTextColor(Color.BLACK);
        signInputName.setText("FUNK YOU!");*/

       // animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.shake);
        animation=AnimationUtils.loadAnimation(getBaseContext(),R.anim.shake);
        vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        mButton = (Button) (Button) findViewById(R.id.button2);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainActivity log","running....");
                signInputName.setAnimation(animation);
                signInputName.startAnimation(animation);
                vib.vibrate(120);
                mLayout.setErrorEnabled(false);
                if(signInputName.getText().toString().trim().isEmpty()){
                    mLayout.setErrorEnabled(true);
                    mLayout.setError("please enter ");
                    signInputName.setError("Valid input required");
                }

            }
        });}


    public void openNewWin(View v){

        Intent intentOne=new Intent(this,NextActivity.class);
        startActivity(intentOne);




    }

}























