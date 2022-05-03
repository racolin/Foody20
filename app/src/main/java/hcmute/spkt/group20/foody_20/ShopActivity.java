package hcmute.spkt.group20.foody_20;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import hcmute.spkt.group20.foody_20.adapter.MealAdapter;
import hcmute.spkt.group20.foody_20.adapter.ShopAdapter;

public class ShopActivity extends AppCompatActivity {

    RecyclerView rv_shops, rv_meals;
    TextView tv_shop_chain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        mapping();

    }

    public void mapping() {
        tv_shop_chain = findViewById(R.id.tv_shop_chain);
        tv_shop_chain.setOnClickListener(v -> {
            Intent intent = new Intent(this, ShopChainActivity.class);
            startActivity(intent);
        });

        rv_shops = findViewById(R.id.rv_shops);
        rv_shops.setAdapter(new ShopAdapter(this, Support.createShops()));
        rv_shops.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        rv_meals = findViewById(R.id.rv_meals);
        rv_meals.setAdapter(new MealAdapter(this, Support.createMeals()));
        rv_meals.setLayoutManager(new GridLayoutManager(this, 2));
    }
}