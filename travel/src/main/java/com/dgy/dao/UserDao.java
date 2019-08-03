package com.dgy.dao;

import com.dgy.domain.User;
import com.dgy.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Date: 2019/7/28
 * Time: 18:52
 * Author: vincent-Dou
 * Description：
 */
public class UserDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据用户名查询用户对象
     */
    public User findUserByUserName(String username){
        User user = null;
        String sql = "select * from tab_user where username = ?";
        try {
            user =jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
        return user;
    }

    /**
     * 添加用户
     */
    public void addUser(User user){
        String sql = "insert into tab_user(username,password,name,birthday,sex,telephone,email,status,code) values(?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getName(),
                                 user.getBirthday(), user.getSex(), user.getTelephone(),
                                 user.getEmail(), user.getStatus(), user.getCode());
    }

    /**
     * 根据激活码查询用户对象
     */
    public User findUserByCode(String code){
        String sql = "select * from tab_user where code = ?";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), code);
        } catch (Exception e) {
            return user;
        }
        return user;
    }

    /**
     * 用户激活
     * @param
     */
    public void updateStatus(User user) {
        //sql
        String sql = "update tab_user set status='Y' where uid = ?" ;
        jdbcTemplate.update(sql,user.getUid()) ;
    }

    /**
     * 根据用户名和密码查询用户
     */
    public User findUserByUsernameAndPassword(String username, String password){
        User user = null;
        String sql = "select * from tab_user where username = ? and password = ?";
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    public static void main(String[] args) {
//        User user = new UserDao().findUserByUsernameAndPassword("zhangsan", "1234567890");
        User user = new UserDao().findUserByCode("10c7ab10b3e84534beec37398f7e967d");
//        User user = new UserDao().findUserByUserName("douguangyao");
//        User user = new UserDao().findUserByUserName("zhangsan");
        System.out.println(user);
    }
}
