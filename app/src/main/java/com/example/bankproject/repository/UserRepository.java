package com.example.bankproject.repository;

import com.example.bankproject.dto.request.UserRequest;
import com.example.bankproject.model.User;
import com.example.bankproject.service.RequestResult;
import com.example.bankproject.service.RetrofitConfig;

import java.util.List;

import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

  private static UserRepository userRepository;

  private UserRepository() {}

  public static UserRepository getInstance() {
    if (userRepository == null) {
      userRepository = new UserRepository();
    }
    return userRepository;
  }

  public void getAllUsers(String cpf, final RequestResult result) {

    Call<List<User>> call = new RetrofitConfig().getUserService().getAllUsers(cpf);

    call.enqueue(
        new Callback<List<User>>() {
          @Override
          public void onResponse(Call<List<User>> call, Response<List<User>> response) {
            if (response.isSuccessful()) {
              result.successResult(response.body());
            }
          }

          @Override
          public void onFailure(Call<List<User>> call, Throwable t) {
            result.errorResult(t.getMessage());
          }
        });
  }

  public void findByUser(String cpf, String pws, final RequestResult result) {
    Call<User> call = new RetrofitConfig().getUserService().findByUser(cpf, pws);

    call.enqueue(
        new Callback<User>() {
          @SneakyThrows
          @Override
          public void onResponse(Call<User> call, Response<User> response) {
            if (response.isSuccessful()) {
              result.successResult(response.body());
            } else {
              result.errorResult(response.errorBody().toString());
            }
          }

          @Override
          public void onFailure(Call<User> call, Throwable t) {
            result.errorResult(t.getMessage());
          }
        });
  }

  public void addUser(UserRequest userRequest, final RequestResult result) {

    Call<User> call = new RetrofitConfig().getUserService().addUser(userRequest);

    call.enqueue(
        new Callback<User>() {
          @Override
          public void onResponse(Call<User> call, Response<User> response) {
            if (response.isSuccessful()) {
              result.successResult(response.body());
            }
          }

          @Override
          public void onFailure(Call<User> call, Throwable t) {
            result.errorResult(t.getMessage());
          }
        });
  }

  public void updateUser(User user, final RequestResult result) {

    Call<User> call = new RetrofitConfig().getUserService().updateUser(user);

    call.enqueue(
        new Callback<User>() {
          @Override
          public void onResponse(Call<User> call, Response<User> response) {
            if (response.isSuccessful()) {
              result.successResult(response.body());
            }
          }

          @Override
          public void onFailure(Call<User> call, Throwable t) {
            result.errorResult(t.getMessage());
          }
        });
  }
}
