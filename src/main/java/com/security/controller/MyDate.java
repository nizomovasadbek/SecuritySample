package com.security.controller;

import com.security.model.User;

import java.util.Calendar;
import java.util.Date;

public class MyDate {
    private static final int EXPIRATION = 60*24;

    public Date calculateExpiryDate(){
        Calendar cal = Calendar.getInstance();

        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, MyDate.EXPIRATION);

        return new Date(cal.getTime().getTime());
    }

    public static boolean isExpired(User user){
        boolean exp;
        Date d1 = new Date();
        Date d2 = user.getExpiryDate();
        if(d2.getYear() >= d1.getYear() &&
        d2.getMonth() >= d1.getMonth() && d2.getDate() >= d1.getDate() &&
        d2.getHours() >= d1.getHours() && d2.getMinutes() >= d1.getMinutes()
        && d2.getSeconds() >= d1.getSeconds()){
            exp = false;
        } else exp = true;
        return exp;
    }
}
