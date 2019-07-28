package com.dgy.contoll;

import org.springframework.core.convert.converter.Converter;

/**
 * Date: 2019/7/4
 * Time: 11:40
 * Author: vincent-Dou
 * Description：自定义类型转换器
 */
public class StringToBooleanConvert implements Converter<String, Boolean> {

    @Override
    public Boolean convert(String s) {
        if(s.equals("")){
            throw new RuntimeException("数据不能为空");
        }
        if(s.equals("true")){
            return true;
        }
        if(s.equals("false")){
            return false;
        }
        throw new RuntimeException("数据有误");
    }
}
