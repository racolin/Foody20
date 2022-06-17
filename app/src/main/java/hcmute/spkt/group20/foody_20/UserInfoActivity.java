package hcmute.spkt.group20.foody_20;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import hcmute.spkt.group20.foody_20.dao.UserDao;
import hcmute.spkt.group20.foody_20.fragment.HomeFragment;
import hcmute.spkt.group20.foody_20.model.User;

public class UserInfoActivity extends AppCompatActivity implements OnMapReadyCallback {

    public static final String TAG = "UserInfoActivity";
    Spinner sp_genders;
    ImageButton ib_dob;
    EditText et_name, et_phone, et_gmail, et_facebook, et_address;
    TextView tv_dob;
    Geocoder search;
    Address address;
    SupportMapFragment mapFragment;
    Handler handler;
    ImageView iv_phone, iv_facebook, iv_google, iv_avatar;
    User user;
    Button btn_update;

    ArrayAdapter<String> gendersAdapter;
    List<String> genders;
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
        int user_id = preferences.getInt("user_id", -1);
        if (user_id != -1) {
            setContentView(R.layout.activity_user_info);
            user = UserDao.getUserById(this, user_id);
            mapping();

        } else {
            setContentView(R.layout.none_login);
        }
    }


    public void mapping() {
        iv_avatar = findViewById(R.id.iv_avatar);
        iv_avatar.setImageResource(user.getImage());
        iv_phone = findViewById(R.id.iv_phone);
        iv_facebook = findViewById(R.id.iv_facebook);
        iv_google = findViewById(R.id.iv_google);
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
        tv_dob.setText(Support.toDateString(user.getDob(), "dd/MM/yyyy"));

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

        et_address = findViewById(R.id.et_address);
        et_address.setText(user.getAddress());
        et_facebook = findViewById(R.id.et_facebook);
        et_facebook.setText(user.getFacebook());
        et_gmail = findViewById(R.id.et_gmail);
        et_gmail.setText(user.getGmail());
        et_name = findViewById(R.id.et_name);
        et_name.setText(user.getFull_name());
        et_phone = findViewById(R.id.et_phone);
        et_phone.setText(user.getPhone());
        btn_update = findViewById(R.id.btn_update);
        btn_update.setOnClickListener(v -> {
            user.setPhone(et_phone.getText().toString());
            user.setFacebook(et_facebook.getText().toString());
            user.setGmail(et_gmail.getText().toString());
            user.setDob(Support.toDate(tv_dob.getText().toString(), "dd/MM/yyyy"));
            user.setAddress(et_address.getText().toString());
            user.setGender(sp_genders.getSelectedItemPosition());
            user.setFull_name(et_name.getText().toString());
            UserDao.update(this, user);
            Toast.makeText(this, "Cập nhật thành công!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    public void createGenders() {
        genders = Arrays.asList(getResources().getStringArray(R.array.genders));
        gendersAdapter = new ArrayAdapter<String>(this, R.layout.gender_layout, genders);
        sp_genders.setAdapter(gendersAdapter);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng sydney = new LatLng(-33.852, 151.211);
        googleMap.addMarker(new MarkerOptions()
                .position(sydney)
                .title("Marker in Sydney"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}