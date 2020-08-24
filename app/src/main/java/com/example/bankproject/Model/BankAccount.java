package com.example.bankproject.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@Entity(tableName = "ContaBancaria")
@JsonIgnoreProperties({"createdAt" , "updatedAt" , "__v"})
public class BankAccount implements Serializable {
    @PrimaryKey(autoGenerate = true) private int acid;
    @ColumnInfo(name = "accServer_id")
    private String _id;
    private String bank_branch;
    private String code;
    private int account_balance;
    private int status;
    private String cpf;

    public int getAcid() {
        return acid;
    }

    public void setAcid(int acid) {
        this.acid = acid;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

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

    @Override
    public String toString() {
        return "BankAccount{" +
                "acid=" + acid +
                ", _id='" + _id + '\'' +
                ", bank_branch='" + bank_branch + '\'' +
                ", code='" + code + '\'' +
                ", account_balance=" + account_balance +
                ", status=" + status +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
