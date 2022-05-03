package hcmute.spkt.group20.foody_20.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.adapter.MealAdapter;
import hcmute.spkt.group20.foody_20.model.Meal;

public class MealFragment extends Fragment {
    List<Meal> meals;
    MealAdapter adapter;
    RecyclerView rv_2_items;

    public MealFragment(List<Meal> meals) {
        this.meals = meals;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meals, container, false);
        adapter = new MealAdapter(getActivity(), meals);
        rv_2_items = view.findViewById(R.id.rv_2_items);
        rv_2_items.setAdapter(adapter);
        rv_2_items.setLayoutManager(new GridLayoutManager(getContext(), 2));
        return view;
    }
}

