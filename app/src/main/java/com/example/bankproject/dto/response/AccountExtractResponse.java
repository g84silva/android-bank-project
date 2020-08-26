package com.example.bankproject.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties({"_id", "updatedAt", "__v"})
@AllArgsConstructor
@NoArgsConstructor
public class AccountExtractResponse {
  private String[] bank_account;
  private int source_transaction;
  private double amount;
  private String createdAt;

  public String[] getBank_account() {
    return bank_account;
  }

  public void setBank_account(String[] bank_account) {
    this.bank_account = bank_account;
  }

  public int getSource_transaction() {
    return source_transaction;
  }

  public void setSource_transaction(int source_transaction) {
    this.source_transaction = source_transaction;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }
}
