package com.example.findly;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Database;

@Database(entities = {PlaceModel.class}, version = 2)

public abstract class PlaceDatabase extends RoomDatabase {

    private static PlaceDatabase instance;

    public abstract PlaceDao placeDao();

    public static synchronized PlaceDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            PlaceDatabase.class, "places.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

}
