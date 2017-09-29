package com.example.android_razrab.blurrylibrary;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import jp.wasabeef.blurry.Blurry;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rl;
    ImageView iv;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rl=(RelativeLayout)findViewById(R.id.rl);
        iv=(ImageView)findViewById(R.id.iv);

        bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.mfd);

        iv.post(new Runnable() {
            //@override
            public void run() {
                Blurry.with(MainActivity.this)
                        .radius(25)
                        .sampling(2)
                        .animate(500)
                        .onto(rl);
            }
        });


        // from Bitmap
        Blurry.with(this).from(bitmap).into(iv);



    }
}
