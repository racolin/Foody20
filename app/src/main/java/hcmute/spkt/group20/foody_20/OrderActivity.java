package hcmute.spkt.group20.foody_20;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.SupportMapFragment;

public class OrderActivity extends AppCompatActivity {

    SupportMapFragment mf_order;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        mapping();
    }

    public void mapping() {
        mf_order = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mf_order);


        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fm_map, mapFragment)
                .commit();
    }
}