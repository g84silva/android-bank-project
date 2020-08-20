package com.example.bankproject.Services;

import com.example.bankproject.Model.BankAccount;
import com.example.bankproject.Model.BankTransaction;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BankTransactionService {

    @POST("transaction/pagamento")
    Call<BankTransaction> slipPay(@Body BankTransaction bankTransaction);

    @POST("transaction/transferencia")
    Call<BankTransaction> transference(@Body BankTransaction bankTransaction);

    @POST("transaction/deposito")
    Call<BankTransaction> deposit(@Body BankTransaction bankTransaction);

    @GET("transaction/getByUser/{bank_account}")
    Call<List<BankTransaction>> accountExtract(@Path("bank_account") BankAccount bank_account);
}
