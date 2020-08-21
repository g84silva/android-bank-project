package com.example.bankproject.Model;

public class BankTransaction {

    private String _id;
    private int source_transaction;
    private BankAccount bank_account;
    private int amount;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getSource_transaction() {
        return source_transaction;
    }

    public void setSource_transaction(int source_transaction) {
        this.source_transaction = source_transaction;
    }

    public BankAccount getBank_account() {
        return bank_account;
    }

    public void setBank_account(BankAccount bank_account) {
        this.bank_account = bank_account;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}