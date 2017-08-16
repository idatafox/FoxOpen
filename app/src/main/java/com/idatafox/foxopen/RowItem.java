package com.idatafox.foxopen;

/**
 * Created by jakelee on 2017/8/16.
 */

public class RowItem {
    private int titleName=0;
    private String description=null;


    public RowItem(int tName,String desA){
        this.titleName=tName;
        this.description=desA;
    }

    public int getTitleName(){
        return this.titleName;
    }
    public void setTitleName(int tName){
        this.titleName=tName;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String tDes){
        this.description=tDes;
    }
}
