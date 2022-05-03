package hcmute.spkt.group20.foody_20.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.spkt.group20.foody_20.MealActivity;
import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.model.Meal;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealHolder> {

    List<Meal> meals;
    Context context;
    LayoutInflater inflater;

    public MealAdapter(Context context, List<Meal> meals) {
        this.context = context;
        this.meals = meals;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MealHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.meal_item_2, parent, false);
        view.setOnClickListener((View v) -> {
            Intent intent = new Intent((AppCompatActivity) context, MealActivity.class);
            ((AppCompatActivity) context).startActivity(intent);
        });
        MealHolder holder = new MealHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MealHolder holder, int position) {
        holder.iv_meal.setImageResource(meals.get(position).getImage());
        holder.tv_title.setText(meals.get(position).getName());
        holder.tv_description.setText(meals.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }


    protected class MealHolder extends RecyclerView.ViewHolder {
        ImageView iv_meal;
        TextView tv_title, tv_description;

        public MealHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_meal = itemView.findViewById(R.id.iv_meal);
            this.tv_title = itemView.findViewById(R.id.tv_title);
            this.tv_description = itemView.findViewById(R.id.tv_description);
            DisplayMetrics metrics = new DisplayMetrics();
            ((AppCompatActivity) context).getWindowManager().getDefaultDisplay().getMetrics(metrics);
            int width = metrics.widthPixels;
            itemView.setLayoutParams(new RecyclerView.LayoutParams(width / 2, RecyclerView.LayoutParams.WRAP_CONTENT));
        }
    }
}
