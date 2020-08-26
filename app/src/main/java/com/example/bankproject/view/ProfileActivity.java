package com.example.bankproject.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bankproject.R;
import com.example.bankproject.dto.request.UpdateAccountRequest;
import com.example.bankproject.repository.AccountRepository;
import com.example.bankproject.service.RequestResult;

public class ProfileActivity extends AppCompatActivity {

  SharedPreferences sharedPreferences = HomeActivity.sharedPreferences;

  AccountRepository accountRepository = AccountRepository.getInstance();

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.profile);

    TextView username = findViewById(R.id.username_profile);
    TextView bankBranch = findViewById(R.id.branch_bank_profile);
    TextView accountNumber = findViewById(R.id.account_number_profile);
    TextView status = findViewById(R.id.account_stauts_profile);

    String statusDescription = "";
    switch (sharedPreferences.getString("status", "")) {
      case "1":
        statusDescription = "Ativa";
        break;
      case "2":
        statusDescription = "Inativa";
        break;
      case "3":
        statusDescription = "Cancelada";
        break;
    }

    username.setText(sharedPreferences.getString("username", ""));
    bankBranch.setText("Agência: " + sharedPreferences.getString("bankBranch", ""));
    accountNumber.setText("Conta: " + sharedPreferences.getString("code", ""));
    status.setText("Status: " + statusDescription);
  }

  public void logout(View view) {
    sharedPreferences.edit().clear().apply();
    Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
    startActivity(intent);
    finish();
  }

  public void closeAccount(View view) {
    if(!sharedPreferences.getString("status", "").equals("3")) {
      accountRepository.updateAccount(
              sharedPreferences.getString("cpf", ""),
              sharedPreferences.getString("pws", ""),
              new UpdateAccountRequest(3),
              new RequestResult() {
                @Override
                public <T> void successResult(T object) {
                  Toast.makeText(ProfileActivity.this, "Conta cancelada!", Toast.LENGTH_LONG).show();
                  Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                  startActivity(intent);
                  finish();
                }

                @Override
                public void errorResult(String message) {
                  Toast.makeText(ProfileActivity.this, "Não foi possível cancelar a conta!", Toast.LENGTH_LONG).show();
                }
              });
    } else {
      Toast.makeText(ProfileActivity.this, "Conta já cancelada", Toast.LENGTH_LONG).show();
    }

  }
}
