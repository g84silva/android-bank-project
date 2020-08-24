package com.example.bankproject.repository;

import com.example.bankproject.dto.request.PaymentRequest;
import com.example.bankproject.dto.request.TransferRequest;
import com.example.bankproject.dto.response.AccountExtractResponse;
import com.example.bankproject.dto.response.PaymentResponse;
import com.example.bankproject.service.RequestResult;
import com.example.bankproject.service.RetrofitConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TransactionRepository {

  public void payment(
      String account,
      String cpf,
      String pws,
      PaymentRequest paymentRequest,
      final RequestResult result) {
    Call<PaymentResponse> call =
        new RetrofitConfig().getTransactionService().payment(account, cpf, pws, paymentRequest);
    call.enqueue(
        new Callback<PaymentResponse>() {
          @SneakyThrows
          @Override
          public void onResponse(Call<PaymentResponse> call, Response<PaymentResponse> response) {
            if (response.isSuccessful()) {
              result.successResult(response.body().getMessage());
            } else {
              result.errorResult(response.errorBody().string());
            }
          }

          @Override
          public void onFailure(Call<PaymentResponse> call, Throwable t) {
            result.errorResult(t.getMessage());
          }
        });
  }

  public void transference(
      String cpf, String pws, TransferRequest transferRequest, final RequestResult result) {
    Call<Void> call =
        new RetrofitConfig().getTransactionService().transference(cpf, pws, transferRequest);
    call.enqueue(
        new Callback<Void>() {
          @Override
          public void onResponse(Call<Void> call, Response<Void> response) {
            String mensagem = null;
            if (response.isSuccessful()) {
              result.successResult("Transferência realizada com sucesso!");
            } else if (response.errorBody() != null) {
              try {
                mensagem = response.errorBody().string();
                result.errorResult(mensagem = new ObjectMapper().readValue(mensagem, String.class));
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
          }

          @Override
          public void onFailure(Call<Void> call, Throwable t) {
            result.errorResult(t.getMessage());
          }
        });
  }

  public void deposit(
      String account, String cpf, String pws, String amount, final RequestResult result) {
    Call<Void> call =
        new RetrofitConfig().getTransactionService().deposit(account, cpf, pws, amount);
    call.enqueue(
        new Callback<Void>() {
          @Override
          public void onResponse(Call<Void> call, Response<Void> response) {
            String mensagem = "";
            if (response.isSuccessful()) {
              result.successResult(mensagem = "Depósito realizado com sucesso!");
            } else {
              if (response.errorBody() != null) {
                try {
                  mensagem = response.errorBody().string();
                  result.errorResult(
                      mensagem = new ObjectMapper().readValue(mensagem, String.class));
                } catch (IOException e) {
                  e.printStackTrace();
                }
              }
            }
          }

          @Override
          public void onFailure(Call<Void> call, Throwable t) {
            result.errorResult(t.getMessage());
          }
        });
  }

  public void accountExtract(String cpf, String pws, final RequestResult result) {
    Call<List<AccountExtractResponse>> call =
        new RetrofitConfig().getTransactionService().accountExtract(cpf, pws);
    call.enqueue(
        new Callback<List<AccountExtractResponse>>() {
          @Override
          public void onResponse(
              Call<List<AccountExtractResponse>> call,
              Response<List<AccountExtractResponse>> response) {
            if (response.isSuccessful() && response.body() != null) {
              result.successResult(response.body());
            }
          }

          @Override
          public void onFailure(Call<List<AccountExtractResponse>> call, Throwable t) {
            result.errorResult(t.getMessage());
          }
        });
  }
}
