package com.khoders.smartchurch.utils;

import java.util.UUID;

public class SpringUtils {
    public static UUID stringToUUID(String stringName){
        return UUID.fromString(stringName);
    }
    public static String UUIDtoString(String stringName){
        return stringName.toString();
    }
}
