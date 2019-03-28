package com.example2017.android.webservicesaac.Room;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by M7moud on 28-Mar-19.
 */
public interface WebServices {


@GET("/users/{user}")
Call<User> getUser(@Path("user") String userId);

}
