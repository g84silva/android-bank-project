package com.example.bankproject.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankproject.R;
import com.example.bankproject.adapter.TransactionAdapter;
import com.example.bankproject.dto.response.AccountExtractResponse;
import com.example.bankproject.model.Transaction;
import com.example.bankproject.model.User;
import com.example.bankproject.repository.TransactionRepository;
import com.example.bankproject.service.RequestResult;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExtractActivity extends AppCompatActivity {

    private static final String TRANS_ACCOUNT = "Bank transaction";
    private List<AccountExtractResponse> bankTransactions;
    TransactionAdapter transactionAdapter;
    RecyclerView recyclerView;

    private TransactionRepository transactionRepository = TransactionRepository.getInstance();
    public static SharedPreferences sharedPreferences = HomeActivity.sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_extract);

        recyclerView =findViewById(R.id.bt_ricycler_view);
        bankTransactions = new ArrayList<>();
        transactionAdapter = new TransactionAdapter(this, bankTransactions);

        recyclerView.setAdapter(transactionAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onResume() {
        super.onResume();

            transactionRepository.accountExtract(
                    sharedPreferences.getString("cpf", ""),
                    sharedPreferences.getString("pws", ""),
                    new RequestResult() {
                        @Override
                        public <T> void successResult(T object) {
                            bankTransactions = (List<AccountExtractResponse>) object;
                            transactionAdapter.setBankTransactions(bankTransactions);
                            recyclerView.getAdapter().notifyItemInserted(bankTransactions.size());

                        }

                        @Override
                        public void errorResult(String message) {

                        }
                    }
            );

    }
}