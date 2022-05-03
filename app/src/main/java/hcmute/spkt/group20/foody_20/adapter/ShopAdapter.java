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
import hcmute.spkt.group20.foody_20.model.Shop;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopHolder> {
    List<Shop> shops;
    Context context;
    LayoutInflater inflater;

    public ShopAdapter(Context context, List<Shop> shops) {
        this.context = context;
        this.shops = shops;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ShopAdapter.ShopHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.shop_item_2, parent, false);
        ShopAdapter.ShopHolder holder = new ShopAdapter.ShopHolder(view);
        view.setOnClickListener(v -> {
            Intent intent = new Intent((HomeActivity) context, ShopActivity.class);
            ((AppCompatActivity) context).startActivity(intent);
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopAdapter.ShopHolder holder, int position) {
        holder.iv_shop.setImageResource(shops.get(position).getImage());
        holder.tv_title.setText(shops.get(position).getName());
        holder.tv_description.setText(shops.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return shops.size();
    }


    protected class ShopHolder extends RecyclerView.ViewHolder {
        ImageView iv_shop;
        TextView tv_title, tv_description;

        public ShopHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_shop = itemView.findViewById(R.id.iv_shop);
            this.tv_title = itemView.findViewById(R.id.tv_title);
            this.tv_description = itemView.findViewById(R.id.tv_description);
            DisplayMetrics metrics = new DisplayMetrics();
            ((AppCompatActivity) context).getWindowManager().getDefaultDisplay().getMetrics(metrics);
            int width = metrics.widthPixels;
            itemView.setLayoutParams(new RecyclerView.LayoutParams(width / 2, RecyclerView.LayoutParams.WRAP_CONTENT));
        }
    }
}
