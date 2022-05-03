package hcmute.spkt.group20.foody_20.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
import hcmute.spkt.group20.foody_20.adapter.OrderAllAdapter;
import hcmute.spkt.group20.foody_20.adapter.OrderCancelAdapter;
import hcmute.spkt.group20.foody_20.adapter.OrderDeliveryAdapter;
import hcmute.spkt.group20.foody_20.adapter.OrderWaitAdapter;
import hcmute.spkt.group20.foody_20.model.Order;

public class OrderFragment extends Fragment {
    Context context;
    RecyclerView rv_orders;
    List<Order> allOrder;
    RadioButton rd_all, rd_wait, rd_delivered,
            rd_delivering, rd_you_cancel, rd_shop_cancel;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        this.allOrder = Support.createAllOrders();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_order, container, false);
        mapping(v);
        rv_orders = v.findViewById(R.id.rv_orders);
        rv_orders.setAdapter(new OrderAllAdapter(getContext(), allOrder));
        rv_orders.setLayoutManager(new LinearLayoutManager(getContext()));
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
                rv_orders.setAdapter(new OrderAllAdapter(getContext(), allOrder));
                rd_all.setChecked(true);
            }
        });
        rd_wait.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                clearCheck();
                rv_orders.setAdapter(new OrderWaitAdapter(getContext(), filterWaitOrders(allOrder)));
                rd_wait.setChecked(true);
            }
        });
        rd_delivered.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                clearCheck();
                rv_orders.setAdapter(new OrderDeliveryAdapter(getContext(), filterDeliveringOrders(allOrder)));
                rd_delivered.setChecked(true);
            }
        });
        rd_delivering.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                clearCheck();
                rv_orders.setAdapter(new OrderDeliveryAdapter(getContext(), filterDeliveredOrders(allOrder)));
                rd_delivering.setChecked(true);
            }
        });
        rd_you_cancel.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                clearCheck();
                rv_orders.setAdapter(new OrderCancelAdapter(getContext(), filterYouCancelOrders(allOrder)));
                rd_you_cancel.setChecked(true);
            }
        });
        rd_shop_cancel.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                clearCheck();
                rv_orders.setAdapter(new OrderCancelAdapter(getContext(), filterShopCancelOrders(allOrder)));
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
            if (order.getStatus().equals("Đang đợi")) {
                wait.add(new Order(order));
            }
        }
        Log.d("RR", "" + wait.size());
        return wait;
    }

    public List<Order> filterDeliveredOrders(List<Order> orders) {
        List<Order> wait = new ArrayList<>();
        for (Order order : orders) {
            if (order.getStatus().equals("Đã giao")) {
                wait.add(new Order(order));
            }
        }
        return wait;
    }

    public List<Order> filterDeliveringOrders(List<Order> orders) {
        List<Order> wait = new ArrayList<>();
        for (Order order : orders) {
            if (order.getStatus().equals("Đang giao")) {
                wait.add(new Order(order));
            }
        }
        return wait;
    }

    public List<Order> filterYouCancelOrders(List<Order> orders) {
        List<Order> wait = new ArrayList<>();
        for (Order order : orders) {
            if (order.getStatus().equals("Bạn hủy")) {
                wait.add(new Order(order));
            }
        }
        return wait;
    }

    public List<Order> filterShopCancelOrders(List<Order> orders) {
        List<Order> wait = new ArrayList<>();
        for (Order order : orders) {
            if (order.getStatus().equals("Shop hủy")) {
                wait.add(new Order(order));
            }
        }
        return wait;
    }
}
