package com.example.findly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlaceActivity extends AppCompatActivity {

    EditText edtName, edtCategory, edtAddress, edtLat, edtLng, edtOpen, edtClose, edtRating, edtPrice;
    Button btnSave;
    PlaceDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_place);

        edtName = findViewById(R.id.edtName);
        edtCategory = findViewById(R.id.edtCategory);
        edtAddress = findViewById(R.id.edtAddress);
        edtLat = findViewById(R.id.edtLat);
        edtLng = findViewById(R.id.edtLon);
        edtOpen = findViewById(R.id.edtOpen);
        edtClose = findViewById(R.id.edtClose);
        edtRating = findViewById(R.id.edtRating);
        edtPrice = findViewById(R.id.edtPrice);
        btnSave = findViewById(R.id.btnSave);

        db = PlaceDatabase.getInstance(this);

        btnSave.setOnClickListener(v -> {

            btnSave.setBackgroundColor(android.graphics.Color.parseColor("#10B0B0"));
            btnSave.setTextColor(android.graphics.Color.parseColor("#FFFFFF"));

            String name = edtName.getText().toString().trim();
            if (name.isEmpty()) { Toast.makeText(this, "Isi nama", Toast.LENGTH_SHORT).show(); return; }
            String cat = edtCategory.getText().toString().trim();
            double lat = parseDoubleOrZero(edtLat.getText().toString());
            double lng = parseDoubleOrZero(edtLng.getText().toString());
            String addr = edtAddress.getText().toString().trim();
            String open = edtOpen.getText().toString().trim();
            String close = edtClose.getText().toString().trim();
            float rating = parseFloatOrZero(edtRating.getText().toString());
            int price = (int) parseDoubleOrZero(edtPrice.getText().toString());

            PlaceModel p = new PlaceModel(name, cat, lat, lng, addr, open, close, rating, price);
            db.placeDao().insertPlace(p);
            Toast.makeText(this, "Tempat tersimpan", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    private double parseDoubleOrZero(String s) {
        try { return Double.parseDouble(s); } catch (Exception e) { return 0; }
    }
    private float parseFloatOrZero(String s) {
        try { return Float.parseFloat(s); } catch (Exception e) { return 0; }
    }
}
