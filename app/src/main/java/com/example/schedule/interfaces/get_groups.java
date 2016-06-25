package com.example.schedule.interfaces;

import com.example.schedule.Exemplar.Group;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by UMF on 25.05.2016.
 */
public interface get_groups {
    @GET("/libs/get_groups.php/")
    Call<Group[]> getGroups();
}
