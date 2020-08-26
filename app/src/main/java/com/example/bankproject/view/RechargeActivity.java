package com.example.bankproject.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.bankproject.R;
import com.example.bankproject.dto.request.DepositRequest;
import com.example.bankproject.repository.TransactionRepository;
import com.example.bankproject.service.RequestResult;

public class RechargeActivity extends AppCompatActivity {

  EditText value;

  TransactionRepository transactionRepository = TransactionRepository.getInstance();
  SharedPreferences sharedPreferences = HomeActivity.sharedPreferences;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.recharge);
    
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setTitle("Recarregar");

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
  }

  public void recharge(View view) {

    value = findViewById(R.id.value_page_recharge);

    transactionRepository.deposit(
        sharedPreferences.getString("code", ""),
        sharedPreferences.getString("cpf", ""),
        sharedPreferences.getString("pws", ""),
        new DepositRequest(Double.valueOf(value.getText().toString())),
        new RequestResult() {
          @Override
          public <T> void successResult(T object) {
            Toast.makeText(
                    RechargeActivity.this, String.valueOf(object), Toast.LENGTH_LONG)
                .show();
            finish();
          }

          @Override
          public void errorResult(String message) {
            Toast.makeText(
                    RechargeActivity.this,
                    "Não foi possível finalizar a operação! :(" + message,
                    Toast.LENGTH_LONG)
                .show();
          }
        });
  }
}
