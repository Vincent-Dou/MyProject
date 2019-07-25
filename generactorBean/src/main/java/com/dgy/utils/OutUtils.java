package com.dgy.utils;

/**
 * Date: 2019/7/25
 * Time: 13:16
 * Author: vincent-Dou
 * Description：
 */
public class OutUtils {

    /**
     * 将列的类型转换成java类型
     * @param type
     * @return
     */
    public static String sqlTypeToJavaType(String type) {
        String result = "";
        switch (type.toLowerCase()) {
            case "int":
                result = "int";
                break;
            case "bit":
                result = "boolean";
                break;
            case "tinyint":
                result = "boolean";
                break;
            case "varchar":
                result = "String";
                break;
            case "date":
                result = "Date";
                break;
            case "double":
                result = "double";
                break;
            case "float":
                result = "float";
                break;
            case "char":
                result = "char";
                break;
            default:
                result = "Object";
                break;
        }
        return result;
    }


    /**
     * 将表名转换成大驼峰写法
     * @param tablename
     * @return
     */
    public static String tableNameTOjava(String tablename){
        if (tablename == null){
            return null;
        }
        String[] strings = tablename.split("_");
        StringBuilder sb = new StringBuilder();
        for (String str : strings){
            sb.append(str.substring(0,1).toUpperCase()+str.substring(1).toLowerCase());
        }
        return sb.toString();
    }

    /**
     * 将列名转换成小驼峰的写法
     * @param cloumName
     * @return
     */
    public static String cloumNameTojava(String cloumName){
        if (cloumName == null){
            return null;
        }
        String[] strings = cloumName.split("_");
        StringBuilder sb = new StringBuilder();
        for (String str : strings){
            sb.append(str.substring(0,1).toUpperCase()+str.substring(1).toLowerCase());
        }
        return sb.substring(0,1).toLowerCase()+sb.substring(1);
    }



    public static void main(String[] args) {
        System.out.println(tableNameTOjava("tab_category"));
        System.out.println(cloumNameTojava("tab_category"));
    }
}
