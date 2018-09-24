package com.example.app.roomjava.Room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDB extends RoomDatabase {

    public abstract UserDAO userDAO();

    private static UserDB INSTANCE = null;

    public static UserDB getInstance(Context context) {
        if(INSTANCE==null)
            INSTANCE = Room.databaseBuilder(context,UserDB.class,"UserDB").allowMainThreadQueries().build();
        return INSTANCE;
    }
}
