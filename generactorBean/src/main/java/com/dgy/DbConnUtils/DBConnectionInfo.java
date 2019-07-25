package com.dgy.DbConnUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Date: 2019/7/25
 * Time: 11:08
 * Author: vincent-Dou
 * Description：
 */
public class DBConnectionInfo {
    public DBConnectionInfo() {
    }

    /**
     * 加载配置文件
     * @return
     */
    public static Properties getProperties(){
        Properties properties = new Properties();
        InputStream resourceAsStream = DBConnectionInfo.class.getClassLoader().getResourceAsStream("generactor.properties");
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * 获取连接信息
     * @return
     */
    public static Connection getConnection(){
        Properties properties = getProperties();
        Connection connection = null;
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        String user = properties.getProperty("username");
        String password = properties.getProperty("password");
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 获取输出bean的路径
     * @return
     */
    public static String getOutFilePath(){
        Properties properties = getProperties();
        return properties.getProperty("soutPath");
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
        System.out.println(getOutFilePath());
    }
}
