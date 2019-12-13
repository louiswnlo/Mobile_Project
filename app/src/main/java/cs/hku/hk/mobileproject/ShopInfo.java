package cs.hku.hk.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class ShopInfo extends AppCompatActivity implements TreatmentBottomDialog.BottomSheetListener, TimeBottomDialog.BottomSheetListener, bookingBottomDialog.BottomSheetListener {

    Dialog confirmDialog;
    String timeSelected = "";
    String treatmentSelected = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_info);

        confirmDialog = new Dialog(this);

        Intent intent = getIntent();
        final int shopId = intent.getIntExtra("SHOP_ID", 0);


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
        Button bookingBtn = (Button) findViewById(R.id.book_btn);

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

        bookingBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                bookingBottomDialog bottomSheet = new bookingBottomDialog("ShopId = "+ shopId, treatmentSelected, timeSelected);
                bottomSheet.show(getSupportFragmentManager(), "BookingBottomSheet");
            }
        });
    }

    @Override
    public void onButtonClicked(Integer treatmentId, String treatmentName) {
        Button treatmentBtn = (Button) findViewById(R.id.treatment_btn);
        treatmentSelected = treatmentName;
        treatmentBtn.setText(treatmentName);
    }

    @Override
    public void onButtonClicked(String bookTime) {
        Button timeBtn = (Button) findViewById(R.id.time_btn);
        timeSelected = bookTime;
        timeBtn.setText(bookTime);
    }

    @Override
    public void onButtonClicked(Boolean confirmBool) {
        if(confirmBool){
            confirmDialog.setContentView(R.layout.popup_congrats);
            confirmDialog.show();

            // Hide after some seconds
            final Handler handler  = new Handler();
            final Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    if (confirmDialog.isShowing()) {
                        confirmDialog.dismiss();
                    }
                }
            };

            confirmDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    handler.removeCallbacks(runnable);
                }
            });

            handler.postDelayed(runnable, 3000);
        }
    }

}
