package com.example.findly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView rvRecommendation;
    GridLayout gridCategories;
    EditText edtSearch;
    ImageView btnClearSearch;
    Button btnAddPlace, btnFilterNearest, btnFilterOpen, btnFilterRating;
    TextView txtFavorites;

    PlaceDatabase db;
    List<PlaceModel> places;
    SharedPreferences prefsFavorites;

    // GPS
    FusedLocationProviderClient fusedLocationClient;
    double userLat = 0;
    double userLng = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rvRecommendation = findViewById(R.id.rvRecommendation);
        gridCategories = findViewById(R.id.gridCategories);
        edtSearch = findViewById(R.id.edtSearch);
        btnClearSearch = findViewById(R.id.btnClearSearch);
        btnAddPlace = findViewById(R.id.btnAddPlace);
        btnFilterNearest = findViewById(R.id.btnFilterNearest);
        btnFilterOpen = findViewById(R.id.btnFilterOpen);
        btnFilterRating = findViewById(R.id.btnFilterRating);
        txtFavorites = findViewById(R.id.txtFavorites);

        db = PlaceDatabase.getInstance(this);
        prefsFavorites = getSharedPreferences("FAVORITES", MODE_PRIVATE);

        DummyDataHelper.ensureDummy(this);
        loadPlaces();
        setupCategories();

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        getUserLocation(); // Ambil lokasi user

        rvRecommendation.setLayoutManager(new LinearLayoutManager(this));
        rvRecommendation.setAdapter(new PlaceAdapter(new ArrayList<>(places), this, prefsFavorites));

        addFadeAnimation();

        // REALTIME SEARCH
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String keyword = s.toString().trim().toLowerCase();
                btnClearSearch.setVisibility(keyword.isEmpty() ? View.GONE : View.VISIBLE);

                List<PlaceModel> filtered = new ArrayList<>();

                for (PlaceModel p : places) {
                    if (p.getName().toLowerCase().contains(keyword)
                            || p.getCategory().toLowerCase().contains(keyword)
                            || p.getAddress().toLowerCase().contains(keyword)) {
                        filtered.add(p);
                    }
                }

                rvRecommendation.setAdapter(new PlaceAdapter(filtered, HomeActivity.this, prefsFavorites));
                addFadeAnimation();
            }

            @Override public void afterTextChanged(Editable s) {}
        });

        // CLEAR SEARCH
        btnClearSearch.setOnClickListener(v -> {
            edtSearch.setText("");
            hideKeyboard();
        });

        // FILTER TERDEKAT – PUKE GPS
        btnFilterNearest.setOnClickListener(v -> {
            resetFilterButtons();
            btnFilterNearest.setBackgroundColor(android.graphics.Color.parseColor("#10B0B0"));
            btnFilterNearest.setTextColor(android.graphics.Color.WHITE);

            if (userLat == 0 && userLng == 0) {
                Toast.makeText(this, "Mendeteksi lokasi Anda...", Toast.LENGTH_SHORT).show();
                getUserLocation();
                return;
            }

            for (PlaceModel p : places) {
                double jarak = Utils.haversine(userLat, userLng, p.getLat(), p.getLng());
                p.setDistanceKm(jarak);
            }

            Collections.sort(places, Comparator.comparingDouble(PlaceModel::getDistanceKm));

            rvRecommendation.setAdapter(new PlaceAdapter(new ArrayList<>(places), HomeActivity.this, prefsFavorites));
            addFadeAnimation();
        });

        // FILTER BUKA
        btnFilterOpen.setOnClickListener(v -> {
            resetFilterButtons();
            btnFilterOpen.setBackgroundColor(android.graphics.Color.parseColor("#10B0B0"));
            btnFilterOpen.setTextColor(android.graphics.Color.WHITE);

            List<PlaceModel> open = new ArrayList<>();
            for (PlaceModel p : places) {
                if (Utils.isOpenNow(p.getOpenHour(), p.getCloseHour())) open.add(p);
            }

            rvRecommendation.setAdapter(new PlaceAdapter(open, HomeActivity.this, prefsFavorites));
            addFadeAnimation();
        });

        // FILTER RATING
        btnFilterRating.setOnClickListener(v -> {
            resetFilterButtons();
            btnFilterRating.setBackgroundColor(android.graphics.Color.parseColor("#10B0B0"));
            btnFilterRating.setTextColor(android.graphics.Color.WHITE);

            Collections.sort(places, (a, b) -> Float.compare(b.getRating(), a.getRating()));
            rvRecommendation.setAdapter(new PlaceAdapter(new ArrayList<>(places), HomeActivity.this, prefsFavorites));
            addFadeAnimation();
        });

        // NAVIGASI KE FAVORIT
        txtFavorites.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, FavoriteActivity.class));
        });

        // BUTTON TAMBAH TEMPAT
        btnAddPlace.setOnClickListener(v -> {
            Intent i = new Intent(HomeActivity.this, AddPlaceActivity.class);
            startActivity(i);
        });
    }

    // Ambil lokasi user
    private void getUserLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 100);
            return;
        }

        fusedLocationClient.getLastLocation().addOnSuccessListener(location -> {
            if (location != null) {
                userLat = location.getLatitude();
                userLng = location.getLongitude();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getUserLocation();
        loadPlaces();
        rvRecommendation.setAdapter(new PlaceAdapter(new ArrayList<>(places), this, prefsFavorites));
        addFadeAnimation();
    }

    private void loadPlaces() {
        places = db.placeDao().getAllPlaces();
        for (PlaceModel p : places) {
            boolean fav = prefsFavorites.getBoolean("fav_" + p.getId(), false);
            p.setFavorite(fav);
        }
    }

    private void addFadeAnimation() {
        AlphaAnimation anim = new AlphaAnimation(0f, 1f);
        anim.setDuration(250);
        rvRecommendation.startAnimation(anim);
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void resetFilterButtons() {
        btnFilterNearest.setBackgroundResource(R.drawable.button);
        btnFilterNearest.setTextColor(android.graphics.Color.parseColor("#00897B"));

        btnFilterOpen.setBackgroundResource(R.drawable.button);
        btnFilterOpen.setTextColor(android.graphics.Color.parseColor("#00897B"));

        btnFilterRating.setBackgroundResource(R.drawable.button);
        btnFilterRating.setTextColor(android.graphics.Color.parseColor("#00897B"));

        btnAddPlace.setBackgroundResource(R.drawable.button);
        btnAddPlace.setTextColor(android.graphics.Color.parseColor("#00897B"));
    }

    private void setupCategories() {
        class CatItem {
            String label;
            int icon;
            CatItem(String label, int icon) {
                this.label = label;
                this.icon = icon;
            }
        }

        CatItem[] items = {
                new CatItem("Service AC", R.drawable.ic_service_ac),
                new CatItem("Service Laptop", R.drawable.ic_computer),
                new CatItem("Food & Drink", R.drawable.ic_food_drink),
                new CatItem("Laundry", R.drawable.ic_laundry),
                new CatItem("Tukang Kunci", R.drawable.ic_tukang_kunci),
                new CatItem("Bengkel", R.drawable.ic_bengkel)
        };

        gridCategories.removeAllViews();
        gridCategories.setColumnCount(3);

        for (CatItem c : items) {
            View view = getLayoutInflater().inflate(R.layout.category_item, null);

            ImageView img = view.findViewById(R.id.imgIcon);
            TextView txt = view.findViewById(R.id.txtLabel);

            img.setImageResource(c.icon);
            txt.setText(c.label);

            GridLayout.LayoutParams lp = new GridLayout.LayoutParams();
            lp.width = 0;
            lp.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
            lp.setMargins(8, 8, 8, 8);

            view.setLayoutParams(lp);

            view.setOnClickListener(v -> {
                Intent intent = new Intent(HomeActivity.this, PlaceListActivity.class);
                intent.putExtra("category", c.label);
                startActivity(intent);
            });

            gridCategories.addView(view);
        }
    }
}
