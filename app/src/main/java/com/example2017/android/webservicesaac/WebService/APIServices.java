package com.example2017.android.webservicesaac.WebService;

import com.example2017.android.webservicesaac.model.UserData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by M7moud on 29-Mar-19.
 */
public interface APIServices {

    String baseURL="https://api.github.com/users/";

    @GET("mahmoudelgamal1997/repos")
    Call<ArrayList<UserData>> method();

}
