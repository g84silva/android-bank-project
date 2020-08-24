package com.example.bankproject.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bankproject.R;
import com.example.bankproject.model.User;
import com.example.bankproject.repository.UserRepository;
import com.example.bankproject.service.RequestResult;

public class LoginActivity extends AppCompatActivity {

    public static String USER_LOGIN = "userLogin";

  private EditText cpf;
  private EditText pws;
  private UserRepository userRepository = UserRepository.getInstance();

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login);

    cpf = findViewById(R.id.cpf_login);
    pws = findViewById(R.id.password_login);
    Button loginButton = findViewById(R.id.button_login);

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
                  }

                  @Override
                  public void errorResult(String message) {
                    Toast.makeText(LoginActivity.this, "Dados incorretos!", Toast.LENGTH_LONG)
                        .show();
                  }
                });
          }
        });
  }
}
