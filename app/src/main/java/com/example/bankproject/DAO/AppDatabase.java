package com.example.bankproject.DAO;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.bankproject.Model.BankAccount;
import com.example.bankproject.Model.BankTransaction;
import com.example.bankproject.Model.User;

@Database(entities = {User.class, BankAccount.class, BankTransaction.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDAO userDAO();
    public abstract BankAccDAO bankAccDAO();
    public abstract BTransDAO bTransDAO();

    private static AppDatabase instance = null;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "Project_bank")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
