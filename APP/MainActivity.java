package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {


    private TextView textYazi ;
    private ImageView imgGorsel;
    private static int Gecis_Suresi=4000;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tanımlama
        textYazi= (TextView)findViewById(R.id.txtYazi);
        imgGorsel= (ImageView)findViewById(R.id.imgGorsel);

        //animasyon
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.animation);
        textYazi.startAnimation(animation);
        imgGorsel.startAnimation(animation);
        //geçiş

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent gecis = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(gecis);
                finish();


            }
        },Gecis_Suresi);

    }
}