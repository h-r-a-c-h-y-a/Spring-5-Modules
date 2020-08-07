package com.gitc.mvc_demo.util;

public class StringUtils {

    public static boolean isLong(String number){
        try {
            Long.parseLong(number.strip());
        }catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
