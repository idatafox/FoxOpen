package com.idatafox.foxopen;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jakelee on 2017/8/16.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    List<RowItem> rowItem;

    CustomAdapter(Context context, List<RowItem> rowItems) {
        this.context = context;
        this.rowItem = rowItems;
    }


    @Override
    public int getCount(){return rowItem.size();}
    @Override
    public Object getItem(int position){
        return rowItem.get(position);
    }
    @Override
    public long getItemId(int position){

        return rowItem.indexOf(getItem(position));
    }
    //private view holder class
    private class ViewHolder{
        ImageView title_pic;
        TextView des_about;
    }
    @Override
    public View getView(int position, View cView, ViewGroup parent){
        String ll=null;


        ViewHolder holder=null;
        LayoutInflater minflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        /*
        if(cView==null){
            cView=minflater.inflate(R.layout.list_item,null);
            holder=new ViewHolder();
            holder.des_about=(TextView)cView.findViewById(R.id.textView4);
            holder.title_pic=(ImageView)cView.findViewById(R.id.imageView);
            RowItem row_pos=rowItem.get(position);
            holder.des_about.setText(row_pos.getDescription());
            ll=String.format(" position is %d  title= %s \r\n",position,row_pos.getDescription());
            Log.d("[getView]",ll);
           // holder.title_pic.setImageResource(row_pos.getTitleName());
            holder.title_pic.setImageResource(R.drawable.ffa);
            cView.setTag(holder);
        }
        else{

            holder=(ViewHolder)cView.getTag();
        }
        */

        cView=minflater.inflate(R.layout.list_item,null);
        holder=new ViewHolder();
        holder.des_about=(TextView)cView.findViewById(R.id.textView4);
        holder.title_pic=(ImageView)cView.findViewById(R.id.imageView);
        RowItem row_pos=rowItem.get(position);
        holder.des_about.setText(row_pos.getDescription());
        ll=String.format(" position is %d  title= %s \r\n",position,row_pos.getDescription());
        Log.d("[getView]",ll);
        // holder.title_pic.setImageResource(row_pos.getTitleName());
        holder.title_pic.setImageResource(R.drawable.ffa);
        cView.setTag(holder);

        return cView;
    }

}
