package com.dgy.dao;

import com.dgy.domain.Category;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Date: 2019/7/23
 * Time: 12:16
 * Author: vincent-Dou
 * Description：
 */
public class TestCategory {

    @Test
    public void test1(){
        InputStream inputStream = TestCategory.class.getClassLoader().getResourceAsStream("myBatis.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CategoryDao categoryDao = sqlSession.getMapper(CategoryDao.class);
        List<Category> all = categoryDao.findAll();
        for (Category category: all){
            System.out.println(category);
        }
    }
}
