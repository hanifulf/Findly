package com.example.findly;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "places")
public class PlaceModel {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String category;
    private double lat;
    private double lng;
    private String address;
    private String openHour;
    private String closeHour;
    private float rating;
    private int price;

    private boolean favorite = false;
    private double distanceKm = 0.0;

    public PlaceModel(String name, String category, double lat, double lng,
                      String address, String openHour, String closeHour,
                      float rating, int price) {

        this.name = name;
        this.category = category;
        this.lat = lat;
        this.lng = lng;
        this.address = address;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.rating = rating;
        this.price = price;
    }

    // ⬇ Getter Setter ⬇
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getLat() { return lat; }
    public double getLng() { return lng; }
    public String getAddress() { return address; }
    public String getOpenHour() { return openHour; }
    public String getCloseHour() { return closeHour; }
    public float getRating() { return rating; }
    public int getPrice() { return price; }


    public boolean isFavorite() { return favorite; }
    public void setFavorite(boolean favorite) { this.favorite = favorite; }

    public double getDistanceKm() { return distanceKm; }
    public void setDistanceKm(double distanceKm) { this.distanceKm = distanceKm; }
}
