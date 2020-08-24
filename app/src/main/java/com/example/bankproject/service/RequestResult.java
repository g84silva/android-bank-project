package com.example.bankproject.service;

public interface RequestResult {
  <T> void successResult(T object);

  void errorResult(String message);
}
