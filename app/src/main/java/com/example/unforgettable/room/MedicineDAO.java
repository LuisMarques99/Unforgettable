package com.example.unforgettable.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.unforgettable.entities.Medicine;

@Dao
public interface MedicineDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertMedicine(Medicine... medicines);
}
