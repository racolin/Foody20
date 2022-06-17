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
import hcmute.spkt.group20.foody_20.Support;
import hcmute.spkt.group20.foody_20.dao.CommentDao;
import hcmute.spkt.group20.foody_20.dao.ShopDao;
import hcmute.spkt.group20.foody_20.model.Comment;
import hcmute.spkt.group20.foody_20.model.Meal;
import hcmute.spkt.group20.foody_20.model.Shop;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealHolder> {

    List<Meal> meals;
    Context context;

    public MealAdapter(Context context, List<Meal> meals) {
        this.context = context;
        this.meals = meals;
    }

    @NonNull
    @Override
    public MealHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.meal_item_2, parent, false);
        return new MealHolder(view);
    }

    public void update(List<Meal> meals) {
        this.meals = meals;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MealHolder holder, int position) {
        Shop shop = ShopDao.getShopById(context, meals.get(position).getShop_id());
        List<Comment> comments = CommentDao.getCommentsByMealId(context, meals.get(position).getId());
        float rate = 0;
        for (Comment comment : comments) {
            rate += comment.getRate();
        }
        if (comments.size() > 0) {
            rate /= comments.size();
        } else {
            rate = 5;
        }
        holder.iv_meal.setImageResource(meals.get(position).getImage());
        holder.tv_name.setText(meals.get(position).getName());
        holder.tv_description.setText(meals.get(position).getDescription());
        holder.tv_rated.setText(String.valueOf((int) rate));
        holder.tv_distance.setText(shop.getDistance());

        holder.itemView.setOnClickListener((View v) -> {
            Intent intent = new Intent(context, MealActivity.class);
            intent.putExtra("meal", meals.get(position));
            (context).startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }


    protected class MealHolder extends RecyclerView.ViewHolder {
        ImageView iv_meal;
        TextView tv_name, tv_description, tv_distance, tv_rated;

        public MealHolder(@NonNull View itemView) {

            super(itemView);
            this.iv_meal = itemView.findViewById(R.id.iv_meal);
            this.tv_name = itemView.findViewById(R.id.tv_name);
            this.tv_description = itemView.findViewById(R.id.tv_description);
            this.tv_distance = itemView.findViewById(R.id.tv_distance);
            this.tv_rated = itemView.findViewById(R.id.tv_rated);

//            Đặt kích thước của item thành 1 nửa màn hình
            DisplayMetrics metrics = new DisplayMetrics();
            ((AppCompatActivity) context).getWindowManager().getDefaultDisplay().getMetrics(metrics);
            int width = metrics.widthPixels;
            itemView.setLayoutParams(new RecyclerView.LayoutParams(width / 2, RecyclerView.LayoutParams.WRAP_CONTENT));
        }
    }
}
