package hcmute.spkt.group20.foody_20.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.Support;
import hcmute.spkt.group20.foody_20.model.Notification;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationHolder> {

    Context context = null;
    List<Notification> notifications;

    public NotificationAdapter(Context context , List<Notification> notifications) {
        this.notifications = notifications;
        this.context = context;
    }

    @NonNull
    @Override
    public NotificationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.notification_item_1, parent, false);
        return new NotificationHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationHolder holder, int position) {
        holder.tv_time.setText(Support.toDateString(
                notifications.get(position).
                        getTime_created(), "HH:mm dd/MM/yyyy"));
        holder.tv_title.setText(notifications.get(position).getTitle());
        holder.tv_description.setText(notifications.get(position).getDescription());
    }

    public void update(List<Notification> notifications) {
        if (context != null) {
            this.notifications = notifications;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    protected class NotificationHolder extends RecyclerView.ViewHolder {

        TextView tv_title, tv_description, tv_time;

        public NotificationHolder(@NonNull View itemView) {
            super(itemView);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_title = itemView.findViewById(R.id.tv_name);
            tv_description = itemView.findViewById(R.id.tv_description);
        }
    }
}
