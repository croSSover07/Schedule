package com.example.schedule.interfaces;

import com.example.schedule.Exemplar.Facultie;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by UMF on 25.05.2016.
 */
public interface get_faculties {
    @GET("/libs/get_faculties.php/")
    Call<Facultie[]> getFaculties();
}
