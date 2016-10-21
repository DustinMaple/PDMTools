package com.maple.pdm.utils;

/**
 * Created by gjf on 2016/10/18.
 */
public class StringUtil {
    public static String capitalToUpperCase(String s){
        String capital = s.substring(0, 1).toUpperCase();
        String left = s.substring(1);
        return new StringBuffer(capital).append(left).toString();
    }
}
