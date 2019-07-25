package com.dgy;

import com.dgy.DbConnUtils.DBConnectionInfo;
import com.dgy.table.Table;
import com.dgy.utils.OutFile;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Date: 2019/7/25
 * Time: 14:24
 * Author: vincent-Dou
 * Description：
 */
public class Main {
    public static void main(String[] args) {
        String outPath = DBConnectionInfo.getOutFilePath();
        List<String> allTablesName = Table.getAllTablesName();
        List<Map<String, String>> tableInfoList = new LinkedList<>();
        for (String tableName : allTablesName){
            OutFile.outJavaBean(tableName, Table.getCloumInfomation(tableName));
        }
        System.out.println("生成完毕");
    }
}
