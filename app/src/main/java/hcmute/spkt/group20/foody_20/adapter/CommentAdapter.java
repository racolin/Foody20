package hcmute.spkt.group20.foody_20.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.Support;
import hcmute.spkt.group20.foody_20.dao.UserDao;
import hcmute.spkt.group20.foody_20.model.Comment;
import hcmute.spkt.group20.foody_20.model.User;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder>{

    List<Comment> comments;
    Context context;

    public CommentAdapter(Context context, List<Comment> comments) {
        this.comments = comments;
        this.context = context;
    }

    @NonNull
    @Override
    public CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comment_item, parent, false);
        return new CommentHolder(view);
    }

    public void update(List<Comment> comments) {
        this.comments = comments;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull CommentHolder holder, int position) {
        User user = UserDao.getUserById(context, comments.get(position).getUser_id());
        holder.iv_avatar.setImageResource(user.getImage());
        holder.tv_time.setText(Support.toDateString(comments.get(position).getTime_created(), "HH:mm dd/MM/yyyy"));
        holder.tv_comment_content.setText(comments.get(position).getContent());
        holder.rb_rating.setRating(comments.get(position).getRate());
        holder.tv_name.setText(user.getFull_name());
        holder.tv_feel.setText(Support.getTypeRate(comments.get(position).getRate()));
    }

    @Override
    public int getItemCount() {
        return comments == null ? 0 :comments.size();
    }

    public class CommentHolder extends RecyclerView.ViewHolder {
        ImageView iv_avatar;
        TextView tv_time, tv_comment_content, tv_name, tv_feel;
        RatingBar rb_rating;
        public CommentHolder(@NonNull View itemView) {
            super(itemView);
            tv_time = itemView.findViewById(R.id.tv_time);
            iv_avatar = itemView.findViewById(R.id.iv_avatar);
            rb_rating = itemView.findViewById(R.id.rb_rating);
            tv_comment_content = itemView.findViewById(R.id.tv_comment_content);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_feel = itemView.findViewById(R.id.tv_feel);
        }
    }
}

