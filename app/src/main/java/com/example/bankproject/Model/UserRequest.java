package com.example.bankproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class UserRequest {

    private String cpf;
    private String name;
    private String avatar;
    private String telefone;
    private String pws;

    public UserRequest() {
    }

    public UserRequest(String cpf, String name, String avatar, String telefone, String pws) {
        this.cpf = cpf;
        this.name = name;
        this.avatar = avatar;
        this.telefone = telefone;
        this.pws = pws;
    }

    public UserRequest(String cpf, String name, String telefone, String pws) {
        this.cpf = cpf;
        this.name = name;
        this.telefone = telefone;
        this.pws = pws;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPws() {
        return pws;
    }

    public void setPws(String pws) {
        this.pws = pws;
    }
}
