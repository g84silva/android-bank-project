package com.example.bankproject.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.bankproject.R;
import com.example.bankproject.dto.request.AccountRequest;
import com.example.bankproject.dto.request.UserRequest;
import com.example.bankproject.repository.AccountRepository;
import com.example.bankproject.repository.UserRepository;
import com.example.bankproject.service.RequestResult;

public class RegisterActivity extends AppCompatActivity {

  EditText name;
  EditText cpf;
  EditText phone;
  EditText pws;

  UserRepository userRepository = UserRepository.getInstance();
  AccountRepository accountRepository = AccountRepository.getInstance();

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.register);
    
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setTitle("Cadastrar");

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);

    name = findViewById(R.id.name_page_register);
    cpf = findViewById(R.id.cpf_page_register);
    phone = findViewById(R.id.phone_page_register);
    pws = findViewById(R.id.password_page_register);
  }

  public void register(View view) {
    userRepository.addUser(
        new UserRequest(
            name.getText().toString(),
            cpf.getText().toString(),
           "",
            phone.getText().toString(),
            pws.getText().toString()),
        new RequestResult() {
          @Override
          public <T> void successResult(T object) {
            addAccount();
          }

          public void addAccount() {
            accountRepository.addAccount(
                cpf.getText().toString(),
                pws.getText().toString(),
                new AccountRequest(cpf.getText().toString(), 1, 1),
                new RequestResult() {
                  @Override
                  public <T> void successResult(T object) {
                    Toast.makeText(
                            RegisterActivity.this,
                            "Usuário cadastrado com sucesso!",
                            Toast.LENGTH_LONG)
                        .show();
                    finish();
                  }

                  @Override
                  public void errorResult(String message) {
                    name.setText(message);
                    Toast.makeText(
                            RegisterActivity.this,
                            "Não foi possível realizar a operação! :(" + message,
                            Toast.LENGTH_LONG)
                        .show();
                  }
                });
          }

          @Override
          public void errorResult(String message) {
            Toast.makeText(
                    RegisterActivity.this,
                    "Não foi possível realizar a operação! :(",
                    Toast.LENGTH_LONG)
                .show();
          }
        });
  }
}
