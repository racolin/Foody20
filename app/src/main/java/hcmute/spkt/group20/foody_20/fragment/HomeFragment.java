package hcmute.spkt.group20.foody_20.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.Support;
import hcmute.spkt.group20.foody_20.adapter.SliderAdapter;
import hcmute.spkt.group20.foody_20.dao.MealDao;
import hcmute.spkt.group20.foody_20.model.Meal;
import hcmute.spkt.group20.foody_20.model.Slider;
import hcmute.spkt.group20.foody_20.state_fragment.HomeStateFragment;

public class HomeFragment extends Fragment {

    List<Meal> near, outstanding;
    ImageView iv_search;
    ViewPager2 vp2_home;
    TabLayout tl_tab;
    ViewPager2 vp2_slider;
    SliderAdapter adapterSlider;
    HomeStateFragment homeStateFragment;
    EditText et_search;

    public HomeFragment() {

    }

    public HomeFragment(List<Slider> sliders) {
        this.adapterSlider = new SliderAdapter(sliders);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (vp2_slider.getCurrentItem() == vp2_slider.getAdapter().getItemCount() - 1) {
                vp2_slider.setCurrentItem(0);
            } else {
                vp2_slider.setCurrentItem(vp2_slider.getCurrentItem() + 1);
            }
        }
    };

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        near = new ArrayList<>();
        outstanding = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        et_search = view.findViewById(R.id.et_search);
        vp2_slider = view.findViewById(R.id.vp2_slider);
        List<Slider> sliders = new ArrayList<>();
        adapterSlider = new SliderAdapter(Support.createSliders());

        vp2_slider.setAdapter(adapterSlider);
        Handler handler = new Handler();
        vp2_slider.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 4000);
            }
        });

        near = MealDao.getAllMeals(getActivity());
        outstanding = MealDao.getAllMeals(getActivity());
        vp2_home = view.findViewById(R.id.vp2_home);
        homeStateFragment = new HomeStateFragment(getActivity(), near, outstanding);
        vp2_home.setAdapter(homeStateFragment);
        tl_tab = view.findViewById(R.id.tl_tab);

        iv_search = view.findViewById(R.id.iv_search);
        iv_search.setOnClickListener(v -> {
            near = MealDao.getMealsBySearch(getActivity(), et_search.getText().toString());
            outstanding = MealDao.getMealsBySearch(getActivity(), et_search.getText().toString());
            homeStateFragment.setNear(near);
            homeStateFragment.setOutstanding(outstanding);
//            Toast.makeText(getContext(), "Sự kiện tìm kiếm", Toast.LENGTH_SHORT).show();
        });

        new TabLayoutMediator(tl_tab, vp2_home, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText(R.string.outstanding);
                        break;
                    case 1:
                        tab.setText(R.string.near_me);
                        break;
                }
            }
        }).attach();

        List<String> provinces = Support.getProvinces();
        Spinner sp_provinces = view.findViewById(R.id.sp_provinces);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.province_selected, R.id.tv_province, provinces);
        sp_provinces.setAdapter(adapter);
        sp_provinces.setSelection(56);
        adapter.setDropDownViewResource(R.layout.province_dropdown);

        return view;
    }


}
