package com.example.unforgettable.room;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.unforgettable.entities.Medicine;

@Database(entities = Medicine.class, version = 1)
public abstract class MedicinesDatabase extends RoomDatabase {

    private static final String NAME = "Unforgettable_MedicinesDB";

    private static MedicinesDatabase instance;

    public abstract MedicineDAO medicineDAO();

    public static String getNAME() {
        return NAME;
    }

    public static MedicinesDatabase getInstance(final Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MedicinesDatabase.class, NAME).build();
        }

        return instance;
    }
}
