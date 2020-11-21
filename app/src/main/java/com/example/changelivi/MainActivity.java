package com.example.changelivi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Window window;

    Button mBtnBlue;
    Button mBtnRed;
    Button mBtnBlack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnBlue = (Button) findViewById(R.id.btn_Blue);
        mBtnRed = (Button) findViewById(R.id.btn_Red);
        mBtnBlack = (Button) findViewById(R.id.btn_Black);

        this.window = getWindow();

        mBtnBlue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String primaryDark ="#321BD8";
                String primary = "#503CE4";
                String background= "#736DA4";

                cambiarColor(primaryDark,primary,background);
            }
        });
        mBtnRed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String primaryDark = "#CF093F";
                String primary = "#DE5379";
                String background= "#92606E";
                cambiarColor(primaryDark,primary,background);            }
        });

        mBtnBlack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String primaryDark = "#716B6C";
                String primary = "#A29396";
                String background= "#6E6063";
                cambiarColor(primaryDark,primary,background);            }
        });

    }

    private void cambiarColor(String primaryDark,String primary,String background){
        //ColorPrimaryDark
        window.setStatusBarColor(Color.parseColor(primaryDark));
        //ColorPrimary
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(primary)));
        //bg
        window.setBackgroundDrawable(new ColorDrawable(Color.parseColor(background)));
        //Botton navigation
        window.setNavigationBarColor(Color.parseColor(primary));

        SharedPreferences mSharedPreferences = getSharedPreferences("ToolbarColor",MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putInt("color",Color.parseColor(primaryDark));
        mEditor.apply();

    }
}