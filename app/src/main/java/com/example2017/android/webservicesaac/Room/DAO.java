package com.example2017.android.webservicesaac.Room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.icu.text.Replaceable;

import java.util.Date;


/**
 * Created by M7moud on 28-Mar-19.
 */
@Dao
public interface DAO {

    @Insert
    void add(User user);

    @Query("SELECT * FROM user WHERE login = :userLogin")
    LiveData<User> load(String userLogin);

    @Query("SELECT * FROM user WHERE login = :userLogin AND lastRefresh > :lastRefreshMax LIMIT 1")
    User hasUser(String userLogin, Date lastRefreshMax);
}
