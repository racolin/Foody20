package hcmute.spkt.group20.foody_20.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.model.Order;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderAllHolder> {

    Context context;
    LayoutInflater inflater;
    List<Order> orders;

    public OrderAdapter(Context context, List<Order> orders) {
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
        if (orders.get(position).getStatus().equals(context.getString(R.string.order_wait))) {
            holder.ll_cause.setVisibility(View.GONE);
            holder.ll_end.setVisibility(View.VISIBLE);
            holder.ll_total.setVisibility(View.VISIBLE);
            holder.ll_cancel.setVisibility(View.VISIBLE);
        }
        if (orders.get(position).getStatus().equals(context.getString(R.string.order_delivering))) {
            holder.ll_cause.setVisibility(View.GONE);
            holder.ll_cancel.setVisibility(View.GONE);
            holder.ll_end.setVisibility(View.VISIBLE);
            holder.ll_total.setVisibility(View.VISIBLE);
        }
        if (orders.get(position).getStatus().equals(context.getString(R.string.order_delivered))) {
            holder.ll_cause.setVisibility(View.GONE);
            holder.ll_cancel.setVisibility(View.GONE);
            holder.ll_end.setVisibility(View.VISIBLE);
            holder.ll_total.setVisibility(View.VISIBLE);
        }
        if (orders.get(position).getStatus().equals(context.getString(R.string.order_you_cancel))) {
            holder.ll_end.setVisibility(View.GONE);
            holder.ll_total.setVisibility(View.GONE);
            holder.ll_cancel.setVisibility(View.GONE);
            holder.ll_cause.setVisibility(View.VISIBLE);
        }
        if (orders.get(position).getStatus().equals(context.getString(R.string.order_shop_cancel))) {
            holder.ll_end.setVisibility(View.GONE);
            holder.ll_total.setVisibility(View.GONE);
            holder.ll_cancel.setVisibility(View.GONE);
            holder.ll_cause.setVisibility(View.VISIBLE);
        }

        holder.tv_date_end.setText(orders.get(position).getTime_end());
        holder.tv_status.setText(orders.get(position).getStatus());
        holder.tv_shop.setText(orders.get(position).getTitle());
        holder.tv_id.setText(orders.get(position).getId());
        holder.tv_price.setText(orders.get(position).getPriceCurrency());
        holder.tv_cause.setText(orders.get(position).getCause());

        holder.rv_meals.setAdapter(new OrderItemAdapter(context, orders.get(position).getItems()));
        holder.rv_meals.setLayoutManager(new LinearLayoutManager(context));
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    protected class OrderAllHolder extends RecyclerView.ViewHolder {
        LinearLayout ll_total, ll_end, ll_cause, ll_cancel;
        TextView tv_price, tv_date_end, tv_status, tv_shop, tv_id, tv_cause;
        RecyclerView rv_meals;
        public OrderAllHolder(@NonNull View itemView) {
            super(itemView);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_date_end = itemView.findViewById(R.id.tv_time_end);
            tv_status = itemView.findViewById(R.id.tv_status);
            tv_shop = itemView.findViewById(R.id.tv_shop);
            tv_cause = itemView.findViewById(R.id.tv_cause);
            tv_id = itemView.findViewById(R.id.tv_id);

            rv_meals = itemView.findViewById(R.id.rv_meals);
            ll_cause = itemView.findViewById(R.id.ll_cause);
            ll_end = itemView.findViewById(R.id.ll_end);
            ll_total = itemView.findViewById(R.id.ll_total);
            ll_cancel = itemView.findViewById(R.id.ll_cancel);
        }
    }
}
