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
import hcmute.spkt.group20.foody_20.model.OrderItem;

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.OrderAllItemHolder> {

    Context context;
    LayoutInflater inflater;
    List<OrderItem> items;

    public OrderItemAdapter(Context context, List<OrderItem> items) {
        this.items = items;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public OrderAllItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.meal_item_in_order_1, parent, false);
        return new OrderAllItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAllItemHolder holder, int position) {
        holder.tv_title.setText(items.get(position).getMeal().getName());
        holder.tv_amount.setText(String.valueOf(items.get(position).getAmount()));
        holder.tv_price.setText(items.get(position).getPriceCurrency());
        holder.iv_meal.setImageResource(items.get(position).getMeal().getImage());
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
            tv_title = itemView.findViewById(R.id.tv_title);
            iv_meal = itemView.findViewById(R.id.iv_meal);
        }
    }
}
