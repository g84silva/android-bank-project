package com.example.bankproject.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bankproject.R;
import com.example.bankproject.model.User;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

  TextView test;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.home);

    test = findViewById(R.id.balance_view);

    User user = (User) Objects.requireNonNull(getIntent().getExtras()).get(LoginActivity.USER_LOGIN);

    test.setText(user.getName());
  }
}
