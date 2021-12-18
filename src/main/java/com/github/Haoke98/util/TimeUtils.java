package com.github.Haoke98.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    public static String getDateTimeString(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        if (date == null) {
            date = new Date();
        }
        return df.format(date);
    }

    public static String getDateTimeStringWithSecond(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        if (date == null) {
            date = new Date();
        }
        return df.format(date);
    }
}
