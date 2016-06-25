package com.example.schedule.interfaces;

import com.example.schedule.Exemplar.week;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by UMF on 22.05.2016.
 */
public interface get_schedule {
    @GET("/libs/get_schedule.php/")
    Call<week> getSchedule(@Query("group_id") int group_id );




}
