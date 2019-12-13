package cs.hku.hk.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Context;
import android.os.Bundle;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toolbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBaseHelper db = new DataBaseHelper(this);
        db.open();
        ImageButton nailBtn = (ImageButton) findViewById(R.id.nail_btn);
        ImageButton eyelashesBtn = (ImageButton) findViewById(R.id.eyelashes_btn);
        ImageButton massageBtn = (ImageButton) findViewById(R.id.massage_btn);
        ImageButton hairBtn = (ImageButton) findViewById(R.id.hair_btn);

        nailBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShopList.class);
                intent.putExtra("SERVICE_NAME", "NAILS");
                startActivity(intent);
            }
        });

        eyelashesBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShopList.class);
                intent.putExtra("SERVICE_NAME", "EYELASHES");
                startActivity(intent);
            }
        });

        massageBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShopList.class);
                intent.putExtra("SERVICE_NAME", "MASSAGE");
                startActivity(intent);
            }
        });

        hairBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShopList.class);
                intent.putExtra("SERVICE_NAME", "HAIR");
                startActivity(intent);
            }
        });

        db.getstuff("user_id","user");
        db.close();

    }

}
