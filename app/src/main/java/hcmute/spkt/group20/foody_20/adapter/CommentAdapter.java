package hcmute.spkt.group20.foody_20.adapter;

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
import hcmute.spkt.group20.foody_20.model.Comment;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder>{

    List<Comment> comments;

    public CommentAdapter(List<Comment> comments) {
        this.comments = comments;
    }

    @NonNull
    @Override
    public CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comment_item, parent, false);
        return new CommentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentHolder holder, int position) {
        holder.iv_avatar.setImageResource(comments.get(position).getImage());
        holder.tv_time.setText(comments.get(position).getDate());
        holder.tv_comment_content.setText(comments.get(position).getContent());
        holder.rb_rating.setRating(comments.get(position).getRating());
        holder.tv_name.setText(comments.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class CommentHolder extends RecyclerView.ViewHolder {
        ImageView iv_avatar;
        TextView tv_time, tv_comment_content, tv_name;
        RatingBar rb_rating;
        public CommentHolder(@NonNull View itemView) {
            super(itemView);
            tv_time = itemView.findViewById(R.id.tv_time);
            iv_avatar = itemView.findViewById(R.id.iv_avatar);
            rb_rating = itemView.findViewById(R.id.rb_rating);
            tv_comment_content = itemView.findViewById(R.id.tv_comment_content);
            tv_name = itemView.findViewById(R.id.tv_name);
        }
    }
}

