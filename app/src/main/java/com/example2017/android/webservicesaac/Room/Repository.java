package com.example2017.android.webservicesaac.Room;

import android.app.Activity;
import android.app.Application;
import android.widget.Toast;

import com.example2017.android.webservicesaac.MainActivity;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executor;

import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by M7moud on 28-Mar-19.
 */
@Singleton
public class Repository {

    private static int FRESH_TIMEOUT_IN_MINUTES = 3;

    private final Executor executor;

    private final WebServices services;

    private final DAO userDao;

    public Repository(Executor executor, WebServices services, DAO dao) {
        this.executor = executor;
        this.services = services;
        this.userDao = dao;
    }


    private void refreshUser(final String userLogin) {
    executor.execute(new Runnable() {
        @Override
        public void run() {
            boolean userExists = (userDao.hasUser(userLogin, getMaxRefreshTime(new Date())) != null);
            // If user have to be updated
            if (!userExists) {


                final MainActivity m=new MainActivity();
                services.getUser(userLogin).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {

                        Toast.makeText(m.getApplicationContext(), "", Toast.LENGTH_SHORT).show();

                        User user=response.body();
                        user.setLastRefresh(new Date());
                        userDao.add(user);
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable throwable) {

                    }
                });
            }






        }
    });

        }



    private Date getMaxRefreshTime(Date currentDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.MINUTE, -FRESH_TIMEOUT_IN_MINUTES);
        return cal.getTime();
    }
    }
