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

  public String get_id() {
    return _id;
  }

  public void set_id(String _id) {
    this._id = _id;
  }

  public String getBank_branch() {
    return bank_branch;
  }

  public void setBank_branch(String bank_branch) {
    this.bank_branch = bank_branch;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public Double getAccount_balance() {
    return account_balance;
  }

  public void setAccount_balance(Double account_balance) {
    this.account_balance = account_balance;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }
}
