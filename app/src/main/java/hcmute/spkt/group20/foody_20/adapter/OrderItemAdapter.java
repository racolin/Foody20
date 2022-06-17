package hcmute.spkt.group20.foody_20.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.Support;
import hcmute.spkt.group20.foody_20.dao.MealDao;
import hcmute.spkt.group20.foody_20.model.Meal;
import hcmute.spkt.group20.foody_20.model.OrderItem;

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.OrderAllItemHolder> {

    Context context;
    List<OrderItem> items;

    public OrderItemAdapter(Context context, List<OrderItem> items) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderAllItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.meal_item_in_order_1, parent, false);
        return new OrderAllItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAllItemHolder holder, int position) {
        Meal meal = MealDao.getMealById(context, items.get(position).getMeal_id());
        holder.tv_title.setText(meal.getName());
        holder.tv_amount.setText(String.valueOf(items.get(position).getAmount()));
        holder.tv_price.setText(Support.toCurrency(meal.getPrice()));
        holder.iv_meal.setImageResource(meal.getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected class OrderAllItemHolder extends RecyclerView.ViewHolder {
        public TextView tv_price, tv_amount, tv_title;
        ImageView iv_meal;
        public OrderAllItemHolder(@NonNull View itemView) {
            super(itemView);
            tv_amount = itemView.findViewById(R.id.tv_amount);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_title = itemView.findViewById(R.id.tv_name);
            iv_meal = itemView.findViewById(R.id.iv_meal);
        }
    }
}
