package com.example.bankproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class UserRequest {

  private String cpf;
  private String name;
  private String avatar;
  private String telefone;
  private String pws;

  public UserRequest() {
  }

  public UserRequest(String toString, String toString1, String s, String toString2, String toString3) {
  }
}
