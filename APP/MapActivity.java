package com.example.myapplication1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this::onMapReady);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map=googleMap;

        LatLng MMMigros =new LatLng(41.2060842,32.5855014);
        map.addMarker(new MarkerOptions().position(MMMigros)
                .title("MM Migros")
                .snippet("Uygun Market 1"));
        LatLng SACarrefour =new LatLng(41.2060736,32.5855013);
        map.addMarker(new MarkerOptions().position(SACarrefour)
                .title("Carrefour")
                .snippet("Uygun Market 2"));

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(MMMigros,10));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(SACarrefour,10));

    }
}