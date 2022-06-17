package hcmute.spkt.group20.foody_20.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;

import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.Support;
import hcmute.spkt.group20.foody_20.adapter.CartAdapter;
import hcmute.spkt.group20.foody_20.dao.CartDao;

public class CartFragment extends Fragment {
    RecyclerView rv_cart;
    CartAdapter adapter = null;
    Context context;
    int user_id;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onStart() {
        super.onStart();
        SharedPreferences preferences = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        user_id = preferences.getInt("user_id", -1);
        if (user_id != -1 && adapter != null) {
            adapter.update(CartDao.getCartsByUserID(context, user_id));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = null;
        SharedPreferences preferences = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        user_id = preferences.getInt("user_id", -1);
        if (user_id == -1) {
            v = inflater.inflate(R.layout.none_login, container, false);
        } else {
            v = inflater.inflate(R.layout.fragment_cart, container, false);
            rv_cart = v.findViewById(R.id.rv_cart);

            rv_cart.setLayoutManager(new LinearLayoutManager(getContext()));

            adapter = new CartAdapter(getContext(), CartDao.getCartsByUserID(context, user_id));

            rv_cart.setAdapter(adapter);
        }

        return v;
    }
}

