package com.example.bankproject.Repository;

import android.content.Context;

import com.example.bankproject.DAO.AppDatabase;
import com.example.bankproject.Model.BankAccount;
import com.example.bankproject.Model.BankTransaction;

import java.util.List;

public class BankTransactionRepository {

    private AppDatabase database;

    public BankTransactionRepository(Context context) {
        this(AppDatabase.getInstance(context));
    }

    private BankTransactionRepository(AppDatabase instance) {
        this.database = instance;
    }

    private void insert(List<BankTransaction> bankTransactions) {
        database.bTransDAO().insertAllBTransDAO(bankTransactions);
    }
}
