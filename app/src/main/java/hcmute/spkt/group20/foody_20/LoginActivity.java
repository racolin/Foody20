package hcmute.spkt.group20.foody_20;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import hcmute.spkt.group20.foody_20.dao.UserDao;
import hcmute.spkt.group20.foody_20.model.User;

public class LoginActivity extends AppCompatActivity {

    Button btn_login, btn_sign_in;
    EditText et_username, et_password;

    public static final String TAG = LoginActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUI();

        btn_login.setOnClickListener(view -> {
            int id = UserDao.check(this, et_username.getText().toString(), et_password.getText().toString());
            if (id != -1) {
                SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("user_id", id);
                editor.putBoolean("just_login", true);
                editor.apply();
                Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Đăng nhập thất bại!", Toast.LENGTH_SHORT).show();
            }
        });

        btn_sign_in.setOnClickListener(view -> {
            User u = new User();
            u.setUsername(et_username.getText().toString());
            u.setPassword(et_password.getText().toString());
            int id = UserDao.create(this, u);
            if (id != -1) {
                SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("just_login", true);
                editor.putInt("user_id", id);
                editor.apply();
                Toast.makeText(this, "Đăng ký thàng công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Tài khoản đã tồn tại!", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void initUI() {
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        btn_sign_in = findViewById(R.id.btn_sign_in);
    }
}