package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class FifthActivity extends AppCompatActivity {

    //initialize Variable
    Button btHes;
    Button btDevlet;
    Button btNabız;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        //assign variable
        btHes=findViewById(R.id.bt_Hes);
        btDevlet=findViewById(R.id.bt_Devlet);
        btNabız=findViewById(R.id.bt_Nabız);

        //hes sayfasına gitme
        btHes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btHes =new Intent(Intent.ACTION_VIEW, Uri.parse("https://hayatevesigar.saglik.gov.tr"));
                startActivity(btHes);
            }
        });

        //e devlet sayfasına gitme
        btDevlet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btDevlet =new Intent(Intent.ACTION_VIEW, Uri.parse("https://giris.turkiye.gov.tr"));
                startActivity(btDevlet);
            }
        });

        //e nabız sayfasına gitme
        btNabız.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btNabız =new Intent(Intent.ACTION_VIEW, Uri.parse("https://enabiz.gov.tr"));
                startActivity(btNabız);
            }
        });



    }
}