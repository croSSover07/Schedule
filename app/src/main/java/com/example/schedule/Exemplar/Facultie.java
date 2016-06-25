package com.example.schedule.Exemplar;

/**
 * Created by UMF on 25.05.2016.
 */
public class Facultie {
    private final int id;
    private final String title;

    public Facultie(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
