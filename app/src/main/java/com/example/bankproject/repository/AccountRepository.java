package com.example.bankproject.repository;

import com.example.bankproject.dto.request.AccountRequest;
import com.example.bankproject.dto.request.UpdateAccountRequest;
import com.example.bankproject.model.Account;
import com.example.bankproject.service.RequestResult;
import com.example.bankproject.service.RetrofitConfig;

import java.util.List;

import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountRepository {

  private static AccountRepository accountRepository;

  private AccountRepository() {}

  public static AccountRepository getInstance() {
    if (accountRepository == null) {
      accountRepository = new AccountRepository();
    }
    return accountRepository;
  }

  public void addAccount(
      String cpf, String pws, AccountRequest accountRequest, final RequestResult result) {

    Call<Void> call =
        new RetrofitConfig().getBankAccountService().addAccount(cpf, pws, accountRequest);

    call.enqueue(
        new Callback<Void>() {
          @Override
          public void onResponse(Call<Void> call, Response<Void> response) {
            if (response.isSuccessful()) {
              result.successResult(response.body());
            }
          }

          @Override
          public void onFailure(Call<Void> call, Throwable t) {
            result.errorResult(t.getMessage());
          }
        });
  }

  public void getAccountsByUser(String cpf, String pws, final RequestResult result) {

    Call<Account> call =
        new RetrofitConfig().getBankAccountService().getAccountsByUser(cpf, pws);

    call.enqueue(
        new Callback<Account>() {
          @Override
          public void onResponse(Call<Account> call, Response<Account> response) {
            if (response.isSuccessful()) {
              result.successResult(response.body());
            }
          }

          @Override
          public void onFailure(Call<Account> call, Throwable t) {
            result.errorResult(t.getMessage());
          }
        });
  }

  public void getAllAccounts(String cpf, String pws, final RequestResult result) {

    Call<List<Account>> call =
        new RetrofitConfig().getBankAccountService().getAllAccounts(cpf, pws);

    call.enqueue(
        new Callback<List<Account>>() {
          @Override
          public void onResponse(
              Call<List<Account>> call, Response<List<Account>> response) {
            if (response.isSuccessful()) {
              result.successResult(response.body());
            }
          }

          @Override
          public void onFailure(Call<List<Account>> call, Throwable t) {
            result.errorResult(t.getMessage());
          }
        });
  }

  public void updateAccount(String cpf, String pws, UpdateAccountRequest updateAccountRequest, final RequestResult result) {

    Call<Void> call =
        new RetrofitConfig().getBankAccountService().updateAccount(cpf, pws, updateAccountRequest);

    call.enqueue(
        new Callback<Void>() {
          @SneakyThrows
          @Override
          public void onResponse(Call<Void> call, Response<Void> response) {
            if (response.isSuccessful()) {
              result.successResult(response.body());
            } else {
                result.errorResult(response.errorBody().string());
            }
          }

          @Override
          public void onFailure(Call<Void> call, Throwable t) {
            result.errorResult(t.getMessage());
          }
        });
  }
}
