package com.dgy.SqlSession;

import com.dgy.config.Configuration;

/**
 * Date: 2019/7/24
 * Time: 14:24
 * Author: vincent-Dou
 * Description：
 */
public class SqlSessionFactoryImpl implements SqlSessionFactory{

    private Configuration configuration;

    public SqlSessionFactoryImpl(Configuration configuration){
        this.configuration = configuration;
    }
    @Override
    public SqlSession openSession() {
        return new SqlSessionImpl(configuration);
    }
}
