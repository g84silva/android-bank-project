package com.example.bankproject.service;

import com.example.bankproject.dto.request.PaymentRequest;
import com.example.bankproject.dto.request.TransferRequest;
import com.example.bankproject.dto.response.AccountExtractResponse;
import com.example.bankproject.dto.response.PaymentResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface TransactionService {

  @POST("transaction/pagamento")
  Call<PaymentResponse> payment(
      @Header("account") String account,
      @Header("cpf") String cpf,
      @Header("pws") String pws,
      @Body PaymentRequest paymentRequest);

  @POST("transaction/transferencia")
  Call<Void> transference(
      @Header("cpf") String cpf, @Header("pws") String pws, @Body TransferRequest transferRequest);

  @POST("transaction/deposito")
  Call<Void> deposit(
      @Header("account") String account,
      @Header("cpf") String cpf,
      @Header("pws") String pws,
      @Body String amount);

  @GET("transaction/getByUser")
  Call<List<AccountExtractResponse>> accountExtract(
      @Header("cpf") String cpf, @Header("pws") String pws);
}
