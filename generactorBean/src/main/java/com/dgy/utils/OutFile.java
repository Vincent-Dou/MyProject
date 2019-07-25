package com.dgy.utils;

import com.dgy.DbConnUtils.DBConnectionInfo;
import com.dgy.table.Table;

import java.io.*;
import java.lang.annotation.Target;
import java.util.Iterator;
import java.util.Map;
/**
 * Date: 2019/7/25
 * Time: 12:59
 * Author: vincent-Dou
 * Description：
 */
public class OutFile {

    private static final String TAB ="    ";
    private static final String RN = "\r\n";

    /**
     * 此方法用于拼接并输出实体类
     * @param tableName
     * @param cloumInfomation
     */
    public static void outJavaBean(String tableName, Map<String, String> cloumInfomation){
        String outPath = DBConnectionInfo.getOutFilePath();
        System.out.println("================开始生成"+tableName+"=================");
        StringBuilder sb = new StringBuilder();
        sb.append(RN);
        sb.append(RN)
                .append("public ").append("class ").append(OutUtils.tableNameTOjava(tableName)+" ").append("{").append(RN);
        Iterator iterator = cloumInfomation.entrySet().iterator();
        sb.append(RN);
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
            sb.append(TAB).append("private ").append(OutUtils.sqlTypeToJavaType(entry.getValue())+" ").append(OutUtils.cloumNameTojava(entry.getKey())).append(";").append(RN);
        }
        sb.append(RN);
        Iterator iterator1 = cloumInfomation.entrySet().iterator();
        while (iterator1.hasNext()){
            Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator1.next();
            sb.append(TAB).append("public ").append(OutUtils.sqlTypeToJavaType(entry.getValue())+" ").append("get"+OutUtils.tableNameTOjava(entry.getKey())+"()").append(" {").append(RN);
            sb.append(TAB).append(TAB).append("return ").append("this.").append(entry.getKey()).append(";").append(RN);
            sb.append(TAB).append("}");
            sb.append(RN);
            sb.append(TAB).append("public ").append("void ").append("set"+OutUtils.tableNameTOjava(entry.getKey())+" ").append("("+OutUtils.sqlTypeToJavaType(entry.getValue())+" "+OutUtils.cloumNameTojava(entry.getKey()+")")).append("{").append(RN);
            sb.append(TAB).append(TAB).append("this.").append(OutUtils.cloumNameTojava(entry.getKey())+" = ").append(OutUtils.cloumNameTojava(entry.getKey())).append(";").append(RN);
            sb.append(TAB).append("}").append(RN);
        }
        sb.append("}");
        System.out.println(sb.toString());
        System.out.println("=================生成完毕，准备写到磁盘=================");
        File dir = new File(outPath);
        if (!dir.exists()){
            dir.mkdirs();
        }
        File file = new File(outPath+"\\"+OutUtils.tableNameTOjava(tableName)+".java");
        try {
            OutputStream outputStream = new FileOutputStream(file);
            PrintStream printStream = new PrintStream(outputStream);
            printStream.print(sb.toString());
            printStream.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("===================="+tableName+"写入成功=========================");
    }


    public static void main(String[] args) {
        File file = new File("E:\\shenchenwenjian\\test.java");
        try {
            OutputStream outputStream = new FileOutputStream(file);
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println("hello");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        Map<String, String> tab_category = Table.getCloumInfomation("tab_category");
//        System.out.println(tab_category);
//        outJavaBean("tab_category",tab_category);
    }
}
