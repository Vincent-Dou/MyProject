package com.dgy.services;

import com.dgy.dao.UserDao;
import com.dgy.domain.User;
import com.dgy.utils.MailUtils;
import com.dgy.utils.UUidUtil;

import javax.jws.soap.SOAPBinding;
import javax.rmi.CORBA.Util;

/**
 * Date: 2019/8/1
 * Time: 18:19
 * Author: vincent-Dou
 * Description：
 */
public class UserService {
    private UserDao userDao = new UserDao();

    /**
     * 注册功能
     */
    public boolean regist(User user){
        User temp = userDao.findUserByUserName(user.getUsername());
        if (temp != null){
            return false;
        }
        user.setCode(UUidUtil.getUuid());
        user.setStatus("N");
        userDao.addUser(user);
        //设置邮箱激活
        String content = "您的邮箱尚未激活,请<a href='http://localhost/travel/user/active?code="+user.getCode()+"'>点击激活</a>" ;
        MailUtils.sendMail(user.getEmail(),content,"激活") ;
        return true;
    }

    /**
     * 邮件激活
     */
    public boolean active(String code){
        User user = userDao.findUserByCode(code);
        if (user != null){
            userDao.updateStatus(user);
            return true;
        }
        return false;
    }

    /**
     * 根据用户名和密码查询用户
     */
    public User findUserByUsernameAndPassword(User user){
        return userDao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
