package com.example.bankproject.Repository;

import androidx.room.TypeConverter;

import com.example.bankproject.Model.BankAccount;
import com.facebook.stetho.json.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.List;

//public class Converters {
//
//    private static ObjectMapper objectMapper;
//    private static Object String;
//
//    @TypeConverter
//    public static String oBankToJson(BankAccount value) {
//        objectMapper = new ObjectMapper();
//        try {
//            return objectMapper.convertValue(String, value);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            return "{'Error':'Convert error'}";
//        }
//    }
//
//    @TypeConverter
//    public static oBank jsonToList(String value) {
//        objectMapper = new ObjectMapper();
//        String[] arr = new String;
//        try {
//            arr = objectMapper.readValue(value, String[].class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return new ArrayList<>(Arrays.asList(arr));
//    }
//
//}