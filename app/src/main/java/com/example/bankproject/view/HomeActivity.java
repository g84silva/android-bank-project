package com.example.bankproject.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankproject.R;
import com.example.bankproject.adapter.TransactionAdapter;
import com.example.bankproject.model.Account;
import com.example.bankproject.model.Transaction;
import com.example.bankproject.model.User;
import com.example.bankproject.repository.AccountRepository;
import com.example.bankproject.repository.TransactionRepository;
import com.example.bankproject.service.RequestResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

  public static final String USER_ACCOUNT = "userAccount";



  private TextView value;
  private TextView name;
  private TextView status;

  private AccountRepository accountRepository = AccountRepository.getInstance();
  public static SharedPreferences sharedPreferences;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.home);

    sharedPreferences = getSharedPreferences("shared", Context.MODE_PRIVATE);

    value = findViewById(R.id.value_available);
    name = findViewById(R.id.username_home);
    status = findViewById(R.id.account_status);

    ImageView profile = findViewById(R.id.arrow_to_profile);
    Button payment = findViewById(R.id.button_payment_home);
    Button transfer = findViewById(R.id.button_transfer_home);
    Button recharge = findViewById(R.id.button_recharge_home);

    value.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(HomeActivity.this, ExtractActivity.class);
            startActivity(intent);
        }
    });

    payment.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Intent intent = new Intent(HomeActivity.this, PaymentActivity.class);
            startActivity(intent);
          }
        });

    transfer.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Intent intent = new Intent(HomeActivity.this, TransferActivity.class);
            startActivity(intent);
          }
        });

    recharge.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Intent intent = new Intent(HomeActivity.this, RechargeActivity.class);
            startActivity(intent);
          }
        });

    profile.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(intent);
          }
        });
  }



    @Override
  protected void onResume() {
    super.onResume();
    final User user =
        (User) Objects.requireNonNull(getIntent().getExtras()).get(LoginActivity.USER_LOGIN);
    accountRepository.getAccountsByUser(
        user.getCpf(),
        user.getPws(),
        new RequestResult() {
          @Override
          public <T> void successResult(T object) {
            Account account = (Account) object;
            Intent intent = new Intent();
            intent.putExtra(USER_ACCOUNT, account);
            String statusDescription = "";
            switch (account.getStatus()) {
              case 1:
                statusDescription = "Ativa";
                break;
              case 2:
                statusDescription = "Inativa";
                break;
              case 3:
                statusDescription = "Cancelada";
                break;
            }

            sharedPreferences.edit().putString("username", user.getName()).apply();
            sharedPreferences.edit().putString("cpf", user.getCpf()).apply();
            sharedPreferences.edit().putString("pws", user.getPws()).apply();
            sharedPreferences.edit().putString("avatar", user.getAvatar()).apply();
            sharedPreferences.edit().putString("phone", user.getTelefone()).apply();
            sharedPreferences.edit().putString("bankBranch", account.getBank_branch()).apply();
            sharedPreferences.edit().putString("code", account.getCode()).apply();
            sharedPreferences
                .edit()
                .putString("status", (String.valueOf(account.getStatus())))
                .apply();

            String balance = String.format("%.2f", account.getAccount_balance()).replace(".", ",");
            name.setText("Boas vindas, " + user.getName().split(" ")[0] + "!");
            value.setText("R$" + balance);
            status.setText(statusDescription);
          }

          @Override
          public void errorResult(String message) {}
        });
  }
}
