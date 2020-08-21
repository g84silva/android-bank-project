package com.example.bankproject.Model;

public class BankAccountRequest {

    private String cpf;
    private int account_balance;
    private int status;

    public BankAccountRequest() {
    }

    public BankAccountRequest(String cpf, int account_balance, int status) {
        this.cpf = cpf;
        this.account_balance = account_balance;
        this.status = status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
}
