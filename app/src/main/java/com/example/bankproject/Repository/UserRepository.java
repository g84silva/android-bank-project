package com.example.bankproject.Repository;

import android.widget.TextView;
import android.widget.Toast;

import com.example.bankproject.MainActivity;
import com.example.bankproject.Model.User;
import com.example.bankproject.Services.RetrofitConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private List<User> users;
    TextView textView;
    User user;

    public void getAllUsers() {
        Call<List<User>> call = new RetrofitConfig().getUserService().getAllUsers("cpf");

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    users = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }

    public void findByUser() {
        Call<User> call = new RetrofitConfig().getUserService().findByUser("cpf", "pws");

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    user = response.body();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }

    public User addUser() {
        user = new User();

        Call<User> call = new RetrofitConfig().getUserService().addUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    user = response.body();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
        return user;
    }

    public void updateUser() {
        user = new User();

        Call<User> call = new RetrofitConfig().getUserService().updateUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    user = response.body();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }
}
