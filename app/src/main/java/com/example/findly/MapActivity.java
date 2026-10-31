package com.example.findly;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    FusedLocationProviderClient fusedLocationClient;

    double placeLat, placeLng;
    String placeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        placeLat = getIntent().getDoubleExtra("lat", 0);
        placeLng = getIntent().getDoubleExtra("lng", 0);
        placeName = getIntent().getStringExtra("name");

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // aktifkan setting peta
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);

        // cek permission dulu
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    100);
            return;
        }

        mMap.setMyLocationEnabled(true); // 💙 tampilkan titik biru (lokasi user)

        // tampilkan marker tempat
        LatLng placePos = new LatLng(placeLat, placeLng);
        mMap.addMarker(new MarkerOptions()
                .position(placePos)
                .title(placeName)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        // pindahkan kamera secara smooth
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(placePos, 15));

        // ambil lokasi user dan tampilkan
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(location -> {
                    if (location != null) {
                        showUserMarker(location);
                    }
                });
    }

    private void showUserMarker(Location loc) {
        LatLng userPos = new LatLng(loc.getLatitude(), loc.getLongitude());

        // marker lokasi user custom (optional)
        mMap.addMarker(new MarkerOptions()
                .position(userPos)
                .title("Lokasi Anda")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))); // biru

        // zoom agar terlihat dua titik
        LatLng center = new LatLng(
                (userPos.latitude + placeLat) / 2,
                (userPos.longitude + placeLng) / 2
        );

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(center, 13));
    }
}
