package com.example.findly;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface PlaceDao {

    @Insert
    long insertPlace(PlaceModel place);

    @Query("SELECT * FROM places")
    List<PlaceModel> getAllPlaces();

    @Query("SELECT * FROM places WHERE category = :cat")
    List<PlaceModel> getByCategory(String cat);

    @Update
    void updatePlace(PlaceModel place);

    @Query("SELECT * FROM places WHERE id = :id LIMIT 1")
    PlaceModel getById(int id);
}
