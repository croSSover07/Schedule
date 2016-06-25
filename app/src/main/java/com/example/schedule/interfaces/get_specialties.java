package com.example.schedule.interfaces;

import com.example.schedule.Exemplar.Specialty;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by UMF on 25.05.2016.
 */
public interface get_specialties {
    @GET("/libs/get_specialties.php/")
    Call<Specialty[]> getSpecialties();
}
