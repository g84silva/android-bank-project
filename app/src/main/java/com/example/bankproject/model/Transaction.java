package com.example.bankproject.model;

import lombok.Data;

@Data
public class Transaction {

  private String _id;
  private int source_transaction;
  private Account bank_account;
  private int amount;
}
