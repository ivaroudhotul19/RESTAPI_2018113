package com.example.retrofit_2018113.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofit_2018113.R;
import com.example.retrofit_2018113.model.MealsItem;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealViewHolder> {
  private Context context;
  private List<MealsItem> mealList;

  public MealAdapter(Context context, List<MealsItem> mealList) {
    this.context = context;
    this.mealList = mealList;
  }

  public List<MealsItem> getMealList() {
    return mealList;
  }

  public void setMealList(List<MealsItem> mealList) {
    this.mealList = mealList;
  }

  @NonNull
  @Override
  public MealAdapter.MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_characters, parent, false);
    return new MealAdapter.MealViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull MealAdapter.MealViewHolder holder, int position) {
    MealsItem mealsItem = getMealList().get(position);
    Glide.with(context).load(mealsItem.getStrMealThumb()).into(holder.imageLogo);
    holder.tvName.setText(mealsItem.getStrMeal());
    holder.tvCategory.setText(mealsItem.getStrCategory());
    holder.tvArea.setText(mealsItem.getStrArea());
  }


  @Override
  public int getItemCount() {
    return mealList.size();
  }

  public static class MealViewHolder extends RecyclerView.ViewHolder {
    ImageView imageLogo;
    TextView tvName, tvCategory,tvArea;
    public MealViewHolder(View itemView) {
      super(itemView);
      tvName = itemView.findViewById(R.id.tv_name);
      tvCategory = itemView.findViewById(R.id.tv_category);
      tvArea = itemView.findViewById(R.id.tv_area);
      imageLogo = itemView.findViewById(R.id.image_logo);
    }
  }
}
