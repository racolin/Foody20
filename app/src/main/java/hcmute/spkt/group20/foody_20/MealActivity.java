package hcmute.spkt.group20.foody_20;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import hcmute.spkt.group20.foody_20.adapter.CommentAdapter;
import hcmute.spkt.group20.foody_20.adapter.MealAdapter;

public class MealActivity extends AppCompatActivity {

    RecyclerView rv_meals, rv_comments;
    TextView tv_shop;
    Button btn_order_now;
    Button btn_contact;
    ContactDialog dialog;
    Intent intent;
//    SlidrInterface slidr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

//        slidr = Slidr.attach(this);

        mapping();

    }

    public void mapping() {

        intent = new Intent(this, ContactDialog.class);
        btn_contact = findViewById(R.id.btn_contact);
        btn_contact.setOnClickListener(v -> {
            startActivity(intent);
        });

        btn_order_now = findViewById(R.id.btn_order_now);
        btn_order_now.setOnClickListener(v -> {
            Intent intent = new Intent(this, OrderActivity.class);
            startActivity(intent);
        });

        tv_shop = findViewById(R.id.tv_shop);
        tv_shop.setOnClickListener(v -> {
            Intent intent = new Intent(this, ShopActivity.class);
            startActivity(intent);
        });

        rv_comments = findViewById(R.id.rv_shops);
        rv_comments.setAdapter(new CommentAdapter(Support.createComments()));
        rv_comments.setLayoutManager(new LinearLayoutManager(this));

        rv_meals = findViewById(R.id.rv_meals);
        rv_meals.setAdapter(new MealAdapter(this, Support.createMeals()));
        rv_meals.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }
}