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
import hcmute.spkt.group20.foody_20.model.Order;

public class OrderDeliveryAdapter extends RecyclerView.Adapter<OrderDeliveryAdapter.DeliveredHolder> {

    private List<Order> orders;
    private Context context;
    private LayoutInflater inflater;

    public OrderDeliveryAdapter(Context context, List<Order> orders) {
        this.context = context;
        this.orders = orders;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public OrderDeliveryAdapter.DeliveredHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OrderDeliveryAdapter.DeliveredHolder(inflater.inflate(R.layout.meal_item_delivery_1, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderDeliveryAdapter.DeliveredHolder holder, int position) {
        holder.iv_meal.setImageResource(orders.get(position).getImage());
        holder.tv_title.setText(orders.get(position).getTitle());
        holder.tv_price.setText(orders.get(position).getPrice());
        holder.tv_amount.setText(orders.get(position).getAmount());
        holder.tv_time_start.setText(orders.get(position).getTime_start());
        holder.tv_time_end.setText(orders.get(position).getTime_end());
        holder.tv_status.setText(orders.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    protected class DeliveredHolder extends RecyclerView.ViewHolder {
        ImageView iv_meal;
        TextView tv_title, tv_price, tv_amount,
                tv_time_start, tv_time_end, tv_status;

        public DeliveredHolder(@NonNull View itemView) {
            super(itemView);
            iv_meal = itemView.findViewById(R.id.iv_meal);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_amount = itemView.findViewById(R.id.tv_amount);
            tv_time_start = itemView.findViewById(R.id.tv_time_start);
            tv_time_end = itemView.findViewById(R.id.tv_time_end);
            tv_status = itemView.findViewById(R.id.tv_status);
        }
    }
}
