package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {


    Button btMail;
    Button btHesapla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third2);

        btMail=findViewById(R.id.bt_Mail);
        btHesapla=(Button) findViewById(R.id.bt_Hesapla);
        EditText  sayi_1= (EditText)findViewById(R.id.et_Aıd);
        EditText  sayi_2= (EditText)findViewById(R.id.et_Aks);
        TextView txtSonuc=(TextView)findViewById(R.id.txt_Sonuc);

        ConstraintLayout relativeLayout = findViewById(R.id.relativeLayout);

        btHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            int s1=Integer.parseInt(sayi_1.getText().toString());
            int s2=Integer.parseInt(sayi_2.getText().toString());
            int  sonuc= (s1*s2) / 405;
                        txtSonuc.setText("İnsülin direncin :"+sonuc);


                if(sonuc > 3) {
                    txtSonuc.setText("sağlıklı" + sonuc);
                    relativeLayout.setBackgroundColor(Color.GREEN);
                }
                else{
                    txtSonuc.setText("hasta" + sonuc);
                    relativeLayout.setBackgroundColor(Color.RED);
                }

            }
        });


        btMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                //i.putExtra(i.EXTRA_EMAIL,sonuc);
            }
        });


    }
}