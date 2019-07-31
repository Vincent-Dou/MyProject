package com.dgy.utils;

import java.util.UUID;

/**
 * Date: 2019/7/31
 * Time: 14:05
 * Author: vincent-Dou
 * Description：产生UUID随机字符串工具类
 */
public class UUidUtil {
    public static String getUuid(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println(getUuid());
    }
}
