package com.example.bankproject.Services;

import com.example.bankproject.Model.BankAccount;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface BankAccountService {

    @Headers("Content-Type : application/json")
    @POST("accounts")
    Call<BankAccount> addAccount(@Body BankAccount bankAccount);

    @GET("accounts")
    Call<List<BankAccount>> getAccountsByUser(@Header("cpf") String cpf);

    @GET("getAllAccounts")
    Call<List<BankAccount>> getAllAccounts(@Header("cpf") String cpf);

    @PUT("transaction/{code}")
    Call<BankAccount> UpdateAccounts(@Path("code") String code, @Body BankAccount bankAccount);
}
