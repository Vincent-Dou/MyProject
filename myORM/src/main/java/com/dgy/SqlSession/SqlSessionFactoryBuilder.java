package com.dgy.SqlSession;

import com.dgy.config.Configuration;
import com.dgy.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * Date: 2019/7/24
 * Time: 13:49
 * Author: vincent-Dou
 * Description：
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream configInputStream){
        Configuration configuration = XMLConfigBuilder.loadConfiguration(configInputStream);
        return new SqlSessionFactoryImpl(configuration);
    }
}
