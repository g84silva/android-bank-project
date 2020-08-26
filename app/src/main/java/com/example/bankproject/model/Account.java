package com.example.bankproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties({"createdAt", "updatedAt", "__v"})
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {

  private String _id;
  private String bank_branch;
  private String code;
  private String user;
  private Double account_balance;
  private int status;
}
