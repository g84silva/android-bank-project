package com.example.bankproject.Services;

import com.example.bankproject.Model.BankAccount;
import com.example.bankproject.Model.BankTransation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BankTransactionService {

    @POST("transaction/pagamento")
    Call<BankTransation> slipPay(@Body BankTransation bankTransation);

    @POST("transaction/transferencia")
    Call<BankTransation> transference(@Body BankTransation bankTransation);

    @POST("transaction/deposito")
    Call<BankTransation> deposit(@Body BankTransation bankTransation);

    @GET("transaction/getByUser/{bank_account}")
    Call<List<BankTransation>> accountExtract(@Path("bank_account") BankAccount bank_account);
}
