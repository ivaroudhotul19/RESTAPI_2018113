package com.example.retrofit_2018113.api;

import com.example.retrofit_2018113.model.MealList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("search.php")
    Call<MealList> getMeals(@Query("f") String mealName);
}
