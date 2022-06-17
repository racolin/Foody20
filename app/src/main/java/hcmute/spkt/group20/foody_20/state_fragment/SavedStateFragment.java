package hcmute.spkt.group20.foody_20.state_fragment;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import hcmute.spkt.group20.foody_20.dao.SavedMealDAO;
import hcmute.spkt.group20.foody_20.dao.SavedShopDAO;
import hcmute.spkt.group20.foody_20.fragment.MealFragment;
import hcmute.spkt.group20.foody_20.fragment.ShopFragment;

public class SavedStateFragment extends FragmentStateAdapter {

    private Context context;

    public SavedStateFragment(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.context = fragmentActivity;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        SharedPreferences preferences = context.getSharedPreferences("login", Context.MODE_PRIVATE);
        int user_id = preferences.getInt("user_id", -1);
        switch (position) {
            case 0:
                return new MealFragment(SavedMealDAO.getSavedMealsByUserId(context, user_id));
            case 1:
                return new ShopFragment(SavedShopDAO.getSavedShopsByUserId(context, user_id));
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
