package hcmute.spkt.group20.foody_20.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.model.Cart;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder> {

    Context context;
    LayoutInflater inflater;
    List<Cart> carts;

    public CartAdapter(Context context, List<Cart> carts) {
        this.carts = carts;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.meal_item_cart_1, parent, false);
        CartHolder holder = new CartHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder holder, int position) {
        holder.iv_meal.setImageResource(carts.get(position).getImage());
        holder.tv_title.setText(carts.get(position).getTitle());
        holder.tv_price.setText(carts.get(position).getPrice());
//        button
    }

    @Override
    public int getItemCount() {
        return carts.size();
    }

    protected class CartHolder extends RecyclerView.ViewHolder {

        ImageView iv_meal;
        TextView tv_title, tv_price;
        Button btn_order_now;

        public CartHolder(@NonNull View itemView) {
            super(itemView);
            iv_meal = itemView.findViewById(R.id.iv_meal);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_price = itemView.findViewById(R.id.tv_price);
            btn_order_now = itemView.findViewById(R.id.btn_buy_now);
        }
    }
}