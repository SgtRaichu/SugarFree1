package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ForthActivity extends AppCompatActivity {

    Button btEs;
    Button btCocuk;
    Button bt112;
    Button btDoktor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);

        btEs =findViewById(R.id.bt_Es);
        btCocuk =findViewById(R.id.bt_Cocuk);
        bt112 =findViewById(R.id.bt_112);
        btDoktor=findViewById(R.id.bt_Doktor);

        //ilk buton için aktivite
        btEs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:9999999999"));
                startActivity(i);
            }
        });
         //ikinci buton için aktivite
        btCocuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:9999999999"));
                startActivity(i);
            }
        });

        //üçüncü buton için aktivite
        bt112.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:112"));
                startActivity(i);
            }
        });
        //Dördüncü buton için aktivite
        btDoktor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:9999999999"));
                startActivity(i);
            }
        });





    }
}