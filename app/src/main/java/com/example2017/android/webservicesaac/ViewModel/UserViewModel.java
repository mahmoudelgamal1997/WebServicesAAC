package com.example2017.android.webservicesaac.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import android.view.View;

import com.example2017.android.webservicesaac.WebService.RetrofitClass;
import com.example2017.android.webservicesaac.model.UserData;

/**
 * Created by M7moud on 29-Mar-19.
 */
public class UserViewModel extends ViewModel {


    private MutableLiveData<UserData> mutableLiveData;
    private RetrofitClass retrofitClass = new RetrofitClass();




    public MutableLiveData<UserData> getLiveDataVal(){

        if(mutableLiveData == null)
        {
            mutableLiveData = retrofitClass.getLiveData();
        }

        return mutableLiveData;
    }
}
