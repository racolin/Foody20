package hcmute.spkt.group20.foody_20.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import hcmute.spkt.group20.foody_20.OrderActivity;
import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.Support;
import hcmute.spkt.group20.foody_20.dao.CartDao;
import hcmute.spkt.group20.foody_20.dao.CartItemDAO;
import hcmute.spkt.group20.foody_20.dao.MealDao;
import hcmute.spkt.group20.foody_20.dao.ShopDao;
import hcmute.spkt.group20.foody_20.model.Cart;
import hcmute.spkt.group20.foody_20.model.CartItem;
import hcmute.spkt.group20.foody_20.model.Meal;
import hcmute.spkt.group20.foody_20.model.Shop;

//OK

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder> {
    List<Cart> carts;
    Context context = null;

    public CartAdapter(Context context, List<Cart> carts) {
        this.carts = carts;
        this.context = context;
    }

    public void update(List<Cart> carts) {
        if (context != null) {
            this.carts = carts;
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_item_cart, parent, false);
        return new CartHolder(view);
    }

    public String getTotalPrice(int i) {
        int price = 0;
        for (CartItem item : CartItemDAO.getCartItemsByCartId(context, carts.get(i).getId())) {
            price += MealDao.getMealById(context, item.getMeal_id()).getPrice() * item.getAmount();
        }
        return Support.toCurrency(price);
    }

    public void updateTotalPrice(int i) {
        List<CartItem> cartItems = CartItemDAO.getCartItemsByCartId(context, carts.get(i).getId());
        if (cartItems == null || cartItems.size() == 0) {
            CartDao.delete(context, carts.get(i));
            carts.remove(i);
        }
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder holder, int position) {
        Shop shop = ShopDao.getShopById(context, carts.get(position).getShop_id());
        List<CartItem> cartItems = CartItemDAO.getCartItemsByCartId(context, carts.get(position).getId());
        holder.tv_distance.setText(shop.getDistance());
        holder.tv_total_price.setText(getTotalPrice(position));
        holder.tv_shop_name.setText(shop.getName());
        holder.rv_cart_item.setAdapter(new CartItemAdapter(this, position, context, cartItems));
        holder.rv_cart_item.setLayoutManager(new LinearLayoutManager(context));
        holder.btn_buy_now.setOnClickListener(v -> {
            Intent intent = new Intent(context, OrderActivity.class);
            intent.putExtra("cart", carts.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return carts.size();
    }

    protected class CartHolder extends RecyclerView.ViewHolder {
        TextView tv_shop_name, tv_distance, tv_total_price, tv_total_price_label;
        RecyclerView rv_cart_item;
        Button btn_buy_now;
        public CartHolder(@NonNull View itemView) {
            super(itemView);
            tv_total_price = itemView.findViewById(R.id.tv_total_price);
            tv_total_price_label = itemView.findViewById(R.id.tv_total_price_label);
            tv_distance = itemView.findViewById(R.id.tv_distance);
            tv_shop_name = itemView.findViewById(R.id.tv_shop_name);
            rv_cart_item = itemView.findViewById(R.id.rv_cart_item);
            btn_buy_now = itemView.findViewById(R.id.btn_buy_now);
        }
    }
}