package com.example.findly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlaceListActivity extends AppCompatActivity {

    RecyclerView rvList;
    TextView txtTitle;
    SharedPreferences prefs;
    List<PlaceModel> places = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_list);

        rvList = findViewById(R.id.rvList);
        txtTitle = findViewById(R.id.txtTitle);

        prefs = getSharedPreferences("FAVORITES", MODE_PRIVATE);

        String category = getIntent().getStringExtra("category");
        txtTitle.setText(category);

        // 🔥 Ambil data dummy sesuai kategori
        PlaceDatabase db = PlaceDatabase.getInstance(this);
        places = db.placeDao().getByCategory(category);

        if (places == null) places = new ArrayList<>();

        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(new PlaceAdapter(places, this, prefs));
    }
}
