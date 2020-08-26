package com.example.bankproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class AccountRequest {

  private String cpf;
  private int account_balance;
  private int status;

  public AccountRequest() {
  }

  public AccountRequest(String cpf, int account_balance, int status) {
    this.cpf = cpf;
    this.account_balance = account_balance;
    this.status = status;
  }


}
