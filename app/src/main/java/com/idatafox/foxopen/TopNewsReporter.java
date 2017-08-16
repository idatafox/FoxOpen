package com.idatafox.foxopen;


import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class TopNewsReporter extends AppCompatActivity implements OnItemClickListener {

    String[] member_names;
    TypedArray profile_pics;
    List<RowItem> rowItems;
    ListView mylistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_news_reporter);
        final ActionBar actionBar =  getSupportActionBar();
        actionBar.setTitle(R.string.topA);
        doPostJsonData();
        rowItems = new ArrayList<RowItem>();
        member_names = getResources().getStringArray(R.array.titleList);
        profile_pics = getResources().obtainTypedArray(R.array.pics);

        for (int i = 0; i < member_names.length; i++) {
            RowItem item = new RowItem(profile_pics.getResourceId(i, -1),member_names[i]);
            rowItems.add(item);
        }
        mylistview = (ListView) findViewById(R.id.arcA);
        CustomAdapter adapter = new CustomAdapter(this, rowItems);
        mylistview.setAdapter(adapter);

        mylistview.setOnItemClickListener(this);




        //use listView
        /*
        final ListView listview = (ListView) findViewById(R.id.arcA);
        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile" };

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }

        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);

                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                list.remove(item);
                                adapter.notifyDataSetChanged();
                                view.setAlpha(1);
                            }
                        });
            }

        });*/


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
               // createJSONObjectFromInitString(s);
                Log.d("response data",s);

            }
        }.execute();

    }

    public String createJSONData(){
        final JSONObject loginInfo=new JSONObject();
        try{
            loginInfo.put("tagFirst","java");
            loginInfo.put("tagSecond","java");
            loginInfo.put("tagThird","java");
            return loginInfo.toString(1);

        }
        catch(JSONException e1){
            Log.d("TopNewsReporter :",e1.toString());

        }
        return null;
    }

    public String getResponseData(String inputValue){
        HttpPost post = new HttpPost("http://www.idatafox.com/android/Test/displayArcList");
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


   //define String List

    private ArrayList<String> doGetStringList(String vs){
       return null;
    }


    //adapter define
    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        String member_name = rowItems.get(position).getDescription();
        Toast.makeText(getApplicationContext(), "" + member_name,
                Toast.LENGTH_SHORT).show();
        Intent intentOne=new Intent(getBaseContext(),NextActivity.class);
        startActivity(intentOne);

    }


}
