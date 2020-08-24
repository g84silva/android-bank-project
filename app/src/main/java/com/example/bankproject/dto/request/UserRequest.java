package com.example.bankproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {

  private String cpf;
  private String name;
  private String avatar;
  private String telefone;
  private String pws;
}
