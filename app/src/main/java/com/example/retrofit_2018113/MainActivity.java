package com.example.retrofit_2018113;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofit_2018113.adapter.MealAdapter;
import com.example.retrofit_2018113.model.MealList;
import com.example.retrofit_2018113.viewmodel.MealViewModel;

public class MainActivity extends AppCompatActivity {
    RecyclerView recylerView;
    MealAdapter adapter;
    MealViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recylerView = findViewById(R.id.rv_characters);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recylerView.setLayoutManager(linearLayoutManager);
        viewModel = new MealViewModel();
        viewModel.getMealList().observe(this, new Observer<MealList>() {
            @Override
            public void onChanged(MealList mealList) {
                if (mealList.getMeals() != null) {
                    adapter = new MealAdapter(MainActivity.this, mealList.getMeals());
                    adapter.notifyDataSetChanged();
                    recylerView.setAdapter(adapter);
                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}