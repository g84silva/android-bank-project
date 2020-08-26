package com.example.bankproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransferRequest {

  private String origem;
  private String destino;
  private double amount;
}
