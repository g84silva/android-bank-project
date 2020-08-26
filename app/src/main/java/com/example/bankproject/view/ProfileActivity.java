package com.example.bankproject.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bankproject.R;

public class ProfileActivity extends AppCompatActivity {

  SharedPreferences sharedPreferences = HomeActivity.sharedPreferences;

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
}
