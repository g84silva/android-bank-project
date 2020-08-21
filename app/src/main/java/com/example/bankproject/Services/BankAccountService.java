package com.example.bankproject.Services;

import com.example.bankproject.Model.BankAccount;
import com.example.bankproject.Model.BankAccountRequest;
import com.example.bankproject.Model.BankAccountResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface BankAccountService {


    @POST("accounts")
    Call<BankAccount> addAccount(@Header("cpf") String cpf,
                                 @Header("pws") String pws,
                                 @Body BankAccountRequest bankAccountRequest);

    @GET("accounts")
    Call<BankAccount> getAccountsByUser(@Header("cpf") String cpf,
                                        @Header("pws") String pws);

    @GET("getAllAccounts")
    Call<List<BankAccountResponse>> getAllAccounts(@Header("cpf") String cpf,
                                                   @Header("pws") String pws);

    @PUT("accounts")
    Call<BankAccount> updateAccounts(@Header("cpf") String cpf,
                                     @Header("pws") String pws,
                                     @Body int status);
}
