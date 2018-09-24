package com.example.app.roomjava.Room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDAO{

    @Insert(onConflict = REPLACE)
    void insert(User user);

    @Insert(onConflict = REPLACE)
    void insertAll(List<User> users);

    @Update(onConflict = REPLACE)
    void update(User user);

    @Update(onConflict = REPLACE)
    void updateAll(List<User> users);

    @Delete
    void delete(User user);

    @Transaction
    @Query("DELETE FROM user")
    void deleteAll();

    @Transaction
    @Query("SELECT * FROM user WHERE id = :id")
    User getUser(int id);

    @Transaction
    @Query("SELECT * FROM user")
    List<User> getAllUsers();
}