package hcmute.spkt.group20.foody_20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;


import hcmute.spkt.group20.foody_20.dao.UserDao;
import hcmute.spkt.group20.foody_20.fragment.CartFragment;
import hcmute.spkt.group20.foody_20.fragment.HomeFragment;
import hcmute.spkt.group20.foody_20.fragment.NotificationFragment;
import hcmute.spkt.group20.foody_20.fragment.OrderFragment;
import hcmute.spkt.group20.foody_20.fragment.SavedFragment;
import hcmute.spkt.group20.foody_20.model.User;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView nb_navigation;
    DrawerLayout dl_user;
    NavigationView nv_user;
    MovableFloatingActionButton fab_user;
    ImageView iv_avatar;
    TextView tv_phone, tv_facebook, tv_gmail, tv_name;
    public static final String TAG = HomeActivity.class.getSimpleName();
    User user;
    int user_id;
    View header;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        preferences = getSharedPreferences("login", MODE_PRIVATE);
        user_id = preferences.getInt("user_id", -1);
        user = UserDao.getUserById(this, user_id);

        initUI();

        initListener();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fl_content, new HomeFragment());
        transaction.addToBackStack(HomeFragment.class.getSimpleName());
        transaction.commit();

        if (preferences.getBoolean("just_login", false)) {
            Intent intent = new Intent(this, UserInfoActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        load();
    }

    public void load() {
        preferences = getSharedPreferences("login", MODE_PRIVATE);
        user_id = preferences.getInt("user_id", -1);
        user = UserDao.getUserById(this, user_id);

        if (user_id != -1) {
            loginUpdateUI();
            tv_name.setText(user.getFull_name());
            tv_gmail.setText(user.getGmail());
            tv_facebook.setText(user.getFacebook());
            tv_phone.setText(user.getPhone());
            iv_avatar.setImageResource(user.getImage());
            header.setVisibility(View.VISIBLE);
        } else {
            logoutUpdateUI();
            header.setVisibility(View.GONE);
        }
    }

    private void initUI() {

        nb_navigation = findViewById(R.id.nb_navigation);

        dl_user = findViewById(R.id.dl_user);

        nv_user = findViewById(R.id.nv_user);

        fab_user = findViewById(R.id.fab_user);

        header = nv_user.getHeaderView(0);

        tv_name = header.findViewById(R.id.tv_name);
        tv_gmail = header.findViewById(R.id.tv_gmail);
        tv_facebook = header.findViewById(R.id.tv_facebook);
        tv_phone = header.findViewById(R.id.tv_phone);
        iv_avatar = header.findViewById(R.id.iv_avatar);

        load();
    }

    private void initListener() {

        categoriesEvent();
        navigationEvent();

        fab_user.setOnClickListener(v -> {
            if (!dl_user.isOpen()) {
                dl_user.openDrawer(GravityCompat.START);
            }
        });
    }

    private void logoutUpdateUI() {
        nv_user.getMenu().getItem(0).setEnabled(true);
        nv_user.getMenu().getItem(4).setEnabled(false);
    }

    private void loginUpdateUI() {
        nv_user.getMenu().getItem(0).setEnabled(false);
        nv_user.getMenu().getItem(4).setEnabled(true);
    }

    private void login() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void logout() {
        getSharedPreferences("login", MODE_PRIVATE);
        preferences.edit().clear().apply();
        Toast.makeText(this, "Bạn vừa đăng xuất khỏi ứng dụng!", Toast.LENGTH_SHORT).show();
        load();
    }

    public void categoriesEvent() {
        nb_navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.action_home:
                        transaction.replace(R.id.fl_content, new HomeFragment());
                        break;
                    case R.id.action_notification:
                        transaction.replace(R.id.fl_content, new NotificationFragment());
                        break;
                    case R.id.action_saved:
                        transaction.replace(R.id.fl_content, new SavedFragment());
                        break;
                    case R.id.action_cart:
                        transaction.replace(R.id.fl_content, new CartFragment());
                        break;
                    case R.id.action_order:
                        transaction.replace(R.id.fl_content, new OrderFragment());
                        break;
                }
                transaction.commit();
                return true;
            }
        });
    }

    public void navigationEvent() {
        nv_user.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nv_log_out:
                        logout();
                        break;
                    case R.id.nv_log_in:
                        login();
                        break;
                    case R.id.nv_info:
                        if (true) { // login
                            Intent i2 = new Intent(HomeActivity.this, UserInfoActivity.class);
                            startActivity(i2);
                        } else {
                            Intent i2 = new Intent(HomeActivity.this, LoginActivity.class);
                            startActivity(i2);
                            Toast.makeText(getApplicationContext(), R.string.login_need, Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.nv_share:
                        if (true) { // login
//                            Thực hiện share
                        } else {
//                            Gợi ý phải vào facebook để share
//                            Nếu đã đăng nhập nhưng không có facebook thì cho trang chủ để link
//                            Nếu chưa đăng nhập thì cho về trang login
                            Toast.makeText(getApplicationContext(),
                                    R.string.facebook_login_need,
                                    Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.nv_rule:
                        Intent i3 = new Intent(HomeActivity.this, RuleActivity.class);
                        startActivity(i3);
                        break;
                    case R.id.nv_home:
                        nb_navigation.setSelectedItemId(R.id.action_home);
                        break;
                    case R.id.nv_notification:
                        nb_navigation.setSelectedItemId(R.id.action_notification);
                        break;
                    case R.id.nv_saved:
                        nb_navigation.setSelectedItemId(R.id.action_saved);
                        break;
                    case R.id.nv_cart:
                        nb_navigation.setSelectedItemId(R.id.action_cart);
                        break;
                    case R.id.nv_order:
                        nb_navigation.setSelectedItemId(R.id.action_order);
                        break;
                }
                dl_user.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (dl_user.isOpen()) {
            dl_user.closeDrawer(GravityCompat.START);
            return;
        }
        FragmentManager manager = getSupportFragmentManager();
        if (manager.findFragmentById(R.id.fl_content) instanceof HomeFragment) {
            finish();
        } else {
//            manager.popBackStack();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.fl_content, new HomeFragment());
            transaction.commit();
            nb_navigation.setSelectedItemId(R.id.action_home);
            return;
        }
        super.onBackPressed();
    }
}