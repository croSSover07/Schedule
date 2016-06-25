package com.example.schedule.Exemplar;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by UMF on 23.05.2016.
 */
public class week {

    @SerializedName("Понеділок")
    private ArrayList<classes> monday;
    @SerializedName("Вівторок")
    private   ArrayList<classes> tuesday;
    @SerializedName("Середа")
    private   ArrayList<classes> wednesday;
    @SerializedName("Четвер")
    private   ArrayList<classes> thursday;
    @SerializedName("П'ятниця")
    private    ArrayList<classes> friday;
    @SerializedName("Субота")
    private   ArrayList<classes> saturday;


    public week(ArrayList<classes> monday, ArrayList<classes> tuesday, ArrayList<classes> wednesday, ArrayList<classes> thursday, ArrayList<classes> friday, ArrayList<classes> saturday) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
    }

    public ArrayList<classes> getMonday() {
        return monday;
    }

    public ArrayList<classes> getTuesday() {
        return tuesday;
    }

    public ArrayList<classes> getWednesday() {
        return wednesday;
    }

    public ArrayList<classes> getThursday() {
        return thursday;
    }

    public ArrayList<classes> getFriday() {
        return friday;
    }

    public ArrayList<classes> getSaturday() {
        return saturday;
    }
}
