package com.example.schedule.Exemplar;

/**
 * Created by UMF on 25.05.2016.
 */
public class Group {
    private final int id;
    private final String title;
    private final int specialty;

    public Group(int id, String title, int specialty) {
        this.id = id;
        this.title = title;
        this.specialty = specialty;
    }

    public int getSpecialty() {
        return specialty;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }
}
