package cs.hku.hk.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShopInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_info);

        Intent intent = getIntent();
        int shopId = intent.getIntExtra("SHOP_ID", 0);



        TextView title = (TextView) findViewById(R.id.service_title);

        title.setText("SHOP ID = " + shopId);

    }
}
