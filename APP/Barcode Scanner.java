package com.example.myapplication1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;



public class SecondActivity extends AppCompatActivity {

    //initialize Variable
    Button btScan;
    Button btCal;
    Button btSos;
    Button btGov;
    Button btMarket;
    DatabaseReference databaseReference;
    String eatableString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //assign variable
        btScan=findViewById(R.id.bt_Scan);
        btCal=findViewById(R.id.bt_Cal);
        btSos=findViewById(R.id.bt_Sos);
        btGov=findViewById(R.id.bt_Gov);
        btMarket=findViewById(R.id.bt_Market);

        btMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // yeni sayfaya geçiş
                Intent btMarket=new Intent(SecondActivity.this, MapActivity.class);
                startActivity(btMarket);
            }
        });

        // E-nabız butonu ile yeni sayfaya gidiş
        btGov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // yeni sayfaya geçiş
                Intent btGov=new Intent(SecondActivity.this, FifthActivity.class);
                startActivity(btGov);
            }
        });
        // Doz hesaplama butonu ile yeni sayfaya gidiş
        btCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // yeni sayfaya geçiş
                Intent btCal=new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(btCal);
            }
        });
        // Acil durum butonu ile yeni sayfaya gidiş
        btSos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // yeni sayfaya geçiş
                Intent btSos=new Intent(SecondActivity.this, ForthActivity.class);
                startActivity(btSos);
            }
        });
        //butonun işlevleri
        btScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(

                        SecondActivity.this);
                // set message
                intentIntegrator.setPrompt("Flash için Ses açma/kapama tuşlarını kullanın.");
                //set beep
                intentIntegrator.setOrientationLocked(true);
                //set capture activtiy
                intentIntegrator.setCaptureActivity(Capture.class);
                //set scanner
                intentIntegrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //initialize result

        IntentResult intentResult = IntentIntegrator.parseActivityResult(
                requestCode,resultCode,data
        );
        //check Condition
        if(intentResult.getContents() != null){
            //when result content is not null
            //initialize alert dialog

        }else{
            //when result is null
            //display toast
            Toast.makeText(getApplicationContext(),
                    "Tarama yapılamadı",Toast.LENGTH_SHORT)
                    .show();
        }

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child("barcodes").child(intentResult.getContents()).exists()) {

                    //verileri çekme
                    String name = dataSnapshot.child("barcodes").child(intentResult.getContents()).child("name").getValue().toString();
                    String gluten_amount = dataSnapshot.child("barcodes").child(intentResult.getContents()).child("gluten_amount").getValue().toString();
                    String eatable = dataSnapshot.child("barcodes").child(intentResult.getContents()).child("eatable").getValue().toString();

                    if(eatable.equals("1")) {
                        eatableString = "Yenir";
                    }
                    else{
                        eatableString = "Yenmez";
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(

                            SecondActivity.this
                    );
                    //set title
                    builder.setTitle("Barkod Numarası");
                    //set message
                    builder.setMessage("Ürün: " + name + "\n" +
                            "Gluten Miktarı: " + gluten_amount + "\n" +
                            "Riski: " + eatableString);
                    //set positive button
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //dismiss Dialog
                            dialogInterface.dismiss();
                        }
                    });
                    //show alet dialog
                    builder.show();

                }
                else{

                    Toast.makeText(SecondActivity.this, "Bulunamadı", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}