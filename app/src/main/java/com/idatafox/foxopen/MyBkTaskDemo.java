package com.idatafox.foxopen;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by jakelee on 2017/8/22.
 */

public class MyBkTaskDemo extends IntentService {
    private static final String TAG = "MyBkTaskDemo";
    public MyBkTaskDemo(){
        super("MyBkTaskDemo");

    }
    @Override
    public void onHandleIntent(Intent intent){
        Log.i(TAG,"MyBkTaskDemo is running...");
        String notiStatus=null;
        String notiText=null;
        String sessionid=null;
        JSONObject noti=new JSONObject();
        if(intent!=null) {
            synchronized (this) {

                while (true) {
                    HttpPost post = new HttpPost("http://www.idatafox.com/android/Test/getNotiStatus");
                    try {
                        noti.put("filterObj", "java");

                        StringEntity entity = new StringEntity(noti.toString());
                        post.setEntity(entity);
                        post.setHeader("Content-type", "application/json");
                        DefaultHttpClient client = new DefaultHttpClient();
                        BasicResponseHandler handler = new BasicResponseHandler();
                        String pValue = client.execute(post, handler);
                        Log.d("onHandleIntent-Value ", pValue);
                        JSONObject jsonObject = new JSONObject(pValue);
                        notiStatus = jsonObject.getString("notiStatus");
                        notiText = jsonObject.getString("notiText");
                        sessionid=  jsonObject.getString("sessionid");

                        Log.d("onHandleIntent-Value", "resValue:" + notiStatus + ":" + notiText + ":" + sessionid);
                        if (notiStatus.equals("0")) {
                            Log.d("onHandleIntent-Value", "start to send message:" + notiText);
                            NotificationCompat.Builder nb = new NotificationCompat.Builder(this);
                            nb.setContentText("你的个性化新闻阅读雷达订阅成功！");
                            nb.setContentTitle("重要通知");
                            nb.setOngoing(true);
                            nb.setSmallIcon(R.mipmap.ic_launcher);
                            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                            PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                                    new Intent(this, NextActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
                            nb.setContentIntent(contentIntent);
                            Notification notification = nb.build();

                           /*
                            Intent notificationIntent = new Intent(this, TopNewsReporter.class);

                            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                                    | Intent.FLAG_ACTIVITY_SINGLE_TOP);

                            PendingIntent intentA = PendingIntent.getActivity(this, 0,
                                    notificationIntent, 0);

                            notification.setLatestEventInfo(this,"good", "how how you  bob", intentA);
                            notification.flags |= Notification.FLAG_AUTO_CANCEL;*/
                           nm.notify(1,notification);
                            Log.d("onHandleIntent-Value", "displayNotification!");
                            break;


                        }

                    } catch (UnsupportedEncodingException e2) {
                        Log.d("getResponseData", e2.toString());
                    } catch (IOException e3) {
                        Log.d("getResponseData", e3.toString());
                    } catch (JSONException e1) {
                        Log.d("create JSONLoginInfo :", e1.toString());

                    }
                }
            }
        }



    }
}
