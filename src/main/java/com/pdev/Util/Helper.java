package com.pdev.Util;

public class Helper {

    public static boolean isNullOrEmpty(String value){
        return value == null || value.isEmpty();
    }

    public static int toInt(String value){
        try{
            return Integer.parseInt(value);
        }catch (Exception e){}
        return 0;
    }

}
