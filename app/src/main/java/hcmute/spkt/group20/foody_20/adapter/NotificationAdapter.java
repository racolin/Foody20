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
import hcmute.spkt.group20.foody_20.model.Notification;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationHolder> {

    Context context;
    LayoutInflater inflater;
    List<Notification> notifications;

    public NotificationAdapter(Context context , List<Notification> notifications) {
        this.notifications = notifications;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NotificationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.notification_item_1, parent, false);
        return new NotificationHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationHolder holder, int position) {
        holder.tv_time.setText(notifications.get(position).getTime());
        holder.tv_title.setText(notifications.get(position).getTitle());
        holder.tv_description.setText(notifications.get(position).getDescription());
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
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_title.setOnClickListener((View view) -> {
                Toast.makeText(context, "Xử lý sự kiện", Toast.LENGTH_SHORT).show();
            });
            tv_description = itemView.findViewById(R.id.tv_description);
        }
    }
}
