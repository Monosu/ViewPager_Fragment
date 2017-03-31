package com.example.linxi.viewpager_fragment.util;


import com.example.linxi.viewpager_fragment.metadata.ServiceRespHeader;

public class DataParserHelper {
    public static String parser(Object obj) {
        return JasonParser.parser(obj);
    }

    public static void reverseParser(String value, ServiceRespHeader respHeader){
        JasonParser.reverseParser(value, respHeader);
    }

    public static Object reverseParser(String value, Class clazz) {
        return JasonParser.reverseParser(value, clazz);
    }

    public static String getBody(String value) {
        return JasonParser.getBody(value);
    }

    public static String getHeader(String value) {
        return JasonParser.getHeader(value);
    }
}
