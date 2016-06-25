package com.example.schedule.Exemplar;

/**
 * Created by UMF on 23.05.2016.
 */
public class classes {
//              "num":1,
//            "subject_title":"Менеджмент проектів ПЗ",
//            "t1_chair":"ст.викл.",
//            "t1_last_name":"Новікова",
//            "t1_first_name":"Ольга",
//            "t1_middle_name":"Сергіївна",
//            "t2_chair":null,
//            "t2_last_name":null,
//            "t2_first_name":null,
//            "t2_middle_name":null,
//            "classroom":"ауд.40",
//            "type":"лекція"
    private final int num;
    private   final String subject_title;
    private   final String t1_chair;
    private   final String t1_last_name;
    private   final String t1_first_name;
    private   final String t1_middle_name;
    private   final String t2_chair;
    private   final String t2_last_name;
    private   final String t2_first_name;
    private   final String t2_middle_name;
    private   final String classroom;
    private   final String type;


    public classes(int num, String subject_title, String t1_chair, String t1_last_name, String t1_first_name, String t1_middle_name, String t2_chair, String t2_last_name, String t2_first_name, String t2_middle_name, String classroom, String type) {
        this.num = num;
        this.subject_title = subject_title;
        this.t1_chair = t1_chair;
        this.t1_last_name = t1_last_name;
        this.t1_first_name = t1_first_name;
        this.t1_middle_name = t1_middle_name;
        this.t2_chair = t2_chair;
        this.t2_last_name = t2_last_name;
        this.t2_first_name = t2_first_name;
        this.t2_middle_name = t2_middle_name;
        this.classroom = classroom;
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public String getSubject_title() {
        return subject_title;
    }

    public String getT1_chair() {
        return t1_chair;
    }

    public String getT1_last_name() {
        return t1_last_name;
    }

    public String getT1_first_name() {
        return t1_first_name;
    }

    public String getT1_middle_name() {
        return t1_middle_name;
    }

    public String getT2_chair() {
        return t2_chair;
    }

    public String getT2_last_name() {
        return t2_last_name;
    }

    public String getT2_first_name() {
        return t2_first_name;
    }

    public String getT2_middle_name() {
        return t2_middle_name;
    }

    public String getClassroom() {
        return classroom;
    }

    public String getType() {
        return type;
    }
}
