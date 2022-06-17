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


import java.util.ArrayList;
import java.util.List;

import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.Support;
import hcmute.spkt.group20.foody_20.adapter.NotificationAdapter;
import hcmute.spkt.group20.foody_20.dao.NotificationDao;
import hcmute.spkt.group20.foody_20.model.Notification;

public class NotificationFragment extends Fragment {
    Context context;
    RecyclerView rv_notification;
    NotificationAdapter adapter = null;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onStart() {
        super.onStart();
        SharedPreferences preferences = getContext().getSharedPreferences("login", Context.MODE_PRIVATE);

        int user_id = preferences.getInt("user_id", -1);

        if (user_id != -1 && adapter != null) {
            adapter.update(NotificationDao.getNotificationsByUserId(context, user_id));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = null;

        SharedPreferences preferences = getContext().getSharedPreferences("login", Context.MODE_PRIVATE);

        int user_id = preferences.getInt("user_id", -1);

        if (user_id == -1) {
            v = inflater.inflate(R.layout.none_login, container, false);

        } else {
            v = inflater.inflate(R.layout.fragment_notification, container, false);
            adapter = new NotificationAdapter(getContext(), NotificationDao.getNotificationsByUserId(context, user_id));

            rv_notification = v.findViewById(R.id.rv_notification);

            rv_notification.setLayoutManager(new LinearLayoutManager(getContext()));

            rv_notification.setAdapter(adapter);
        }

        return v;
    }
}