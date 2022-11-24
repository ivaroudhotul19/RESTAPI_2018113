package com.example.retrofit_2018113.model;

import java.util.List;

public class MealList{
	private List<MealsItem> meals;

	public void setMeals(List<MealsItem> meals){
		this.meals = meals;
	}

	public List<MealsItem> getMeals(){
		return meals;
	}
}