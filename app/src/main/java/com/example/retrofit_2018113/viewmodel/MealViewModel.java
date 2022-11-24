package com.example.retrofit_2018113.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.retrofit_2018113.api.ApiClient;
import com.example.retrofit_2018113.model.MealList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealViewModel {
  private static final String TAG = "MealViewModel";
  MutableLiveData<MealList> mealList;

  public MutableLiveData<MealList> getMealList() {
    if (mealList == null) {
      mealList = new MutableLiveData<>();
      setMealList();
    }
    return mealList;
  }

  private void setMealList() {
    ApiClient.getInstance().getApi().getMeals("a")
            .enqueue(new Callback<MealList>() {
              @Override
              public void onResponse(Call<MealList> call, Response<MealList> response) {
                if (response.isSuccessful()) {
                  mealList.postValue(response.body());
                }
              }

              @Override
              public void onFailure(Call<MealList> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
              }
            });
  }
}
