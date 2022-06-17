package hcmute.spkt.group20.foody_20;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.number.Scale;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.maps.SupportMapFragment;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import hcmute.spkt.group20.foody_20.adapter.CartItemAdapter;
import hcmute.spkt.group20.foody_20.dao.CartDao;
import hcmute.spkt.group20.foody_20.dao.CartItemDAO;
import hcmute.spkt.group20.foody_20.dao.MealDao;
import hcmute.spkt.group20.foody_20.dao.OrderDao;
import hcmute.spkt.group20.foody_20.dao.ShopDao;
import hcmute.spkt.group20.foody_20.model.Cart;
import hcmute.spkt.group20.foody_20.model.CartItem;
import hcmute.spkt.group20.foody_20.model.Shop;

public class OrderActivity extends AppCompatActivity {

    SupportMapFragment mf_order;
    TextView tv_shop_name, tv_distance, tv_total_price, tv_time;
    RecyclerView rv_cart_item;
    Button btn_buy_now, btn_order_now;
    ImageButton ib_choose_time;
    Cart cart;
    int hour, minute;
    CartItemAdapter adapter;
    List<CartItem> cartItems;
    Calendar pick;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        cart = (Cart) getIntent().getSerializableExtra("cart");

        initUI();
        initListener();
        
        mf_order = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fm_order);
        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fm_order, mapFragment)
                .commit();
    }
    
    public void initUI() {
        Shop shop = ShopDao.getShopById(this, cart.getShop_id());
        cartItems = CartItemDAO.getCartItemsByCartId(this, cart.getId());

        tv_total_price = findViewById(R.id.tv_total_price);
        tv_total_price.setText(getTotalPrice());

        tv_distance = findViewById(R.id.tv_distance);
        tv_distance.setText(shop.getDistance());

        tv_shop_name = findViewById(R.id.tv_shop_name);
        tv_shop_name.setText(shop.getName());

        rv_cart_item = findViewById(R.id.rv_cart_item);
        adapter = new CartItemAdapter(this, this, cartItems);
        rv_cart_item.setAdapter(adapter);
        rv_cart_item.setLayoutManager(new LinearLayoutManager(this));

        btn_order_now = findViewById(R.id.btn_order_now);

        btn_buy_now = findViewById(R.id.btn_buy_now);
        btn_buy_now.setVisibility(View.GONE);

        tv_time = findViewById(R.id.tv_time);
        ib_choose_time = findViewById(R.id.ib_choose_time);
    }

    public String getTotalPrice() {
        int price = 0;
        for (CartItem item : CartItemDAO.getCartItemsByCartId(this, cart.getId())) {
            price += MealDao.getMealById(this, item.getMeal_id()).getPrice() * item.getAmount();
        }
        return Support.toCurrency(price);
    }

    public void updateTotalPrice() {
        List<CartItem> cartItems = CartItemDAO.getCartItemsByCartId(this, cart.getId());
        if (cartItems == null || cartItems.size() == 0) {
            CartDao.delete(this, cart);
            finish();
        }
        adapter.notifyDataSetChanged();
        tv_total_price.setText(getTotalPrice());
    }
    
    public void initListener() {
        btn_order_now.setOnClickListener(v -> {
            OrderDao.saveFromCart(this, cart, pick.getTime());
            Toast.makeText(this, "Đặt hàng thành công!", Toast.LENGTH_SHORT).show();
            finish();
        });
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 30);
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
        ib_choose_time.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(OrderActivity.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                            pick = Calendar.getInstance();
                            pick.set(Calendar.YEAR, i);
                            pick.set(Calendar.MONTH, i1);
                            pick.set(Calendar.DATE, i2);
                            TimePickerDialog timePickerDialog = new TimePickerDialog(OrderActivity.this,
                                    new TimePickerDialog.OnTimeSetListener() {
                                        @Override
                                        public void onTimeSet(TimePicker timePicker, int i, int i1) {
                                            pick.set(Calendar.HOUR, i);
                                            pick.set(Calendar.MINUTE, i1);
                                            pick.set(Calendar.SECOND, 0);
                                            if (calendar.compareTo(pick) > 0) {
                                                pick.set(Calendar.MINUTE, i1);
                                                pick.set(Calendar.HOUR, i);
                                                pick.set(Calendar.DATE, calendar.get(Calendar.DATE));
                                                pick.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
                                                pick.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
                                            }
                                            tv_time.setText(Support.toDateString(pick, "HH:mm dd/MM/yyyy"));
                                        }
                                    }, hour, minute, true);
                            timePickerDialog.show();
                        }
                    }, 2022, 5, 8);
            DatePicker datePicker = datePickerDialog.getDatePicker();
            datePicker.setMinDate(calendar.getTimeInMillis());
            datePicker.setMaxDate(calendar.getTimeInMillis() + 86400000*3);
            datePickerDialog.show();
        });
    }
}