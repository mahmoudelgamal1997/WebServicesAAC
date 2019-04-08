package com.example2017.android.webservicesaac.WebService;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example2017.android.webservicesaac.model.UserData;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/***
 * Created by M7moud on 29-Mar-19.
 */
public class RetrofitClass {


    public static Retrofit retrofit;
    public static Retrofit getRetrofit() {

        if (retrofit==null){

            retrofit =new Retrofit.Builder().baseUrl(APIServices.baseURL)
                    .addConverterFactory(GsonConverterFactory
                            .create(new Gson()))
                    .build();
        }
        return retrofit ;
    }

    public static APIServices getAPIServices(){

        return  getRetrofit()
                .create(APIServices.class);
    }



    public MutableLiveData <Response<ArrayList<UserData>>> getLiveData(){

        final MutableLiveData<Response<ArrayList<UserData>>> allDataLive = new MutableLiveData<>();

        APIServices services=RetrofitClass.getAPIServices();
        services.method().enqueue(new Callback<ArrayList<UserData>>() {
            @Override
            public void onResponse(Call<ArrayList<UserData>> call, Response<ArrayList<UserData>> response)
            {

                allDataLive.setValue(response);

            }

            @Override
            public void onFailure(Call<ArrayList<UserData>> call, Throwable throwable) {

                Log.e("error",throwable.getMessage());
            }
        });
        return allDataLive;
    }


}
