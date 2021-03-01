package com.gurudattdahare.snake2d;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        DisplayMetrics dm =new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        Constrant.SCREEN_WIDTH=dm.widthPixels;
        Constrant.SCREEN_HIGHT=dm.heightPixels;
        setContentView(R.layout.activity_main);
        Log.d("guru1","widhtPixels= "+Constrant.SCREEN_WIDTH+" hightPixels= "+Constrant.SCREEN_HIGHT);
    }
}