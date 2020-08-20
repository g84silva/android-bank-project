package com.example.bankproject.Services;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://newbank-backend.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public UserService getUserService() {
        return retrofit.create(UserService.class);
    }

    public BankAccountService getBankAccountService() {
        return retrofit.create(BankAccountService.class);
    }

    public BankTransactionService getBankTransactionService() {
        return  retrofit.create(BankTransactionService.class);
    }


}
