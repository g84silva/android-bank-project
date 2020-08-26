package com.example.bankproject.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bankproject.R;
import com.example.bankproject.dto.request.TransferRequest;
import com.example.bankproject.repository.TransactionRepository;
import com.example.bankproject.service.RequestResult;

public class TransferActivity extends AppCompatActivity {

  TransactionRepository transactionRepository = TransactionRepository.getInstance();
  SharedPreferences sharedPreferences = HomeActivity.sharedPreferences;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.transfer);
    
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setTitle("Transfer�ncia");

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);

    TextView bankBranch = findViewById(R.id.agency_page_transfer);
    bankBranch.setText(sharedPreferences.getString("code", ""));
  }

  public void transfer(View view) {

    EditText targetAccount = findViewById(R.id.account_destiny_page_transfer);
    EditText value = findViewById(R.id.value_page_transfer);

    transactionRepository.transference(
        sharedPreferences.getString("cpf", ""),
        sharedPreferences.getString("pws", ""),
        new TransferRequest(
            sharedPreferences.getString("code", ""),
            targetAccount.getText().toString(),
            Double.parseDouble(value.getText().toString())),
        new RequestResult() {
          @Override
          public <T> void successResult(T object) {
            Toast.makeText(
                    TransferActivity.this,
                    "Transferência realizada com sucesso!",
                    Toast.LENGTH_LONG)
                .show();
            finish();
          }

          @Override
          public void errorResult(String message) {
            Toast.makeText(
                    TransferActivity.this,
                    "Não foi possível finalizar a operação!:(",
                    Toast.LENGTH_LONG)
                .show();
          }
        });
  }
}
