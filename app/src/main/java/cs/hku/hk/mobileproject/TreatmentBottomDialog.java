package cs.hku.hk.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class TreatmentBottomDialog extends BottomSheetDialogFragment {

    ListView mListView;

    // Test Data --> Replace with Database data (Any structure you prefer)
    int[] treatmentIds = {1,2,3};

    String[] treatmentnames = {"Deep Tissue Massage", "Foot Reflexology", "Lymphatic Detoxification"};
    Number[] times = {40, 50, 10};
    Number[] prices = {136, 468, 138};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.popup_treatment, container, false);

        mListView = (ListView) v.findViewById(R.id.treatment_listview);

        ViewGroup header = (ViewGroup) getLayoutInflater().inflate(R.layout.toolbar_back, mListView, false);
        TextView headerTitle = (TextView) header.findViewById(R.id.service_title);
        headerTitle.setText("Testing");

        mListView.addHeaderView(header, null, false);

        CustomAdaptor customAdaptor = new CustomAdaptor();
        mListView.setAdapter(customAdaptor);

        return v;
    }

    class CustomAdaptor extends BaseAdapter {

        @Override
        public int getCount() {
            return treatmentIds.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            final int curNum = i;

            View mView = getLayoutInflater().inflate(R.layout.layout_treatment_list, null);

            TextView treatmentNameTextView = (TextView) mView.findViewById(R.id.treatment_txtview);
            TextView timeTextView = (TextView) mView.findViewById(R.id.time_txtview);
            TextView priceView = (TextView) mView.findViewById(R.id.price_txtview);

            treatmentNameTextView.setText(treatmentnames[i]);
            timeTextView.setText(times[i] + " min");
            priceView.setText("HK$ " + prices[i]);

            return mView;
        }
    }
}
