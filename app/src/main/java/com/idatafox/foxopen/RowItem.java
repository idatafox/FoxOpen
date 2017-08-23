package com.idatafox.foxopen;

/**
 * Created by jakelee on 2017/8/16.
 */

public class RowItem {
    private int titleName=0;
    private String description=null;
    private String arc_body=null;


    public RowItem(int tName,String desA,String arcBody){
        this.titleName=tName;
        this.description=desA;
        this.arc_body=arcBody;
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

    public String getArc_body(){return this.arc_body;}
    public void setArc_body(String arcBody){this.arc_body=arcBody;}
}
