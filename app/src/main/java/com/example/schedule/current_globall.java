package com.example.schedule;

import android.app.Application;

import com.example.schedule.Exemplar.Facultie;
import com.example.schedule.Exemplar.Group;
import com.example.schedule.Exemplar.Specialty;
import com.example.schedule.Exemplar.week;

import java.util.ArrayList;

/**
 * Created by UMF on 23.05.2016.
 */
public class current_globall extends Application {
    private  week week;
    private ArrayList<Group> all_groups;
    private ArrayList<Facultie> all_facultie;
    private ArrayList<Specialty> all_specialties;
    private int fac_id;
    private int spec_id;
    private  int group_id;


    public current_globall() {
    }


    public  week getWeek() {
        return week;
    }

    public void setWeek( week week) {
        this.week = week;
    }

    public ArrayList<Group> getAll_groups() {
        return all_groups;
    }

    public void setAll_groups(ArrayList<Group> all_groups) {
        this.all_groups = all_groups;
    }

    public ArrayList<Facultie> getAll_facultie() {
        return all_facultie;
    }

    public void setAll_facultie(ArrayList<Facultie> all_facultie) {
        this.all_facultie = all_facultie;
    }

    public ArrayList<Specialty> getAll_specialties() {
        return all_specialties;
    }

    public void setAll_specialties(ArrayList<Specialty> all_specialties) {
        this.all_specialties = all_specialties;
    }

    public int getFac_id() {
        return fac_id;
    }

    public void setFac_id(int fac_id) {
        this.fac_id = fac_id;
    }

    public int getSpec_id() {
        return spec_id;
    }

    public void setSpec_id(int spec_id) {
        this.spec_id = spec_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }
}
