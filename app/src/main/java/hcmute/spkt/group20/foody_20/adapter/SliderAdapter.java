package hcmute.spkt.group20.foody_20.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.model.Slider;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderHolder> {

    private List<Slider> sliders;

    public SliderAdapter(List<Slider> sliders) {
        this.sliders = sliders;
    }

    public void setSliders(List<Slider> sliders) {
        this.sliders = sliders;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SliderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item, parent, false);
        return new SliderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderHolder holder, int position) {
        byte[] bytes = sliders.get(position).getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        holder.iv_slider.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return sliders.size();
    }

    public class SliderHolder extends RecyclerView.ViewHolder {
        ImageView iv_slider;
        public SliderHolder(@NonNull View itemView) {
            super(itemView);
            iv_slider = itemView.findViewById(R.id.iv_slider);
        }
    }
}
