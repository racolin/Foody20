package hcmute.spkt.group20.foody_20.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.Support;
import hcmute.spkt.group20.foody_20.adapter.NotificationAdapter;
import hcmute.spkt.group20.foody_20.adapter.OrderAdapter;
import hcmute.spkt.group20.foody_20.dao.NotificationDao;
import hcmute.spkt.group20.foody_20.dao.OrderDao;
import hcmute.spkt.group20.foody_20.model.Order;

public class OrderFragment extends Fragment {
    Context context;
    RecyclerView rv_orders;
    List<Order> allOrder;
    RadioButton rd_all, rd_wait, rd_delivered,
            rd_delivering, rd_you_cancel, rd_shop_cancel;
    OrderAdapter adapter = null;
    int user_id;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        SharedPreferences preferences = getContext().getSharedPreferences("login", Context.MODE_PRIVATE);

        user_id = preferences.getInt("user_id", -1);

        if (user_id == -1) {
            this.allOrder = new ArrayList<>();
        } else {
            this.allOrder = OrderDao.getOrdersByUserId(context ,user_id);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        SharedPreferences preferences = getContext().getSharedPreferences("login", Context.MODE_PRIVATE);
        user_id = preferences.getInt("user_id", -1);
        if (user_id != -1 && adapter != null) {
            adapter.update(OrderDao.getOrdersByUserId(getContext(), user_id));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = null;
        SharedPreferences preferences = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        int user_id = preferences.getInt("user_id", -1);
        if (user_id == -1) {
            v = inflater.inflate(R.layout.none_login, container, false);
        } else {
            v = inflater.inflate(R.layout.fragment_order, container, false);
            mapping(v);
            rv_orders = v.findViewById(R.id.rv_orders);
            adapter = new OrderAdapter(getContext(), allOrder);
            rv_orders.setAdapter(adapter);
            rv_orders.setLayoutManager(new LinearLayoutManager(getContext()));
        }

        return v;
    }

    public void mapping(View v) {
        rd_all = v.findViewById(R.id.rd_all);
        rd_wait = v.findViewById(R.id.rd_wait);
        rd_delivered = v.findViewById(R.id.rd_delivered);
        rd_delivering = v.findViewById(R.id.rd_delivering);
        rd_you_cancel = v.findViewById(R.id.rd_you_cancel);
        rd_shop_cancel = v.findViewById(R.id.rd_shop_cancel);
        rd_all.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                clearCheck();
                rv_orders.setAdapter(new OrderAdapter(getContext(), allOrder));
                rd_all.setChecked(true);
            }
        });
        rd_wait.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                clearCheck();
                rv_orders.setAdapter(new OrderAdapter(getContext(), filterWaitOrders(allOrder)));
                rd_wait.setChecked(true);
            }
        });
        rd_delivered.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                clearCheck();
                rv_orders.setAdapter(new OrderAdapter(getContext(), filterDeliveredOrders(allOrder)));
                rd_delivered.setChecked(true);
            }
        });
        rd_delivering.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                clearCheck();
                rv_orders.setAdapter(new OrderAdapter(getContext(), filterDeliveringOrders(allOrder)));
                rd_delivering.setChecked(true);
            }
        });
        rd_you_cancel.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                clearCheck();
                rv_orders.setAdapter(new OrderAdapter(getContext(), filterYouCancelOrders(allOrder)));
                rd_you_cancel.setChecked(true);
            }
        });
        rd_shop_cancel.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                clearCheck();
                rv_orders.setAdapter(new OrderAdapter(getContext(), filterShopCancelOrders(allOrder)));
                rd_shop_cancel.setChecked(true);
            }
        });
    }

    public void clearCheck() {
        rd_all.setChecked(false);
        rd_wait.setChecked(false);
        rd_delivered.setChecked(false);
        rd_delivering.setChecked(false);
        rd_you_cancel.setChecked(false);
        rd_shop_cancel.setChecked(false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public List<Order> filterWaitOrders(List<Order> orders) {
        List<Order> wait = new ArrayList<>();
        for (Order order : orders) {
            if (order.getStatus().equals(getString(R.string.order_wait))) {
                wait.add(order);
            }
        }
        return wait;
    }

    public List<Order> filterDeliveredOrders(List<Order> orders) {
        List<Order> delivered = new ArrayList<>();
        for (Order order : orders) {
            if (order.getStatus().equals(getString(R.string.order_delivered))) {
                delivered.add(order);
            }
        }
        return delivered;
    }

    public List<Order> filterDeliveringOrders(List<Order> orders) {
        List<Order> delivering = new ArrayList<>();
        for (Order order : orders) {
            if (order.getStatus().equals(getString(R.string.order_delivering))) {
                delivering.add(order);
            }
        }
        return delivering;
    }

    public List<Order> filterYouCancelOrders(List<Order> orders) {
        List<Order> you_cancel = new ArrayList<>();
        for (Order order : orders) {
            if (order.getStatus().equals(getString(R.string.order_you_cancel))) {
                you_cancel.add(order);
            }
        }
        return you_cancel;
    }

    public List<Order> filterShopCancelOrders(List<Order> orders) {
        List<Order> shop_cancel = new ArrayList<>();
        for (Order order : orders) {
            if (order.getStatus().equals(getString(R.string.order_shop_cancel))) {
                shop_cancel.add(order);
            }
        }
        return shop_cancel;
    }
}
