package com.example.linxi.viewpager_fragment.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.linxi.viewpager_fragment.metadata.ServiceRespHeader;



/**
 * Created by linxi on 2017/3/29.
 */

public class JasonParser {
    public static void reverseParser(String value, ServiceRespHeader respHeader){
        JSONObject jsonObject=JSONObject.parseObject(value);
        /**
         * value转为jsonObject
         *   {
             "service": {
             "body": {},
             "head": {
                    "returnCode": 0,
                    "returnMsg": "成功",
                    "subCode": xxxxx,
                    "subMsg": "子业务错误码相关描述"
                        }
                    }
            }
         */
        if (!jsonObject.containsKey("service"))
            return;
        jsonObject=jsonObject.getJSONObject("service");
        if (null==jsonObject)
            return;

        String headerValue=jsonObject.getString("head");
        ServiceRespHeader tmp= JSON.parseObject(headerValue,ServiceRespHeader.class);
        respHeader.copy(tmp);//为什么要拷贝？

    }

    public static Object reverseParser(String value,Class clazz){
        return JSON.toJavaObject(JSON.parseObject(value),clazz);
    }

    public static String getBody(String value){
        JSONObject jsonObject=JSON.parseObject(value);
        jsonObject=jsonObject.getJSONObject("service");
        return jsonObject.getString("body");
    }

    public static String getHeader(String value){
        JSONObject jsonObject=JSONObject.parseObject(value);
        jsonObject=jsonObject.getJSONObject("service");
        return jsonObject.getString("head");

    }

    public static String parser(Object obj){
        return JSON.toJSONString(obj);
    }


}
