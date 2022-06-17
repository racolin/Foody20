package hcmute.spkt.group20.foody_20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import hcmute.spkt.group20.foody_20.adapter.ShopAdapter;
import hcmute.spkt.group20.foody_20.dao.ShopChainDao;
import hcmute.spkt.group20.foody_20.dao.ShopDao;
import hcmute.spkt.group20.foody_20.model.Shop;
import hcmute.spkt.group20.foody_20.model.ShopChain;

public class ShopChainActivity extends AppCompatActivity {

    RecyclerView rv_shops;
    RatingBar rb_rated;
    TextView tv_shops_amount, tv_description, tv_name;
    ShopChain shop_chain;
    ImageView iv_shop_chain;
    List<Shop> shops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_chain);
        shop_chain = (ShopChain) getIntent().getSerializableExtra("shop_chain");
        shops = ShopDao.getShopsByShopChainId(this, shop_chain.getId());
        initUI();
        initListener();
    }

    public void initUI() {
        iv_shop_chain = findViewById(R.id.iv_shop_chain);
        iv_shop_chain.setImageResource(shop_chain.getImage());
        rv_shops = findViewById(R.id.rv_shops);
        rv_shops.setLayoutManager(new GridLayoutManager(this, 2));
        rv_shops.setAdapter(new ShopAdapter(this, shops));
        tv_name = findViewById(R.id.tv_name);
        tv_name.setText(shop_chain.getName());
        rb_rated = findViewById(R.id.rb_rated);
        rb_rated.setRating(4.5F);
        tv_shops_amount = findViewById(R.id.tv_shops_amount);
        tv_shops_amount.setText(String.valueOf(shops.size()));
        tv_description = findViewById(R.id.tv_description);
        tv_description.setText(shop_chain.getDescription());
    }

    public void initListener() {

    }
}