package com.example.bankproject.Services;

import com.example.bankproject.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface UserService {

    @GET("getAllUsers")
    Call<List<User>> getAllUsers(@Header("cpf") String cpf);

    @GET("users")
    Call<User> findByUser(@Header("cpf") String cpf,
                          @Header("pws") String pws);

    @POST("users")
    Call<User> addUser(@Body User user);

    @PUT("user/update")
    Call<User> updateUser(@Body User user);

}
