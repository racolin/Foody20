package hcmute.spkt.group20.foody_20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import hcmute.spkt.group20.foody_20.adapter.ShopAdapter;

public class ShopChainActivity extends AppCompatActivity {

    RecyclerView rv_shops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_chain);

        mapping();
    }

    public void mapping() {
        rv_shops = findViewById(R.id.rv_shops);
        rv_shops.setLayoutManager(new GridLayoutManager(this, 2));
        rv_shops.setAdapter(new ShopAdapter(this, Support.createShops()));
    }
}