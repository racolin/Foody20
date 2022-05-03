package hcmute.spkt.group20.foody_20.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.model.Order;

public class OrderAllAdapter extends RecyclerView.Adapter<OrderAllAdapter.OrderAllHolder> {

    Context context;
    LayoutInflater inflater;
    List<Order> orders;

    public OrderAllAdapter(Context context, List<Order> orders) {
        this.orders = orders;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public OrderAllHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.meal_item_order_1, parent, false);
        return new OrderAllHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAllHolder holder, int position) {
        holder.tv_amount.setText(orders.get(position).getAmount());
        holder.tv_price.setText(orders.get(position).getPrice());
        holder.tv_date_end.setText(orders.get(position).getTime_end());
        holder.tv_status.setText(orders.get(position).getStatus());
        holder.tv_title.setText(orders.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    protected class OrderAllHolder extends RecyclerView.ViewHolder {
        public TextView tv_price, tv_amount, tv_date_end, tv_status, tv_title;
        public OrderAllHolder(@NonNull View itemView) {
            super(itemView);
            tv_amount = itemView.findViewById(R.id.tv_amount);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_date_end = itemView.findViewById(R.id.tv_time_end);
            tv_status = itemView.findViewById(R.id.tv_status);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
