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
}
