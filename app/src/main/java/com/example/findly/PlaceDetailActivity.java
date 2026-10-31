package com.example.findly;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class PlaceDetailActivity extends AppCompatActivity {

    TextView txtName, txtAddress, txtHours, txtRating, txtPrice;
    Button btnMap, btnCall;
    ImageButton btnFav;
    PlaceDatabase db;
    SharedPreferences prefs;
    PlaceModel place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        txtName = findViewById(R.id.txtName);
        txtAddress = findViewById(R.id.txtAddress);
        txtHours = findViewById(R.id.txtOpenHours);
        txtRating = findViewById(R.id.txtRating);
        txtPrice = findViewById(R.id.txtPrice);
        btnMap = findViewById(R.id.btnMap);
        btnCall = findViewById(R.id.btnCall);
        btnFav = findViewById(R.id.btnFav);

        db = PlaceDatabase.getInstance(this);
        prefs = getSharedPreferences("FAVORITES", MODE_PRIVATE);

        int id = getIntent().getIntExtra("place_id", -1);
        if (id == -1) { finish(); return; }

        place = db.placeDao().getById(id);
        if (place == null) { finish(); return; }

        txtName.setText(place.getName());
        txtAddress.setText(place.getAddress());
        txtHours.setText(place.getOpenHour() + " - " + place.getCloseHour());
        txtRating.setText("⭐ " + place.getRating());
        txtPrice.setText("Mulai Rp " + place.getPrice());

        boolean fav = prefs.getBoolean("fav_" + place.getId(), false);
        btnFav.setImageResource(fav ? android.R.drawable.btn_star_big_on : android.R.drawable.btn_star_big_off);

        btnFav.setOnClickListener(v -> {
            boolean current = prefs.getBoolean("fav_" + place.getId(), false);
            prefs.edit().putBoolean("fav_" + place.getId(), !current).apply();
            btnFav.setImageResource(!current ? android.R.drawable.btn_star_big_on : android.R.drawable.btn_star_big_off);
            Toast.makeText(this, !current ? "Ditambahkan ke favorit" : "Dihapus dari favorit", Toast.LENGTH_SHORT).show();
        });

        btnCall.setOnClickListener(v -> {
            resetFilterButtons();
            btnCall.setBackgroundColor(android.graphics.Color.parseColor("#10B0B0"));
            btnCall.setTextColor(android.graphics.Color.parseColor("#FFFFFF"));

            btnCall.setEnabled(false); // mencegah double click

            new Handler().postDelayed(() -> {
                Intent dial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + place.getAddress()));
                startActivity(dial);

                btnCall.setEnabled(true);
            }, 200); // delay 0.5 detik
        });
        btnMap.setOnClickListener(v -> {
            resetFilterButtons();
            btnMap.setBackgroundColor(android.graphics.Color.parseColor("#10B0B0"));
            btnMap.setTextColor(android.graphics.Color.parseColor("#FFFFFF"));


            Intent mi = new Intent(this, MapActivity.class);
            mi.putExtra("lat", place.getLat());
            mi.putExtra("lng", place.getLng());
            mi.putExtra("name", place.getName());
            startActivity(mi);
        });
    }
    private void resetFilterButtons() {
        // Reset btnAddPlace
        btnCall.setBackgroundResource(R.drawable.button);
        btnCall.setTextColor(android.graphics.Color.parseColor("#00897B"));

        // Reset filter buttons
        btnMap.setBackgroundResource(R.drawable.button);
        btnMap.setTextColor(android.graphics.Color.parseColor("#00897B"));
    }
    protected void onResume() {
        super.onResume();

        resetFilterButtons();

    }

}
