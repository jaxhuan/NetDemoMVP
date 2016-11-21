package com.skyzone.netdemomvp.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Skyzone on 11/21/2016.
 */
public class DateUtil {

    public static boolean isSameDay(Date date0, Date date1) {
        Calendar calendar0 = Calendar.getInstance();
        calendar0.setTime(date0);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        return calendar0.compareTo(calendar1) == 0 ? true : false;
    }
}
