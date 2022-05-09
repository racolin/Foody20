package hcmute.spkt.group20.foody_20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class VerifyOTPActivity extends AppCompatActivity {

    EditText et_1, et_2, et_3, et_4, et_5, et_6;
    Button btn_confirm, btn_send;
    TextView tv_phone, tv_count;
    CountDownTimer timer;
    private static final long TIME_EXPIRE = 120L;


    public static final String TAG = VerifyOTPActivity.class.getSimpleName();
    public String verificationId;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);
        auth = FirebaseAuth.getInstance();
        initUI();
        initListener();
    }

    private void initUI() {
        et_1 = findViewById(R.id.et_1);
        et_2 = findViewById(R.id.et_2);
        et_3 = findViewById(R.id.et_3);
        et_4 = findViewById(R.id.et_4);
        et_5 = findViewById(R.id.et_5);
        et_6 = findViewById(R.id.et_6);

        tv_count = findViewById(R.id.tv_count);
        tv_phone = findViewById(R.id.tv_phone);

        btn_send = findViewById(R.id.btn_send);
        btn_confirm = findViewById(R.id.btn_confirm);
    }

    private void initListener() {
        btn_confirm.setOnClickListener(v -> {
            btn_confirm.setEnabled(false);
            String otp = getFullOTP();
            if (otp.length() == 6) {
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, otp);

                    signInWithPhoneAuthCredential(credential);
            } else {
                Toast.makeText(getApplicationContext(), R.string.otp_not_format, Toast.LENGTH_SHORT).show();
            }
        });

        btn_send.setOnClickListener(v -> {
            sendOTP();
        });
    }

    private String getFullOTP() {
        return "" + et_1.getText().toString() +
                et_2.getText().toString() +
                et_3.getText().toString() +
                et_4.getText().toString() +
                et_5.getText().toString() +
                et_6.getText().toString();
    }

    private void sendOTP() {
        PhoneAuthOptions phoneAuthOptions = PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber(tv_phone.getText().toString())
                .setTimeout(TIME_EXPIRE, TimeUnit.SECONDS)
                .setActivity(this)
                .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        signInWithPhoneAuthCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(getApplicationContext(), R.string.error, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        verificationId = s;
                        timer = new CountDownTimer(TIME_EXPIRE * 1000, 200) {
                            @Override
                            public void onTick(long l) {
                                tv_count.setText(String.valueOf(l / 1000));
                            }

                            @Override
                            public void onFinish() {
                                btn_confirm.setEnabled(true);
                            }
                        };
                        timer.start();
                    }
                })
                .build();
        PhoneAuthProvider.verifyPhoneNumber(phoneAuthOptions);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            // Update UI
                            loginSuccess();
                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(getApplicationContext(), R.string.error, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void loginSuccess() {
        timer.cancel();
        setResult(RESULT_OK);
        finish();
    }
}