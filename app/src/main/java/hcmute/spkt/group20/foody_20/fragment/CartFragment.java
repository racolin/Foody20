package hcmute.spkt.group20.foody_20.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.Support;
import hcmute.spkt.group20.foody_20.adapter.CartAdapter;

public class CartFragment extends Fragment {
    Context context;
    RecyclerView rv_cart;
    CartAdapter adapter;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cart, container, false);
        rv_cart = v.findViewById(R.id.rv_cart);

        rv_cart.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new CartAdapter(context, Support.createCarts());

        rv_cart.setAdapter(adapter);

        return v;
    }
}

