package hcmute.spkt.group20.foody_20.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.Support;
import hcmute.spkt.group20.foody_20.adapter.SliderAdapter;
import hcmute.spkt.group20.foody_20.state_fragment.HomeStateFragment;

public class HomeFragment extends Fragment {

    Context context;
    ViewPager2 vp2_home;
    TabLayout tl_tab;
    ViewPager2 vp2_slider;
    Handler handler;
    SliderAdapter adapter;
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
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        vp2_slider = view.findViewById(R.id.vp2_slider);
        adapter = new SliderAdapter(Support.createSliders());
        vp2_slider.setAdapter(adapter);
        Handler handler = new Handler();
        vp2_slider.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 4000);
            }
        });

        vp2_home = view.findViewById(R.id.vp2_home);
        vp2_home.setAdapter(new HomeStateFragment(getActivity()));
        tl_tab = view.findViewById(R.id.tl_tab);

        new TabLayoutMediator(tl_tab, vp2_home, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Nổi bật");
                        break;
                    case 1:
                        tab.setText("Gần tôi");
                        break;
                }
            }
        }).attach();

        List<String> provinces = Support.createProvince();
        Spinner sp_provinces = view.findViewById(R.id.sp_provinces);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.province_selected, R.id.tv_province, provinces);
        sp_provinces.setAdapter(adapter);
        adapter.setDropDownViewResource(R.layout.province_dropdown);

        return view;
    }
}
