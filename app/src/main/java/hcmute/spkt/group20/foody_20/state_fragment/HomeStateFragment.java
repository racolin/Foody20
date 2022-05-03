package hcmute.spkt.group20.foody_20.state_fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import hcmute.spkt.group20.foody_20.Support;
import hcmute.spkt.group20.foody_20.fragment.MealFragment;

public class HomeStateFragment extends FragmentStateAdapter {
    public HomeStateFragment(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new MealFragment(Support.createMeals1());
            case 1:
                return new MealFragment(Support.createMeals2());
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}