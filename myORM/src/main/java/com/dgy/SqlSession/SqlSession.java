package com.dgy.SqlSession;

/**
 * Date: 2019/7/24
 * Time: 13:53
 * Author: vincent-Dou
 * Description：
 */
public interface SqlSession {
    <T> T getMapper(Class<T> daoInterFaceClass);
    void close();
}
