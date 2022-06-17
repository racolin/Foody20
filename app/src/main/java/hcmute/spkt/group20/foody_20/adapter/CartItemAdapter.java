package hcmute.spkt.group20.foody_20.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.spkt.group20.foody_20.OrderActivity;
import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.Support;
import hcmute.spkt.group20.foody_20.dao.CartDao;
import hcmute.spkt.group20.foody_20.dao.CartItemDAO;
import hcmute.spkt.group20.foody_20.dao.MealDao;
import hcmute.spkt.group20.foody_20.model.CartItem;
import hcmute.spkt.group20.foody_20.model.Meal;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.CartItemHolder> {
    Context context;
    List<CartItem> cart_items;
    CartAdapter adapter;
    OrderActivity orderActivity;
    int i = -1;

    public CartItemAdapter(Context context, List<CartItem> cart_items) {
        this.cart_items = cart_items;
        this.context = context;
    }

    public CartItemAdapter(CartAdapter adapter, int i, Context context, List<CartItem> cart_items) {
        this.cart_items = cart_items;
        this.context = context;
        this.adapter = adapter;
        this.i = i;
    }

    public CartItemAdapter(OrderActivity orderActivity, Context context, List<CartItem> cart_items) {
        this.cart_items = cart_items;
        this.context = context;
        this.orderActivity = orderActivity;
    }

    @NonNull
    @Override
    public CartItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_meal_in_cart, parent, false);
        return new CartItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemHolder holder, int position) {
        Meal meal = MealDao.getMealById(context, cart_items.get(position).getMeal_id());
        holder.iv_meal.setImageResource( meal.getImage());
        holder.tv_name.setText(meal.getName());
        holder.tv_price.setText(Support.toCurrency(meal.getPrice() * cart_items.get(position).getAmount()));
        holder.tv_amount.setText(String.valueOf(cart_items.get(position).getAmount()));
        holder.ib_inc.setOnClickListener(v -> {
            int r = cart_items.get(position).getAmount() + 1;
            cart_items.get(position).setAmount(r);
            CartItemDAO.update(context, cart_items.get(position));
            if (i != -1) {
                adapter.updateTotalPrice(i);
            } else {
                orderActivity.updateTotalPrice();
            }
        });
        holder.ib_dec.setOnClickListener(v -> {
            int r = cart_items.get(position).getAmount();
            r = r > 1 ? r - 1 : 1;
            cart_items.get(position).setAmount(r);
            CartItemDAO.update(context, cart_items.get(position));
            if (i != -1) {
                adapter.updateTotalPrice(i);
            } else {
                orderActivity.updateTotalPrice();
            }
        });
        holder.ib_delete.setOnClickListener(v -> {
            CartItemDAO.delete(context, cart_items.get(position));
            cart_items.remove(position);
            if (i != -1) {
                adapter.updateTotalPrice(i);
            } else {
                orderActivity.updateTotalPrice();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cart_items.size();
    }

    protected class CartItemHolder extends RecyclerView.ViewHolder {

        ImageView iv_meal;
        TextView tv_name, tv_price, tv_amount;
        ImageButton ib_delete, ib_dec, ib_inc;

        public CartItemHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_amount = itemView.findViewById(R.id.tv_amount);
            iv_meal = itemView.findViewById(R.id.iv_meal);
            ib_delete = itemView.findViewById(R.id.ib_delete);
            ib_dec = itemView.findViewById(R.id.ib_dec);
            ib_inc = itemView.findViewById(R.id.ib_inc);
        }
    }


}
