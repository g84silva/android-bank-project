package com.example.bankproject.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(tableName = "Usuario")
@JsonIgnoreProperties({"createdAt", "updatedAt", "__v"})
@AllArgsConstructor

public class User implements Serializable {

  @PrimaryKey(autoGenerate = true)
  private int uid;

  @ColumnInfo(name = "server_id")
  private String _id;

  private String name;
  private String cpf;
  private String pws;
  private String avatar;
  private String telefone;

  public User() {
  }

  public User(String _id, String name, String cpf, String pws, String avatar, String telefone) {
    this._id = _id;
    this.name = name;
    this.cpf = cpf;
    this.pws = pws;
    this.avatar = avatar;
    this.telefone = telefone;
  }

  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

  public String get_id() {
    return _id;
  }

  public void set_id(String _id) {
    this._id = _id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getPws() {
    return pws;
  }

  public void setPws(String pws) {
    this.pws = pws;
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
}
