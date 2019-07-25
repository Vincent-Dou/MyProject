package com.dgy.table;

import com.dgy.DbConnUtils.DBConnectionInfo;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Date: 2019/7/25
 * Time: 11:49
 * Author: vincent-Dou
 * Description：
 */
public class Table {

    static Connection connection = DBConnectionInfo.getConnection();


    /**
     * 查询一个表的所有列信息
     * @param tablename
     * @return
     */
    public static Map<String, String> getCloumInfomation(String tablename){
        Map<String, String> cloumInfoMap = new HashMap<String, String>();
        PreparedStatement preparedStatement = null;
        String sql = "select * from "+tablename;
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSetMetaData resultSetMetaData = preparedStatement.getMetaData();
            for (int i = 0; i < resultSetMetaData.getColumnCount(); i++){
                cloumInfoMap.put(resultSetMetaData.getColumnName(i + 1), resultSetMetaData.getColumnTypeName(i + 1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cloumInfoMap;
    }


    /**
     * 查询所有的表名
     * @return
     */
    public static List<String> getAllTablesName(){
        Connection connection = DBConnectionInfo.getConnection();
        List<String> tablesName = new LinkedList<String>();
        String sql = "show tables";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                tablesName.add(statement.getResultSet().getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tablesName;
//        try {
//            DatabaseMetaData metaData = connection.getMetaData();
//            ResultSet resultSet = metaData.getTables(null, null, "%", new String[] {"TABLE"});
//            while (resultSet.next()){
//                tablesName.add(resultSet.getString(3));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return tablesName;
    }

    public static void main(String[] args) {
        System.out.println(getCloumInfomation("tab_route"));
//        System.out.println(getAllTablesName());
    }
}
