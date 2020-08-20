package com.example.bankproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"createdAt" , "updatedAt" , "__v"})
public class BankAccount {

    private String _id;
    private String bank_brench;
    private String code;
    private int account_balance;
    private int status;
    private User user;

    public BankAccount() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getBank_brench() {
        return bank_brench;
    }

    public void setBank_brench(String bank_brench) {
        this.bank_brench = bank_brench;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(int account_balance) {
        this.account_balance = account_balance;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
