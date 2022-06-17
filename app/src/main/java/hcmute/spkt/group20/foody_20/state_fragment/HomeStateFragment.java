package hcmute.spkt.group20.foody_20.state_fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

import hcmute.spkt.group20.foody_20.Support;
import hcmute.spkt.group20.foody_20.fragment.MealFragment;
import hcmute.spkt.group20.foody_20.model.Meal;

public class HomeStateFragment extends FragmentStateAdapter {
    List<Meal> near, outstanding;
    MealFragment nearFragment, outstandingFragment;
    public HomeStateFragment(@NonNull FragmentActivity fragmentActivity, List<Meal> near, List<Meal> outstanding) {
        super(fragmentActivity);
        this.near = near;
        this.outstanding = outstanding;
        nearFragment = new MealFragment(near);
        outstandingFragment = new MealFragment(outstanding);
    }

    public void search() {

    }

    public void setNear(List<Meal> near) {
        this.near = near;
        nearFragment.updateData(near);
    }

    public void setOutstanding(List<Meal> outstanding) {
        this.outstanding = outstanding;
        outstandingFragment.updateData(outstanding);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return outstandingFragment;
            case 1:
                return nearFragment;
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}