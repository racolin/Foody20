package hcmute.spkt.group20.foody_20.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.state_fragment.SavedStateFragment;

public class SavedFragment extends Fragment {
    Context context;
    ViewPager2 vp2_home;
    TabLayout tl_tab;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved, container, false);
        vp2_home = view.findViewById(R.id.vp2_home);
        vp2_home.setAdapter(new SavedStateFragment(getActivity()));
        tl_tab = view.findViewById(R.id.tl_tab);

        new TabLayoutMediator(tl_tab, vp2_home, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Món ăn");
                        break;
                    case 1:
                        tab.setText("Cửa hàng");
                        break;
                }
            }
        }).attach();

        return view;
    }
}