package cs.hku.hk.mobileproject;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class bookingBottomDialog extends BottomSheetDialogFragment {

    private BottomSheetListener mListener;
    private static BottomSheetBehavior bottomSheetBehavior;
    private static View bottomSheetInternal;
    private static bookingBottomDialog INSTANCE;
    ListView mListView;
    String displayTreatment = "";
    String displayTime = "";
    String displayShop = "";

    public bookingBottomDialog(String shopSelected, String treatmentSelected, String timeSelected){
        displayShop = shopSelected;
        displayTime = timeSelected;
        displayTreatment = treatmentSelected;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.popup_booking, container, false);

        getDialog().setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                BottomSheetDialog d = (BottomSheetDialog) dialog;
                FrameLayout bottomSheet = (FrameLayout) d.findViewById(R.id.design_bottom_sheet);
                CoordinatorLayout relativeLayout = (CoordinatorLayout) bottomSheet.getParent();
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
                bottomSheetBehavior.setPeekHeight(bottomSheet.getHeight());
                relativeLayout.getParent().requestLayout();
            }
        });
        INSTANCE = this;

        Button confirmBtn = (Button) v.findViewById(R.id.confirm_btn);
        TextView shopTextVIew = (TextView) v.findViewById(R.id.shopname_txt);
        TextView timeTextVIew = (TextView) v.findViewById(R.id.time_txt);
        TextView treatmentTextVIew = (TextView) v.findViewById(R.id.treatment_txt);

        shopTextVIew.setText(displayShop);
        timeTextVIew.setText(displayTime);
        treatmentTextVIew.setText(displayTreatment);

        confirmBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mListener.onButtonClicked(true);
                dismiss();
            }
        });

        return v;



//        View v = inflater.inflate(R.layout.popup_booking, container, false);
//
//        Button confirmBtn = (Button) v.findViewById(R.id.confirm_btn);
//        TextView shopTextVIew = (TextView) v.findViewById(R.id.shopname_txt);
//        TextView timeTextVIew = (TextView) v.findViewById(R.id.time_txt);
//        TextView treatmentTextVIew = (TextView) v.findViewById(R.id.treatment_txt);
//
//        shopTextVIew.setText(displayShop);
//        timeTextVIew.setText(displayTime);
//        treatmentTextVIew.setText(displayTreatment);
//
//        confirmBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                mListener.onButtonClicked(true);
//                dismiss();
//            }
//        });
//
//        return v;
    }

    public interface BottomSheetListener {
        void onButtonClicked(Boolean confirmBool);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (BottomSheetListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement BottomSheetListener");
        }
    }

}
