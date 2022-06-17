package hcmute.spkt.group20.foody_20;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

import hcmute.spkt.group20.foody_20.adapter.CommentAdapter;
import hcmute.spkt.group20.foody_20.adapter.MealAdapter;
import hcmute.spkt.group20.foody_20.dao.CartDao;
import hcmute.spkt.group20.foody_20.dao.CartItemDAO;
import hcmute.spkt.group20.foody_20.dao.CommentDao;
import hcmute.spkt.group20.foody_20.dao.MealDao;
import hcmute.spkt.group20.foody_20.dao.SavedMealDAO;
import hcmute.spkt.group20.foody_20.dao.ShopDao;
import hcmute.spkt.group20.foody_20.model.Cart;
import hcmute.spkt.group20.foody_20.model.CartItem;
import hcmute.spkt.group20.foody_20.model.Comment;
import hcmute.spkt.group20.foody_20.model.Meal;
import hcmute.spkt.group20.foody_20.model.Shop;

public class MealActivity extends AppCompatActivity {

    RecyclerView rv_meals, rv_comments;
    TextView tv_save, tv_share, tv_type;
    TextView tv_name, tv_shop_name, tv_address, tv_distance, tv_price,
            tv_origin_price, tv_description, tv_time_open, tv_comment_count,
            tv_saved_count, tv_shared_count;
    EditText et_content;
    RatingBar rb_rated, rb_rate;
    Button btn_order_now, btn_contact, btn_submit;
    ImageView iv_meal;
    ImageButton iv_add_cart;
    Meal meal;
    Shop shop;
    List<Comment> comments;
    int user_id;
    CommentAdapter adapter;
//    SlidrInterface slidr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        SharedPreferences preferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        user_id = preferences.getInt("user_id", -1);

        meal = (Meal) getIntent().getSerializableExtra("meal");
        shop = ShopDao.getShopById(this, meal.getShop_id());
        comments = CommentDao.getCommentsByMealId(this, meal.getId());
        initUI();
        initListener();
    }

    private void initUI() {
        et_content = findViewById(R.id.et_content);
        tv_type = findViewById(R.id.tv_type);

        iv_meal = findViewById(R.id.iv_meal);
        iv_meal.setImageResource(meal.getImage());

        tv_name = findViewById(R.id.tv_name);
        tv_name.setText(meal.getName());


        tv_shop_name = findViewById(R.id.tv_shop_name);
        tv_shop_name.setText(shop.getName());

        tv_address = findViewById(R.id.et_address);
        tv_address.setText(shop.getAddress());

        tv_distance = findViewById(R.id.tv_distance);
        tv_distance.setText(shop.getDistance());

        tv_price = findViewById(R.id.tv_price);
        tv_price.setText(Support.toCurrency(meal.getPrice()));

        tv_origin_price = findViewById(R.id.tv_origin_price);
        tv_origin_price.setVisibility(View.GONE);

        tv_description = findViewById(R.id.tv_description);
        tv_description.setText(meal.getDescription());

        tv_time_open = findViewById(R.id.tv_time_open);
        tv_time_open.setText(shop.getTime_open());

        tv_comment_count = findViewById(R.id.tv_comment_count);
        tv_comment_count.setText(String.valueOf(comments.size()));

        tv_saved_count = findViewById(R.id.tv_saved_count);
        tv_saved_count.setText(String.valueOf(SavedMealDAO.saved_count(this, meal.getId())));

        tv_shared_count = findViewById(R.id.tv_shared_count);
        tv_shared_count.setText(String.valueOf(meal.getShared_count()));

        tv_save = findViewById(R.id.tv_save);
        tv_share = findViewById(R.id.tv_share);

        rb_rated = findViewById(R.id.rb_rated);
        rb_rated.setRating(Support.getRating(comments));
        rb_rate = findViewById(R.id.rb_rate);
        rb_rate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                tv_type.setText(Support.getTypeRate(v));
            }
        });


        iv_add_cart = findViewById(R.id.iv_add_cart);
        btn_contact = findViewById(R.id.btn_contact);
        btn_submit = findViewById(R.id.btn_submit);
        btn_order_now = findViewById(R.id.btn_order_now);

        rv_comments = findViewById(R.id.rv_shops);
        adapter = new CommentAdapter(this, comments);
        rv_comments.setAdapter(adapter);
        rv_comments.setLayoutManager(new LinearLayoutManager(this));

        rv_meals = findViewById(R.id.rv_meals);
        rv_meals.setAdapter(new MealAdapter(this, MealDao.getMealsByShopId(this, meal.getShop_id())));
        rv_meals.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void initListener() {

        btn_contact.setOnClickListener(v -> {
            Intent intent = new Intent(this, ContactDialog.class);
            Shop shop = ShopDao.getShopById(this, meal.getShop_id());
            intent.putExtra("shop", shop);
            startActivity(intent);
        });

        btn_order_now.setOnClickListener(v -> {
            SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
            int user_id = preferences.getInt("user_id", -1);
            if (user_id == -1) {
                Toast.makeText(this, "Đăng nhập để đặt hàng", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, OrderActivity.class);
                intent.putExtra("cart", CartDao.getCartByShopIdAndUserId(this, meal.getShop_id(), user_id));
                startActivity(intent);
            }
        });

        iv_add_cart.setOnClickListener(v -> {
            SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
            int user_id = preferences.getInt("user_id", -1);
            if (user_id == -1) {
                Toast.makeText(this, "Đăng nhập để đặt hàng", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            } else {
                Cart cart = CartDao.getCartByShopIdAndUserId(this, shop.getId(), user_id);
                if (cart == null) {
                    cart = new Cart(-1, user_id, shop.getId());
                    CartDao.save(this, cart);
                }
                cart = CartDao.getCartByShopIdAndUserId(this, cart.getShop_id(), cart.getUser_id());
                CartItem cartItem = CartItemDAO.getCartItemByCartIdAndMealId(this, cart.getId(), meal.getId());
                if (cartItem == null) {
                    cartItem = new CartItem(-1, cart.getId(), meal.getId(), 1);
                    CartItemDAO.save(this, cartItem);
                } else {
                    cartItem.setAmount(cartItem.getAmount() + 1);
                    CartItemDAO.update(this, cartItem);
                }
                Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btn_submit.setOnClickListener(v -> {
            if (user_id == -1) {
                Intent intent = new Intent(this, LoginActivity.class);
                Toast.makeText(this, "Đăng nhập để bình luận", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            } else {
                Comment comment = new Comment();
                comment.setContent(et_content.getText().toString());
                comment.setMeal_id(meal.getId());
                comment.setUser_id(user_id);
                comment.setTime_created(new Date());
                comment.setRate(rb_rate.getRating());
                CommentDao.save(this, comment);
                comments = CommentDao.getCommentsByMealId(this, meal.getId());
                adapter.update(comments);
                adapter.notifyDataSetChanged();
                et_content.setText("");
                rb_rate.setRating(5);
                tv_type.setText(Support.getTypeRate(5F));
                tv_comment_count.setText(String.valueOf(comments.size()));
                Toast.makeText(this, "Đăng tải thành công", Toast.LENGTH_SHORT).show();
            }
        });

        tv_shop_name.setOnClickListener(v -> {
            Intent intent = new Intent(this, ShopActivity.class);
            intent.putExtra("shop", shop);
            startActivity(intent);
        });

        tv_share.setOnClickListener(v -> {
            Toast.makeText(this, "Xử lý sự kiện share", Toast.LENGTH_SHORT).show();
        });

        tv_save.setOnClickListener(v -> {
            if (user_id != -1) {
                SavedMealDAO.save(this, user_id, meal.getId());
                Toast.makeText(this, "Đã lưu!", Toast.LENGTH_SHORT).show();
                tv_saved_count.setText(String.valueOf(SavedMealDAO.saved_count(this, meal.getId())));
            } else {
                Toast.makeText(this, "Bạn cần đăng nhập!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}