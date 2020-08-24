package com.example.bankproject.DAO;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.bankproject.model.User;

@Database(
    entities = {User.class},
    version = 1)
public abstract class AppDatabase extends RoomDatabase {

  public abstract UserDao userDao();

  private static AppDatabase instance = null;

  public static AppDatabase getInstance(Context context) {
    if (instance == null) {
      instance =
          Room.databaseBuilder(context, AppDatabase.class, "Project_bank")
              .allowMainThreadQueries()
              .fallbackToDestructiveMigration()
              .build();
    }
    return instance;
  }
}
