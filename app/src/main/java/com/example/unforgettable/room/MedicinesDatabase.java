package com.example.unforgettable.room;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.unforgettable.entities.Medicine;

@Database(entities = Medicine.class, version = 1)
public abstract class MedicinesDatabase extends RoomDatabase {
    public abstract MedicineDAO medicineDAO();
}
