package com.example.bankproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class UpdateAccountRequest {
  private int status;

  public UpdateAccountRequest() {
  }

  public UpdateAccountRequest(int status) {
    this.status = status;
  }
}
