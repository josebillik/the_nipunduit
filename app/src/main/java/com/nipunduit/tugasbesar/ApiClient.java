package com.nipunduit.tugasbesar;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiClient {
    @POST("register.php")
    @FormUrlEncoded
    Call<UserDAO> registerUser(
            @Field("name") String nama,
            @Field("email") String email,
            @Field("phone") String phone,
            @Field("password") String password
    );

    @POST("login.php")
    @FormUrlEncoded
    Call<UserDAO> loginUser(
            @Field("email") String email,
            @Field("password") String password
    );
}
