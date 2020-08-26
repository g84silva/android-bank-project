package com.example.bankproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepositRequest {
    private String amount;
}
