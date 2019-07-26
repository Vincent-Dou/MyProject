package com.dgy.dao;

import com.dgy.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Date: 2019/7/26
 * Time: 22:45
 * Author: vincent-Dou
 * Description：
 */
public interface UserDao {
    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    @Select("select * from tab_user where username = #{username}")
    User findUserByUserName(String userName);

    /**
     * 添加用户
     */
    @Insert("insert into tab_user(username,password,name,birthday,sex,telephone,email,status,code) values(#{username}, #{password}, #{name}, #{birthday}, #{sex}, #{telephone}, #{email}, #{status}, #{code})")
    void saveUser(User user);

    /**
     *根据激活码查询用户
     */
    @Select("select * from tab_user where code = #{code}")
    User findUserByCode(String code);


    /**
     * 更新用户的激活状态
     */
    @Update("update tab_user set status='Y' where uid = #{uid}")
    void updateStatus(User user);

    /**
     * 查询所有用户
     */
    @Select("select * from tab_user")
    List<User> findAllUser();

    /**
     * 根据用户名和密码查询用户
     */
    @Select("select * from tab_user where username = #{user} and password = #{password}")
    User findUserByUserNameAndPassword(@Param("user") String username, @Param("password") String password);
}
