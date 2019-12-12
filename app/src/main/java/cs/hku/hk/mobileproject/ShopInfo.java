package cs.hku.hk.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        Button treatmentBtn = (Button) findViewById(R.id.treatment_btn);

        treatmentBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                TreatmentBottomDialog bottomSheet = new TreatmentBottomDialog();
                bottomSheet.show(getSupportFragmentManager(), "TreatmentBottomSheet");
            }
        });

    }
}
