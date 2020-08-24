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
@NoArgsConstructor
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

  public User(String _id, String name, String cpf, String pws, String avatar, String telefone) {
    this._id = _id;
    this.name = name;
    this.cpf = cpf;
    this.pws = pws;
    this.avatar = avatar;
    this.telefone = telefone;
  }
}
