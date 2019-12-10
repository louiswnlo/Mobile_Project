package cs.hku.hk.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ShopList extends AppCompatActivity {

    ListView mListView;

    // Test Data --> Replace with Database data
    int[] images = {R.drawable.shop_img_1,
                    R.drawable.shop_img_2,
                    R.drawable.shop_img_3,
                    R.drawable.shop_img_4,
                    R.drawable.shop_img_5,
                    R.drawable.shop_img_6 };

    String[] shopnames = {"Foot Spa Jordan", "Levo Spa", "The Foot Room",
                          "Beauty Parade", "Float on Hong Kong", "Charming Beuty & Slimming"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);

        mListView = (ListView) findViewById(R.id.listview);

        CustomAdaptor customAdaptor = new CustomAdaptor();
        mListView.setAdapter(customAdaptor);
    }

    class CustomAdaptor extends BaseAdapter {

        @Override
        public int getCount() {
            return images.length;
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

            View mView = getLayoutInflater().inflate(R.layout.layout_shop_list, null);

            ImageView mImageView = (ImageView) mView.findViewById(R.id.bg_img);
            TextView shopnameTextView = (TextView) mView.findViewById(R.id.shopname_txt);

            mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mImageView.setImageResource(images[i]);

            shopnameTextView.setText(shopnames[i]);

            return mView;
        }
    }

}
