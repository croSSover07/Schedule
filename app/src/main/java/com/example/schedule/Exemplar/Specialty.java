package com.example.schedule.Exemplar;

/**
 * Created by UMF on 25.05.2016.
 */
public class Specialty {
    private final int id;
    private final int faculty;
    private final String title;

    public Specialty(int id, int faculty, String title) {
        this.id = id;
        this.faculty = faculty;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getFaculty() {
        return faculty;
    }
}
