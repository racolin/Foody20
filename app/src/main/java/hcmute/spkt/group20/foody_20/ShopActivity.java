package hcmute.spkt.group20.foody_20;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import hcmute.spkt.group20.foody_20.adapter.MealAdapter;
import hcmute.spkt.group20.foody_20.adapter.ShopAdapter;
import hcmute.spkt.group20.foody_20.dao.MealDao;
import hcmute.spkt.group20.foody_20.dao.SavedMealDAO;
import hcmute.spkt.group20.foody_20.dao.SavedShopDAO;
import hcmute.spkt.group20.foody_20.dao.ShopChainDao;
import hcmute.spkt.group20.foody_20.dao.ShopDao;
import hcmute.spkt.group20.foody_20.model.Shop;
import hcmute.spkt.group20.foody_20.model.ShopChain;

public class ShopActivity extends AppCompatActivity {

    RecyclerView rv_shops, rv_meals;
    TextView tv_shop_chain, tv_name, tv_distance, tv_description, tv_time_open, tv_save, tv_share, tv_saved_count;
    Button btn_contact;
    RatingBar rb_rated;
    ImageView iv_shop;
    Shop shop;
    ShopChain shopChain;
    int user_id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        SharedPreferences preferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        user_id = preferences.getInt("user_id", -1);

        shop = (Shop) getIntent().getSerializableExtra("shop");

        shop = ShopDao.getShopById(this, shop.getId());

        initUI();

        initListener();
    }

    private void initUI() {
        tv_saved_count = findViewById(R.id.tv_saved_count);
        tv_saved_count.setText(String.valueOf(SavedShopDAO.saved_count(this, shop.getId())));
        shopChain = ShopChainDao.getShopChainById(this, shop.getShop_chain_id());
        iv_shop = findViewById(R.id.iv_shop);
        iv_shop.setImageResource(shop.getImage());
        tv_save = findViewById(R.id.tv_save);
        tv_share = findViewById(R.id.tv_share);
        tv_shop_chain = findViewById(R.id.tv_shop_chain);
        tv_shop_chain.setText(shopChain.getName());
        tv_name = findViewById(R.id.tv_name);
        tv_name.setText(shop.getName());
        tv_distance = findViewById(R.id.tv_distance);
        tv_distance.setText(shop.getDistance());
        tv_description = findViewById(R.id.tv_description);
        tv_description.setText(shop.getDescription());
        tv_time_open = findViewById(R.id.tv_time_open);
        tv_time_open.setText(shop.getTime_open());
        rb_rated = findViewById(R.id.rb_rated);
        rb_rated.setRating(4.5F);

        btn_contact = findViewById(R.id.btn_contact);

        rv_shops = findViewById(R.id.rv_shops);
        rv_shops.setAdapter(new ShopAdapter(this, ShopDao.getShopsByShopChainId(this, shop.getShop_chain_id())));
        rv_shops.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        rv_meals = findViewById(R.id.rv_meals);
        rv_meals.setAdapter(new MealAdapter(this, MealDao.getMealsByShopId(this, shop.getId())));
        rv_meals.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void initListener() {
        tv_shop_chain.setOnClickListener(v -> {
            Intent intent = new Intent(this, ShopChainActivity.class);
            intent.putExtra("shop_chain", shopChain);
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
            if (user_id != -1) {
                SavedShopDAO.save(this, user_id, shop.getId());
                Toast.makeText(this, "Đã lưu!", Toast.LENGTH_SHORT).show();
                tv_saved_count.setText(String.valueOf(SavedShopDAO.saved_count(this, shop.getId())));
            } else {
                Toast.makeText(this, "Bạn cần đăng nhập!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}