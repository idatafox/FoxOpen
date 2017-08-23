package com.idatafox.foxopen;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class StartMyBkTaskDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_my_bk_task_demo);
        Intent intent = new Intent(this,MyBkTaskDemo.class);
        startService(intent);
        Log.d("startMyBkTaskDemo","started!");
    }
    public void doPubNoti(View v){
        doPostJsonData();
        Toast.makeText(getApplicationContext(),"ok...",Toast.LENGTH_SHORT).show();

    }




    public void doPostJsonData(){

        new AsyncTask<Void,Void,String>(){

            @Override
            protected String doInBackground(Void... Params) {

                HttpPost post = new HttpPost("http://www.idatafox.com/zn/testBkTask.jsp");
                JSONObject abc=new JSONObject();
                try {
                    abc.put("filterObj", "java");

                    StringEntity entity = new StringEntity(abc.toString());
                    post.setEntity(entity);
                    post.setHeader("Content-type", "application/json");
                    DefaultHttpClient client = new DefaultHttpClient();
                    BasicResponseHandler handler = new BasicResponseHandler();
                    String pValue = client.execute(post, handler);
                    Log.d("yyyyy",pValue);
                    return pValue;





                } catch (UnsupportedEncodingException e2) {
                    Log.d("getResponseData", e2.toString());
                } catch (IOException e3) {
                    Log.d("getResponseData", e3.toString());
                } catch (JSONException e1) {
                    Log.d("create JSONLoginInfo :", e1.toString());

                }
                return "startMyBkTaskDemo not connection";
            }



            @Override
            protected void onPostExecute(String s){

                Log.d("response data",s);

            }
        }.execute();

    }

    /*
    public void doPubNoti(View v){
        HttpPost post = new HttpPost("http://www.idatafox.com/zn/testBkTask.jsp");
        JSONObject abc=new JSONObject();
        try {
            abc.put("filterObj", "java");

            StringEntity entity = new StringEntity(abc.toString());
            post.setEntity(entity);
            post.setHeader("Content-type", "application/json");
            DefaultHttpClient client = new DefaultHttpClient();
            BasicResponseHandler handler = new BasicResponseHandler();
            String pValue = client.execute(post, handler);
            Log.d("yyyyy",pValue);





        } catch (UnsupportedEncodingException e2) {
            Log.d("getResponseData", e2.toString());
        } catch (IOException e3) {
            Log.d("getResponseData", e3.toString());
        } catch (JSONException e1) {
            Log.d("create JSONLoginInfo :", e1.toString());

        }

    }*/

}