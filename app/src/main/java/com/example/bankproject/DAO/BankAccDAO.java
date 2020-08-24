package com.example.bankproject.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bankproject.Model.BankAccount;
import com.example.bankproject.Model.User;

import java.util.List;

@Dao
public interface BankAccDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllAccDAO(List<BankAccount> bankAccounts);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAccDAO(BankAccount bankAccount);

    @Query("SELECT * FROM ContaBancaria")
    List<BankAccount> getAllAccDAO();

    @Query("SELECT * FROM ContaBancaria WHERE accServer_id LIKE :accServer_id")
    BankAccount getAccDAO(String accServer_id);

    @Update
    void updateAccDAO(BankAccount bankAccount);
}
