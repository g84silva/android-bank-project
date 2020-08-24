package com.example.bankproject.dto.response;

import com.example.bankproject.model.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {
  private String message;
  private Account account;
}
