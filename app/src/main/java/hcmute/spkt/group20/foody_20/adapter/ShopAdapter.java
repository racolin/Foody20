package hcmute.spkt.group20.foody_20.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.spkt.group20.foody_20.HomeActivity;
import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.ShopActivity;
import hcmute.spkt.group20.foody_20.ShopChainActivity;
import hcmute.spkt.group20.foody_20.dao.ShopChainDao;
import hcmute.spkt.group20.foody_20.model.Shop;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopHolder> {
    List<Shop> shops;
    Context context;

    public ShopAdapter(Context context, List<Shop> shops) {
        this.context = context;
        this.shops = shops;
    }

    @NonNull
    @Override
    public ShopHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_item_2, parent, false);
        ShopHolder holder = new ShopHolder(view);
        view.setOnClickListener(v -> {
            Intent intent = new Intent((HomeActivity) context, ShopActivity.class);
            ((AppCompatActivity) context).startActivity(intent);
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopHolder holder, int position) {
        holder.iv_shop.setImageResource(shops.get(position).getImage());
        holder.tv_name.setText(shops.get(position).getName());
        holder.tv_description.setText(shops.get(position).getDescription());
        holder.tv_distance.setText(shops.get(position).getDistance());
        holder.tv_rated.setText(String.valueOf(4));
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ShopChainActivity.class);
            intent.putExtra("shop_chain", ShopChainDao.getShopChainById(context, shops.get(position).getShop_chain_id()));
            (context).startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return shops.size();
    }


    protected class ShopHolder extends RecyclerView.ViewHolder {
        ImageView iv_shop;
        TextView tv_name, tv_description, tv_distance, tv_rated;

        public ShopHolder(@NonNull View itemView) {
            super(itemView);
            iv_shop = itemView.findViewById(R.id.iv_shop);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_rated = itemView.findViewById(R.id.tv_rated);
            tv_distance = itemView.findViewById(R.id.tv_distance);

            DisplayMetrics metrics = new DisplayMetrics();
            ((AppCompatActivity) context).getWindowManager().getDefaultDisplay().getMetrics(metrics);
            int width = metrics.widthPixels;
            itemView.setLayoutParams(new RecyclerView.LayoutParams(width / 2, RecyclerView.LayoutParams.WRAP_CONTENT));
        }
    }
}
