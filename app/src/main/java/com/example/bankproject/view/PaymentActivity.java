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
import com.example.bankproject.dto.request.PaymentRequest;
import com.example.bankproject.repository.TransactionRepository;
import com.example.bankproject.service.RequestResult;

public class PaymentActivity extends AppCompatActivity {

  EditText billetNumber;
  EditText billetValue;

  SharedPreferences sharedPreferences = HomeActivity.sharedPreferences;

  TransactionRepository transactionRepository = TransactionRepository.getInstance();

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.payment);
    
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setTitle("Pagamentos");

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);

    billetNumber = findViewById(R.id.number_billet_page_payment);
    billetValue = findViewById(R.id.value_page_payment);
  }

  public void pay(View view) {
    transactionRepository.payment(
        sharedPreferences.getString("code", ""),
        sharedPreferences.getString("cpf", ""),
        sharedPreferences.getString("pws", ""),
        new PaymentRequest(billetNumber.getText().toString(), billetValue.getText().toString()),
        new RequestResult() {
          @Override
          public <T> void successResult(T object) {
            Toast.makeText(
                    PaymentActivity.this, "Pagamento realizado com sucesso!", Toast.LENGTH_LONG)
                .show();
            finish();
          }

          @Override
          public void errorResult(String message) {
            Toast.makeText(
                    PaymentActivity.this,
                    "Não foi possível finalizar a operação! :(",
                    Toast.LENGTH_LONG)
                .show();
          }
        });
  }
}
