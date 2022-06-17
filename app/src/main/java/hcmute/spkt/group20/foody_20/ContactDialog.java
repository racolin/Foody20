package hcmute.spkt.group20.foody_20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import hcmute.spkt.group20.foody_20.model.Shop;

public class ContactDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_contact);
        Shop shop = (Shop) getIntent().getSerializableExtra("shop");
        ((TextView) findViewById(R.id.tv_shop_name)).setText(shop.getName());
        ((TextView) findViewById(R.id.et_address)).setText(shop.getAddress());
        ((Button) findViewById(R.id.btn_ok)).setOnClickListener(v -> {
            finish();
        });
        setFinishOnTouchOutside(true);
    }
}