package hcmute.spkt.group20.foody_20.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.Support;
import hcmute.spkt.group20.foody_20.adapter.NotificationAdapter;

public class NotificationFragment extends Fragment {
    Context context;
    RecyclerView rv_notification;
    NotificationAdapter adapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = null;
        if (FirebaseAuth.getInstance().getCurrentUser().isAnonymous()) {
            v = inflater.inflate(R.layout.none_login, container, false);
        } else {
            v = inflater.inflate(R.layout.fragment_notification, container, false);

            rv_notification = v.findViewById(R.id.rv_notification);

            adapter = new NotificationAdapter(getContext(), Support.getNotifications());

            rv_notification.setLayoutManager(new LinearLayoutManager(getContext()));

            rv_notification.setAdapter(adapter);
        }

        return v;
    }
}