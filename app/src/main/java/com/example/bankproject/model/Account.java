package com.example.bankproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties({"createdAt", "updatedAt", "__v"})
public class Account {

  private String _id;
  private String bank_branch;
  private String code;
  private int account_balance;
  private int status;
  private String cpf;
}
