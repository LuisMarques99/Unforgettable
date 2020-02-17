package com.example.unforgettable.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.unforgettable.entities.User;

@Database(entities = User.class, version = 1)
public abstract class UsersDatabase extends RoomDatabase {

    private static final String NAME = "Unforgettable_UsersDB";

    private static UsersDatabase instance;

    public abstract UserDAO userDAO();

    public static String getNAME() {
        return NAME;
    }

    public static UsersDatabase getInstance(final Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), UsersDatabase.class,
                    NAME).build();
        }

        return instance;
    }
}
