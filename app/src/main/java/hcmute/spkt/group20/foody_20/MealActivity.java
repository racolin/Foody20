package hcmute.spkt.group20.foody_20;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import hcmute.spkt.group20.foody_20.adapter.CommentAdapter;
import hcmute.spkt.group20.foody_20.adapter.MealAdapter;
import hcmute.spkt.group20.foody_20.model.Meal;

public class MealActivity extends AppCompatActivity {

    RecyclerView rv_meals, rv_comments;
    TextView tv_save, tv_share;
    TextView tv_name, tv_shop_name, tv_address, tv_distance, tv_price,
            tv_origin_price, tv_description, tv_time_open, tv_comment_count,
            tv_saved_count, tv_shared_count, tv_rated_count;
    RatingBar rb_rated;
    Button btn_order_now;
    Button btn_contact, btn_submit;
    ImageButton iv_add_cart;
    Meal meal;
//    SlidrInterface slidr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        meal = (Meal) getIntent().getSerializableExtra("meal");

        initUI();
        initListener();
    }

    private void initUI() {

        tv_name = findViewById(R.id.tv_name);
        tv_name.setText(meal.getName());

        tv_shop_name = findViewById(R.id.tv_shop_name);
        tv_shop_name.setText(meal.getShop().getName());

        tv_address = findViewById(R.id.tv_address);
        tv_address.setText(meal.getShop().getAddress());

        tv_distance = findViewById(R.id.tv_distance);
        tv_distance.setText(meal.getShop().getDistance());

        tv_price = findViewById(R.id.tv_price);
        tv_price.setText(Support.toCurrency(meal.getPrice()));

        tv_origin_price = findViewById(R.id.tv_origin_price);
        tv_price.setText(Support.toCurrency(meal.getOrigin_price()));

        tv_description = findViewById(R.id.tv_description);
        tv_description.setText(meal.getDescription());

        tv_time_open = findViewById(R.id.tv_time_open);
        tv_time_open.setText(meal.getShop().getTime_open());

        tv_comment_count = findViewById(R.id.tv_comment_count);
        tv_comment_count.setText(String.valueOf(meal.getComment_count()));

        tv_saved_count = findViewById(R.id.tv_saved_count);
        tv_comment_count.setText(String.valueOf(meal.getSaved_count()));

        tv_shared_count = findViewById(R.id.tv_shared_count);
        tv_comment_count.setText(String.valueOf(meal.getShared_count()));

        tv_save = findViewById(R.id.tv_save);
        tv_share = findViewById(R.id.tv_share);

        rb_rated = findViewById(R.id.rb_rated);
        rb_rated.setRating(meal.getRated());


        iv_add_cart = findViewById(R.id.iv_add_cart);
        btn_contact = findViewById(R.id.btn_contact);
        btn_submit = findViewById(R.id.btn_submit);
        btn_order_now = findViewById(R.id.btn_order_now);

        rv_comments = findViewById(R.id.rv_shops);
        rv_comments.setAdapter(new CommentAdapter(meal.getComments()));
        rv_comments.setLayoutManager(new LinearLayoutManager(this));

        rv_meals = findViewById(R.id.rv_meals);
        rv_meals.setAdapter(new MealAdapter(this, Support.getRelatedMeal(meal)));
        rv_meals.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void initListener() {

        btn_contact.setOnClickListener(v -> {
            Intent intent = new Intent(this, ContactDialog.class);
            intent.putExtra("shop", meal.getShop());
            startActivity(intent);
        });

        btn_order_now.setOnClickListener(v -> {
            Intent intent = new Intent(this, OrderActivity.class);
            startActivity(intent);
        });

        iv_add_cart.setOnClickListener(v -> {
            Toast.makeText(this, "Xử lý sự kiện thêm giỏ hàng", Toast.LENGTH_SHORT).show();
        });

        btn_submit.setOnClickListener(v -> {
            Toast.makeText(this, "Xử lý sự kiện đăng bình luận", Toast.LENGTH_SHORT).show();
        });

        tv_shop_name.setOnClickListener(v -> {
            Intent intent = new Intent(this, ShopActivity.class);
            intent.putExtra("shop", meal.getShop());
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