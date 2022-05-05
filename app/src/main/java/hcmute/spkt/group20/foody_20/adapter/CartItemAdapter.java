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
import hcmute.spkt.group20.foody_20.model.CartItem;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.CartItemHolder> {Context context;
    LayoutInflater inflater;
    List<CartItem> items;

    public CartItemAdapter(Context context, List<CartItem> items) {
        this.items = items;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CartItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = inflater.inflate(R.layout.meal_item_cart_1, parent, false);
        View view = inflater.inflate(R.layout.item_meal_in_cart, parent, false);
                CartItemHolder holder = new CartItemHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemHolder holder, int position) {
        holder.iv_meal.setImageResource(items.get(position).getImage());
        holder.tv_title.setText(items.get(position).getTitle());
        holder.tv_price.setText(items.get(position).getPriceCurrency());
        holder.tv_amount.setText(items.get(position).getAmount());
//        button
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected class CartItemHolder extends RecyclerView.ViewHolder {

        ImageView iv_meal;
        TextView tv_title, tv_price, tv_amount;

        public CartItemHolder(@NonNull View itemView) {
            super(itemView);
            iv_meal = itemView.findViewById(R.id.iv_meal);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_amount = itemView.findViewById(R.id.tv_amount);
        }
    }


}
