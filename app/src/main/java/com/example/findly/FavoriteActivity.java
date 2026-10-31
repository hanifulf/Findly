package com.example.findly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {

    RecyclerView rvFavorites;
    PlaceDatabase db;
    SharedPreferences prefs;
    List<PlaceModel> allPlaces, favList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        rvFavorites = findViewById(R.id.btnFavorites);
        db = PlaceDatabase.getInstance(this);
        prefs = getSharedPreferences("FAVORITES", MODE_PRIVATE);

        loadFavorites();
    }

    private void loadFavorites() {
        allPlaces = db.placeDao().getAllPlaces();
        favList = new ArrayList<>();

        for (PlaceModel p : allPlaces) {
            boolean isFav = prefs.getBoolean("fav_" + p.getId(), false);
            if (isFav) favList.add(p);
        }

        rvFavorites.setLayoutManager(new LinearLayoutManager(this));
        rvFavorites.setAdapter(new PlaceAdapter(favList, this, prefs));
    }
}
