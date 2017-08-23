package com.idatafox.foxopen;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.constraint.ConstraintLayout;
/**
 * Created by jakelee on 2017/8/21.
 */

public class CustomSwipeAdapter extends PagerAdapter{

    private  int[] image_list = {R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4
                                 ,R.drawable.a5,R.drawable.a6};
    private Context ctx;
    private LayoutInflater layoutInflater;


    public CustomSwipeAdapter(Context ctx){
        this.ctx = ctx ;
    }

    @Override
    public int getCount(){
        return image_list.length;
    }
    @Override
    public boolean isViewFromObject(View view, Object o){
        return (view == (LinearLayout)o);

    }


    @Override
    public Object instantiateItem(ViewGroup container,int position){
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView= layoutInflater.inflate(R.layout.myswipe_layout,container,false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.myImageViewA);
        TextView textView = (TextView) itemView.findViewById(R.id.myTextViewA);

        imageView.setImageResource(image_list[position]);
        textView.setText("image : " + position);

        container.addView(itemView);
        return itemView;
       // return super.instantiateItem(container,position);
    }

    @Override
    public void destroyItem(ViewGroup container,int position,Object object){
        container.removeView((LinearLayout)object);
        //super.destroyItem(container,position,object);

    }


}
