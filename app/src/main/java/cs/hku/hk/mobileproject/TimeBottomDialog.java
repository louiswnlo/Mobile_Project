package cs.hku.hk.mobileproject;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class TimeBottomDialog extends BottomSheetDialogFragment {

    private BottomSheetListener mListener;
    ListView mListView;

    // Test Data --> Replace with Database data (Any structure you prefer)
    String[] availableTime = { "10:00 AM", "10:15 AM" , "10:30 AM", "10:45 AM", "10:50 AM"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.popup_time, container, false);

        mListView = (ListView) v.findViewById(R.id.time_listview);

        ViewGroup header = (ViewGroup) getLayoutInflater().inflate(R.layout.toolbar_time, mListView, false);

        mListView.addHeaderView(header, null, false);

        CustomAdaptor customAdaptor = new CustomAdaptor();
        mListView.setAdapter(customAdaptor);

        return v;
    }

    public interface BottomSheetListener {
        void onButtonClicked(String bookTime);
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

    class CustomAdaptor extends BaseAdapter {

        @Override
        public int getCount() {
            return availableTime.length;
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

            View mView = getLayoutInflater().inflate(R.layout.layout_time_list, null);

            TextView timeTextView = (TextView) mView.findViewById(R.id.time_txtview);

            timeTextView.setText(availableTime[i]);

            mView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    mListener.onButtonClicked(availableTime[curNum]);
                    dismiss();
                }
            });

            return mView;
        }
    }
}

