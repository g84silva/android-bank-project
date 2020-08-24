package com.example.bankproject.service;

import com.example.bankproject.dto.request.AccountRequest;
import com.example.bankproject.dto.response.AccountResponse;
import com.example.bankproject.model.Account;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface AccountService {

  @POST("accounts")
  Call<Account> addAccount(
      @Header("cpf") String cpf, @Header("pws") String pws, @Body AccountRequest accountRequest);

  @GET("accounts")
  Call<AccountResponse> getAccountsByUser(@Header("cpf") String cpf, @Header("pws") String pws);

  @GET("getAllAccounts")
  Call<List<AccountResponse>> getAllAccounts(@Header("cpf") String cpf, @Header("pws") String pws);

  @PUT("accounts")
  Call<String> updateAccount(
      @Header("cpf") String cpf, @Header("pws") String pws, @Body int status);
}
