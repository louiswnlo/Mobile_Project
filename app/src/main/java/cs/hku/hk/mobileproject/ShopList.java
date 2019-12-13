package cs.hku.hk.mobileproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ShopList extends AppCompatActivity {

    ListView mListView;
    // Test Data --> Replace with Database data (Any structure you prefer)
    List<String> shopIds;
    List<String> imagesHolder;
    List<Integer> images;
    List<String> shopnames;
    List<String> ratings;
    DatabaseAccess db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);
        DatabaseAccess db = DatabaseAccess.getInstance(this);

        Intent intent = getIntent();
        String serviceName = intent.getStringExtra("SERVICE_NAME");

        mListView = (ListView) findViewById(R.id.listview);

        ViewGroup header = (ViewGroup) getLayoutInflater().inflate(R.layout.toolbar_back, mListView, false);
        TextView headerTitle = (TextView) header.findViewById(R.id.service_title);
        headerTitle.setText(serviceName);

        ImageButton backBtn = (ImageButton) header.findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mListView.addHeaderView(header, null, false);

        CustomAdaptor customAdaptor = new CustomAdaptor();
        mListView.setAdapter(customAdaptor);

    }


    class CustomAdaptor extends BaseAdapter {

        @Override
        public int getCount() {
            return 0;
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




            shopIds = db.selectSQL("shop_id","shop");
            imagesHolder = db.selectSQL("photo_url","shop");
            ratings = db.selectSQL("ratings","shop");
            //images = getImages(db);

            View mView = getLayoutInflater().inflate(R.layout.layout_shop_list, null);

            ImageView mImageView = (ImageView) mView.findViewById(R.id.bg_img);
            TextView shopnameTextView = (TextView) mView.findViewById(R.id.shopname_txt);
            RatingBar mRatingBar = (RatingBar) mView.findViewById(R.id.rating_bar);

            mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            for(String s : imagesHolder ) images.add(Integer.valueOf(s));

            mImageView.setImageResource(images.get(curNum));
            mImageView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ShopList.this, ShopInfo.class);
                    intent.putExtra("SHOP_ID", shopIds.get(curNum));
                    startActivity(intent);
                }
            });

            shopnameTextView.setText(shopnames.get(curNum));

            mRatingBar.setRating(Float.parseFloat(ratings.get(curNum)));

            return mView;
        }
    }

}
