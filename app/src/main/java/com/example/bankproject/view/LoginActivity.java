package com.example.bankproject.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bankproject.R;
import com.example.bankproject.model.User;
import com.example.bankproject.repository.UserRepository;
import com.example.bankproject.service.RequestResult;

public class LoginActivity extends AppCompatActivity {

  public static final String USER_LOGIN = "userLogin";

  private EditText cpf;
  private EditText pws;
  private TextView register;
  private UserRepository userRepository = UserRepository.getInstance();

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login);

    cpf = findViewById(R.id.cpf_page_login);
    pws = findViewById(R.id.password_page_login);
    register = findViewById(R.id.register_page_login);
    Button loginButton = findViewById(R.id.button_page_login);

    loginButton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            userRepository.findByUser(
                cpf.getText().toString(),
                pws.getText().toString(),
                new RequestResult() {
                  @Override
                  public <T> void successResult(T object) {
                    Toast.makeText(
                            LoginActivity.this, "Login efetuado com sucesso!", Toast.LENGTH_LONG)
                        .show();
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra(USER_LOGIN, (User) object);
                    startActivity(intent);
                    finish();
                  }

                  @Override
                  public void errorResult(String message) {
                    Toast.makeText(LoginActivity.this, "Dados incorretos!", Toast.LENGTH_LONG)
                        .show();
                  }
                });
          }
        });

    register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        }
    });
  }
}
