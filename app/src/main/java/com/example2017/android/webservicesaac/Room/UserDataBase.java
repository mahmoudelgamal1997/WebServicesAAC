package com.example2017.android.webservicesaac.Room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

/**
 * Created by M7moud on 28-Mar-19.
 */
@Database(entities = {User.class},version = 1)
@TypeConverters(DateConvertor.class)
public abstract class UserDataBase extends RoomDatabase {

    //--- SINGLETON ---
    public static volatile UserDataBase instance;


    // --- DAO ---
    public abstract DAO userDao();
}
