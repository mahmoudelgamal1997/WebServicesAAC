package com.example2017.android.webservicesaac.Room;

import android.arch.persistence.room.TypeConverter;

import java.sql.Date;

/**
 * Created by M7moud on 28-Mar-19.
 */
public class DateConvertor {

    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
