package hcmute.spkt.group20.foody_20;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import hcmute.spkt.group20.foody_20.adapter.MealAdapter;
import hcmute.spkt.group20.foody_20.adapter.ShopAdapter;
import hcmute.spkt.group20.foody_20.model.Shop;

public class ShopActivity extends AppCompatActivity {

    RecyclerView rv_shops, rv_meals;
    TextView tv_shop_chain, tv_name, tv_distance, tv_description, tv_time_open, tv_save, tv_share;
    Button btn_contact;
    RatingBar rb_rated;
    Shop shop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        shop = (Shop) getIntent().getSerializableExtra("shop");

        initUI();

        initListener();
    }

    private void initUI() {
        tv_save = findViewById(R.id.tv_save);
        tv_share = findViewById(R.id.tv_share);
        tv_shop_chain = findViewById(R.id.tv_shop_chain);
        tv_shop_chain.setText(shop.getShop_chain().getName());
        tv_name = findViewById(R.id.tv_name);
        tv_name.setText(shop.getName());
        tv_distance = findViewById(R.id.tv_distance);
        tv_distance.setText(shop.getDistance());
        tv_description = findViewById(R.id.tv_description);
        tv_description.setText(shop.getDescription());
        tv_time_open = findViewById(R.id.tv_time_open);
        tv_time_open.setText(shop.getTime_open());
        rb_rated = findViewById(R.id.rb_rated);
        rb_rated.setRating(shop.getRated());

        btn_contact = findViewById(R.id.btn_contact);

        rv_shops = findViewById(R.id.rv_shops);
        rv_shops.setAdapter(new ShopAdapter(this, Support.getRelatedShops(shop)));
        rv_shops.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        rv_meals = findViewById(R.id.rv_meals);
        rv_meals.setAdapter(new MealAdapter(this, shop.getMeals()));
        rv_meals.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void initListener() {
        tv_shop_chain.setOnClickListener(v -> {
            Intent intent = new Intent(this, ContactDialog.class);
            intent.putExtra("shop_chain", shop.getShop_chain());
            startActivity(intent);
        });

        btn_contact.setOnClickListener(v -> {
            Intent intent = new Intent(this, ContactDialog.class);
            intent.putExtra("shop", shop);
            startActivity(intent);
        });

        tv_share.setOnClickListener(v -> {
            Toast.makeText(this, "Xử lý sự kiện share", Toast.LENGTH_SHORT).show();
        });

        tv_save.setOnClickListener(v -> {
            Toast.makeText(this, "Xử lý sự kiện lưu", Toast.LENGTH_SHORT).show();
        });
    }
}