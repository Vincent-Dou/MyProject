package com.dgy.io;

import java.io.InputStream;

/**
 * Date: 2019/7/24
 * Time: 13:45
 * Author: vincent-Dou
 * Description：
 */
public class Resources {
    public static InputStream getResourcesAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
