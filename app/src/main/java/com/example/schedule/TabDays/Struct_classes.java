package com.example.schedule.TabDays;

/**
 * Created by UMF on 05.04.2016.
 */
public class Struct_classes {

    public String name;            //имя пары
    public String name_teacher;    //имя препода
    public  String type;            //тип (лаба или лекция)
    public  String aud;             //аудитория

  public   Struct_classes(String name,String name_teacher,String type,String aud){
        this.name=name;
        this.aud=aud;
        this.name_teacher=name_teacher;
        this.type=type;
    }
   public Struct_classes(){
       this.name="";
       this.aud="";
       this.name_teacher="";
       this.type="";
   }

    public String[] ToString()
    {

        return new String[]{name,name_teacher,type,aud};
    }


}
