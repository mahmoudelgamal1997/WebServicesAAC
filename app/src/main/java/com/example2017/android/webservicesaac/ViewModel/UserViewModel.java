package com.example2017.android.webservicesaac.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example2017.android.webservicesaac.WebService.RetrofitClass;
import com.example2017.android.webservicesaac.model.UserData;

import java.util.ArrayList;

import retrofit2.Response;

/**
 * Created by M7moud on 29-Mar-19.
 */
public class UserViewModel extends ViewModel {
    private MutableLiveData<Response<ArrayList<UserData>>> mutableLiveData;
    private RetrofitClass retrofitClass = new RetrofitClass();




    public MutableLiveData<Response<ArrayList<UserData>>> getLiveDataVal(){

        if(mutableLiveData == null)
        {
            mutableLiveData = retrofitClass.getLiveData();
        }

        return mutableLiveData;
    }
}
