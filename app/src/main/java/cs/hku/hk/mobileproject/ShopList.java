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
    String[] shopIds;
    int[] images = {R.drawable.shop_img_1,
            R.drawable.shop_img_2,
            R.drawable.shop_img_3,
            R.drawable.shop_img_4,
            R.drawable.shop_img_5,
            R.drawable.shop_img_6 };

   String []shopnames;
    DataBaseHelper db;
//laterrr
    String[] ratings = {"5.0", "5.0", "4.5", "4.5", "4.0", "4.0"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);
        DataBaseHelper db = new DataBaseHelper(this);

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
            return
                    images.length;
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

            //db.insert("insert into albums (Albumid,ArtistId,Title) values (\"348\",\'1\',\"Michael\")");
           // System.out.println(db.checkDataBase());
            shopIds = db.getstuff("shop_id","shop");
            //images = getImages(db);

            View mView = getLayoutInflater().inflate(R.layout.layout_shop_list, null);

            ImageView mImageView = (ImageView) mView.findViewById(R.id.bg_img);
            TextView shopnameTextView = (TextView) mView.findViewById(R.id.shopname_txt);
            RatingBar mRatingBar = (RatingBar) mView.findViewById(R.id.rating_bar);

            mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mImageView.setImageResource(images[i]);
            mImageView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ShopList.this, ShopInfo.class);
                    intent.putExtra("SHOP_ID", shopIds[curNum]);
                    startActivity(intent);
                }
            });

            shopnameTextView.setText(shopnames[curNum]);

            mRatingBar.setRating(Float.parseFloat(ratings[curNum]));

            return mView;
        }
    }

}
