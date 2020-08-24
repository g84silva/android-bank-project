package com.example.bankproject.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bankproject.Model.BankTransaction;

import java.util.List;

@Dao
public interface BTransDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllBTransDAO(List<BankTransaction> bankTransactions);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertBTransDAO(BankTransaction bankTransaction);

    @Query("SELECT * FROM TransBancaria")
    List<BankTransaction> getAllBTransDAO();

    @Query("SELECT * FROM ContaBancaria WHERE bTransServer_id LIKE :bTransServer_id")
    BankTransaction getBTransDAO(String bTransServer_id);

    @Update
    void updateAccDAO(BankTransaction bankTransaction);
}
