package com.example.lms;

import java.util.Date;

public class CommonMethod {

    public static String dateToString(Date date){
        return date.getYear() +""  + date.getMonth() + date.getDay() ;
    }
}
