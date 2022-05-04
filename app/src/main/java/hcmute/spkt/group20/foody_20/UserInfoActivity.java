package hcmute.spkt.group20.foody_20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import hcmute.spkt.group20.foody_20.model.User;

public class UserInfoActivity extends AppCompatActivity implements OnMapReadyCallback {

    Spinner sp_genders;
    ImageButton ib_dob;
    TextView tv_dob, tv_phone, tv_gmail, tv_facebook;
    Geocoder search;
    Address address;
    SupportMapFragment mapFragment;
    Handler handler;
    ImageView iv_phone, iv_facebook, iv_google;

    ArrayAdapter<String> gendersAdapter;
    List<String> genders;
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        mapping();
        Log.d("rrr", getUser().toString());
//        handler = new Handler();
//        search = new Geocoder(this);
//        new Thread(() -> {
//            try {
//                Log.d("rrr", "1");
//                address = search.getFromLocationName(
//                        "Đại học Sư Phạm Kỹ Thuật TP.HCM", 1).get(0);
//                Log.d("rrr", "2");
//                handler.post(() -> {
//                    mapFragment.getMapAsync(this);
//                });
//            } catch (IOException e) {
//                e.printStackTrace();
//                Log.d("rrr", "4");
//            }
//        }).start();
    }

    public User getUser() {
        User user = new User();
        FirebaseUser u = FirebaseAuth.getInstance().getCurrentUser();
        for (UserInfo info : u.getProviderData()) {
            user.setFullname(u.getDisplayName());
            user.setUid(u.getUid());

            if (info.getProviderId().equals(getString(R.string.google))) {
                user.setGmail(info.getEmail());
            }
            if (info.getProviderId().equals(getString(R.string.facebook))) {
//                user.setFacebook(info.get);
            }
            if (info.getProviderId().equals(getString(R.string.phone))) {
                user.setPhone(info.getPhoneNumber());
            }
        }
        return user;
    }

    public void mapping() {
        iv_phone = findViewById(R.id.iv_phone);
        iv_facebook = findViewById(R.id.iv_facebook);
        iv_google = findViewById(R.id.iv_google);

        iv_phone.setOnClickListener(v -> {
            if (!Support.checkPhone()) {

            }
        });
        iv_facebook.setOnClickListener(v -> {
            if (!Support.checkFacebook()) {

            }
        });
        iv_google.setOnClickListener(v -> {
            if (!Support.checkGoogle()) {

            }
        });


        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fm_map);
        sp_genders = findViewById(R.id.sp_gender);
        createGenders();
        sp_genders.setSelection(genders.indexOf(getString(R.string.male)));

        Calendar date = new GregorianCalendar();

        try {
            date.setTime(format.parse(getResources().getString(R.string.date_default)));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        tv_dob = findViewById(R.id.tv_dob);

        DatePickerDialog picker = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.YEAR, i);
                        calendar.set(Calendar.MONTH, i1);
                        calendar.set(Calendar.DATE, i2);
                        tv_dob.setText(format.format(new Date(calendar.getTimeInMillis())));
                    }
                }, date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DATE));

        ib_dob = findViewById(R.id.ib_choose_dob);
        ib_dob.setOnClickListener(v -> {
            picker.show();
        });

        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fm_map, mapFragment)
                .commit();

    }

    public void createGenders() {
        genders = Arrays.asList(getResources().getStringArray(R.array.genders));
        gendersAdapter = new ArrayAdapter<String>(this, R.layout.gender_layout, genders);
        sp_genders.setAdapter(gendersAdapter);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng sydney = new LatLng(-33.852, 151.211);
//        Geocoder geocoder = Geocoder
        googleMap.addMarker(new MarkerOptions()
                .position(sydney)
                .title("Marker in Sydney"));
    }
}