package hcmute.spkt.group20.foody_20.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import hcmute.spkt.group20.foody_20.LoginActivity;
import hcmute.spkt.group20.foody_20.R;

public class NeedLoginFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.none_login, container, false);
        ImageView iv_login = view.findViewById(R.id.iv_login);
        TextView tv_login = view.findViewById(R.id.tv_login);
        iv_login.setOnClickListener(v -> {
            toLogin();
        });
        tv_login.setOnClickListener(v -> {
            toLogin();
        });
        return view;
    }
    private void toLogin() {
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);
    }
}
