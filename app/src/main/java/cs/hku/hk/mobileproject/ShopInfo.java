package cs.hku.hk.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShopInfo extends AppCompatActivity implements TreatmentBottomDialog.BottomSheetListener, TimeBottomDialog.BottomSheetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_info);

        Intent intent = getIntent();
        int shopId = intent.getIntExtra("SHOP_ID", 0);


        ImageButton backBtn = (ImageButton) findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView title = (TextView) findViewById(R.id.service_title);

        title.setText("SHOP ID = " + shopId);

        Button treatmentBtn = (Button) findViewById(R.id.treatment_btn);
        Button timeBtn = (Button) findViewById(R.id.time_btn);

        treatmentBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                TreatmentBottomDialog bottomSheet = new TreatmentBottomDialog();
                bottomSheet.show(getSupportFragmentManager(), "TreatmentBottomSheet");
            }
        });

        timeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                TimeBottomDialog bottomSheet = new TimeBottomDialog();
                bottomSheet.show(getSupportFragmentManager(), "TimeBottomSheet");
            }
        });

        ImageButton mapBtn = (ImageButton) findViewById(R.id.map_Btn);
        mapBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShopInfo.this, Map.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onButtonClicked(Integer treatmentId, String treatmentName) {
        Button treatmentBtn = (Button) findViewById(R.id.treatment_btn);

        treatmentBtn.setText(treatmentName);
    }

    @Override
    public void onButtonClicked(String bookTime) {
        Button timeBtn = (Button) findViewById(R.id.time_btn);

        timeBtn.setText(bookTime);
    }

}
