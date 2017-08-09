package com.idatafox.foxopen;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.AsyncTask;
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

import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import org.apache.http.client.methods.HttpPost;

public class MainActivity extends AppCompatActivity {

    TextView mytView=null;
    private Vibrator vib;
    Animation animation;
    private EditText signInputName;
    private EditText signInputPassword;
    private EditText signInputWeinxinCode;
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

                doPostJsonData();

            }
        });}


    public void openNewWin(View v){

        Intent intentOne=new Intent(this,NextActivity.class);
        startActivity(intentOne);




    }

    //get login about data and create json data
    public String createJSONData(){

        signInputName=(EditText)findViewById(R.id.editText3);
        signInputPassword=(EditText)findViewById(R.id.editText);
        signInputWeinxinCode=(EditText)findViewById(R.id.editText4);
        String userName=signInputName.getText().toString();
        String userPassword=signInputPassword.getText().toString();
        String weixinCode=signInputWeinxinCode.getText().toString();
        String tempValue=null;
        tempValue=String.format("%s %s %s",userName,userPassword,weixinCode);
        Log.d("createJSONData :",tempValue);
        final JSONObject loginInfo=new JSONObject();
        try{
            loginInfo.put("userName",userName);
            loginInfo.put("userPassword",userPassword);
            loginInfo.put("weixinCode",weixinCode);
            return loginInfo.toString(1);

        }
        catch(JSONException e1){
            Log.d("create JSONLoginInfo :",e1.toString());

        }
        return null;



    }

    /**
     * post data to remote server
     */
    public void doPostJsonData(){
        final String resData=createJSONData();
        new AsyncTask<Void,Void,String>(){

            @Override
            protected String doInBackground(Void... Params){
                return getResponseData(resData);
            }
            @Override
            protected void onPostExecute(String s){
                Log.d("response data",s);
            }
        }.execute();

    }
    /**
     * get response data from remote server
     */
    public String getResponseData(String inputValue){
        HttpPost post = new HttpPost("http://www.idatafox.com/androidTest/aa");
        try {
            StringEntity entity=new StringEntity(inputValue);
            post.setEntity(entity);
            post.setHeader("Content-type","application/json");
            DefaultHttpClient client=new DefaultHttpClient();
            BasicResponseHandler handler=new BasicResponseHandler();
            String pValue=client.execute(post,handler);
            return pValue;
        }
        catch(UnsupportedEncodingException e2){
            Log.d("getResponseData",e2.toString());
        }
        catch(IOException e3){
            Log.d("getResponseData",e3.toString());
        }
        return "unable to connect to server";

    }

}























