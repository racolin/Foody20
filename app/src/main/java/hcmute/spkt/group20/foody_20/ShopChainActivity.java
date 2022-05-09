package hcmute.spkt.group20.foody_20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import hcmute.spkt.group20.foody_20.adapter.ShopAdapter;
import hcmute.spkt.group20.foody_20.model.ShopChain;

public class ShopChainActivity extends AppCompatActivity {

    RecyclerView rv_shops;
    RatingBar rb_rated;
    TextView tv_shops_amount, tv_description, tv_name;
    ShopChain shop_chain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_chain);
        shop_chain = (ShopChain) getIntent().getSerializableExtra("shop_chain");
        initUI();
        initListener();
    }

    public void initUI() {
        rv_shops = findViewById(R.id.rv_shops);
        rv_shops.setLayoutManager(new GridLayoutManager(this, 2));
        rv_shops.setAdapter(new ShopAdapter(this, shop_chain.getShops()));
        tv_name = findViewById(R.id.tv_name);
        tv_name.setText(shop_chain.getName());
        rb_rated = findViewById(R.id.rb_rated);
        rb_rated.setRating(shop_chain.getRated());
        tv_shops_amount = findViewById(R.id.tv_shops_amount);
        tv_shops_amount.setText(shop_chain.getShop_count());
        tv_description = findViewById(R.id.tv_description);
        tv_description.setText(shop_chain.getDescription());
    }

    public void initListener() {

    }
}