package com.example.bankproject.service;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

  private Retrofit retrofit;

  public RetrofitConfig() {

    OkHttpClient okHttpClient =
        new OkHttpClient()
            .newBuilder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build();

    this.retrofit =
        new Retrofit.Builder()
            .baseUrl("https://newbank-backend.herokuapp.com/")
            .client(okHttpClient)
            .addConverterFactory(JacksonConverterFactory.create())
            .build();
  }

  public UserService getUserService() {
    return retrofit.create(UserService.class);
  }

  public AccountService getBankAccountService() {
    return retrofit.create(AccountService.class);
  }

  public TransactionService getTransactionService() {
    return retrofit.create(TransactionService.class);
  }
}
