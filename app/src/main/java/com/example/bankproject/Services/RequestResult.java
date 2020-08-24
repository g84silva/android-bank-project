package com.example.bankproject.Services;

public interface RequestResult {
    <T> void successResult(T clazz);
    void errorResult(String message);
}
