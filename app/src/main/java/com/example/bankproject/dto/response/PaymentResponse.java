package com.example.bankproject.dto.response;

import com.example.bankproject.model.Account;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"createdAt", "updatedAt", "__v"})
public class PaymentResponse {
  private String mensagem;
  private Account account;
}
