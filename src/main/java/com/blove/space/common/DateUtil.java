package com.blove.space.common;

import java.util.Calendar;

public class DateUtil {



    public static long currentTimeLong(){
       return System.currentTimeMillis() / 1000L;
    }

    public static Integer currentTime(){
        Long timeStamp = currentTimeLong();
        return timeStamp.intValue();
    }




}
