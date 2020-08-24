package com.example.bankproject.Repository;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.example.bankproject.DAO.AppDatabase;
import com.example.bankproject.Model.User;
import com.example.bankproject.Model.UserRequest;
import com.example.bankproject.Services.RequestResult;
import com.example.bankproject.Services.RetrofitConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private AppDatabase database;

    public UserRepository(Context context) {
        this(AppDatabase.getInstance(context));
    }

    private UserRepository(AppDatabase instance) {
        this.database = instance;
    }

    private void insert(List<User> users) {
        database.userDAO().insertAllDAO(users);
    }

    private List<User> users;
    TextView textView;
    User user;

    public void getAllUsers(String cpf, final RequestResult requestResult) {

        Call<List<User>> call = new RetrofitConfig().getUserService().getAllUsers(cpf);

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    users = response.body();
                    UserRepository.this.insert(users);
                    requestResult.successResult(users);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                requestResult.errorResult(t.getMessage());
            }
        });
    }

    public void findByUser(String cpf, String pws) {

        Call<User> call = new RetrofitConfig().getUserService().findByUser(cpf, pws);

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

    public User addUser(UserRequest userRequest) {

        Call<User> call = new RetrofitConfig().getUserService().addUser(new UserRequest());

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

    public void updateUser(User user) {

        Call<User> call = new RetrofitConfig().getUserService().updateUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }

    public User getUserProfile(final UserRequest userRequest, final RequestResult result) {

        Call<User> call = new RetrofitConfig().getUserService().addUser(userRequest);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                   user = response.body();
                   database.userDAO().insertUSerDAO(user);
                   result.successResult(user);
                    Log.i(">>>Login", "Sucesso");

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                result.errorResult(t.getMessage());
            }
        });

        return user;
    }
}
