package com.example.retrofit_2018113.api;

import com.example.retrofit_2018113.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
  private static ApiClient instance;
  private Retrofit retrofit;

  private ApiClient() {
    retrofit = new Retrofit.Builder()
            .baseUrl(BuildConfig.BaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
  }

  public static synchronized ApiClient getInstance(){
    if(instance==null){
      instance = new ApiClient();
    }
    return instance;
  }

  public Api getApi(){
    return retrofit.create(Api.class);
  }
}
