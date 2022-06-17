package hcmute.spkt.group20.foody_20.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.Support;
import hcmute.spkt.group20.foody_20.dao.OrderDao;
import hcmute.spkt.group20.foody_20.dao.OrderItemDao;
import hcmute.spkt.group20.foody_20.dao.ShopDao;
import hcmute.spkt.group20.foody_20.model.Order;
import hcmute.spkt.group20.foody_20.model.OrderItem;
import hcmute.spkt.group20.foody_20.model.Shop;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderAllHolder> {

    Context context = null;
    List<Order> orders;

    public OrderAdapter(Context context, List<Order> orders) {
        this.orders = orders;
        this.context = context;
    }

    public void update(List<Order> orders) {
        if (context != null) {
            this.orders = orders;
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public OrderAllHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.meal_item_order_1, parent, false);
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

        Shop shop = ShopDao.getShopById(context, orders.get(position).getShop_id());
        List<OrderItem> orderItems = OrderItemDao.getOrderItemsByOrderId(context, orders.get(position).getId());
        int price = 0;
        for (OrderItem orderItem : orderItems) {
            price += orderItem.getPrice() * orderItem.getAmount();
        }
        holder.tv_time_end.setText(Support.toDateString(orders.get(position).getTime_end(), "HH:mm dd/MM/yyyy"));
        holder.tv_time_start.setText(Support.toDateString(orders.get(position).getTime_start(), "HH:mm dd/MM/yyyy"));
        holder.tv_status.setText(orders.get(position).getStatus());
        holder.tv_shop_name.setText(shop.getName());
        holder.tv_id.setText(String.valueOf(orders.get(position).getId()));
        holder.tv_price.setText(Support.toCurrency(price));
        holder.tv_cause.setText(orders.get(position).getCause());
        final int p = position;
        holder.btn_cancel_order.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Nguyên nhân hủy đơn");
            View cause_title_layout = LayoutInflater.from(context).inflate(R.layout.diaglog_cause_title, null);
            builder.setCustomTitle(cause_title_layout);
            View cause_view_layout = LayoutInflater.from(context).inflate(R.layout.dialog_cause_view, null);
            EditText et_cause = cause_view_layout.findViewById(R.id.et_cause);
            builder.setView(cause_view_layout);
            builder.setPositiveButton("Gửi", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    orders.get(p).setStatus("Bạn hủy");
                    orders.get(p).setCause(et_cause.getText().toString());
                    OrderDao.update(context, orders.get(p));
                    notifyItemChanged(p);
                    Toast.makeText(context, "Hủy đơn thành công!", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        });

        holder.rv_meals.setAdapter(new OrderItemAdapter(context, orderItems));
        holder.rv_meals.setLayoutManager(new LinearLayoutManager(context));
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    protected class OrderAllHolder extends RecyclerView.ViewHolder {
        LinearLayout ll_total, ll_end, ll_cause, ll_cancel;
        TextView tv_price, tv_time_end, tv_status, tv_shop_name, tv_id, tv_cause, tv_time_start;
        Button btn_cancel_order;
        RecyclerView rv_meals;
        public OrderAllHolder(@NonNull View itemView) {
            super(itemView);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_time_end = itemView.findViewById(R.id.tv_time_end);
            tv_time_start = itemView.findViewById(R.id.tv_time_start);
            tv_status = itemView.findViewById(R.id.tv_status);
            tv_shop_name = itemView.findViewById(R.id.tv_shop_name);
            tv_cause = itemView.findViewById(R.id.tv_cause);
            tv_id = itemView.findViewById(R.id.tv_id);
            btn_cancel_order = itemView.findViewById(R.id.btn_cancel_order);

            rv_meals = itemView.findViewById(R.id.rv_meals);
            ll_cause = itemView.findViewById(R.id.ll_cause);
            ll_end = itemView.findViewById(R.id.ll_end);
            ll_total = itemView.findViewById(R.id.ll_total);
            ll_cancel = itemView.findViewById(R.id.ll_cancel);
        }
    }
}
