package com.dgy.dao;

import com.dgy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * Date: 2019/7/26
 * Time: 23:37
 * Author: vincent-Dou
 * Description：
 */
public class TestUserDao {
    InputStream inputStream;
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;
    UserDao userDao;
    @Before
    public void before() throws IOException {
        inputStream = Resources.getResourceAsStream("myBatis.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void after() throws IOException {
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testfindUserByUserName(){
        User dgy = userDao.findUserByUserName("dgy");
        System.out.println(dgy);
    }

    @Test
    public void testsaveUser(){
        User user = userDao.findUserByUserName("dgy");
        user.setUid(null);
        user.setUsername("ddd");
        user.setCode("ijn");
        userDao.saveUser(user);
        sqlSession.commit();
        List<User> users = userDao.findAllUser();
        System.out.println(users);
    }

    @Test
    public void testfindUserByCode(){
        User userByCode = userDao.findUserByCode("123");
        System.out.println(userByCode);
    }

    @Test
    public void testupdateStatus(){
        User user = userDao.findUserByCode("123");
        userDao.updateStatus(user);
        sqlSession.commit();
        System.out.println(userDao.findAllUser());
    }


    @Test
    public void testfindUserByUserNameAndPassword(){
        User user = userDao.findUserByUserNameAndPassword("dgy","123");
        System.out.println(user);
    }
}
