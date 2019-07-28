package com.dgy.domain;

import org.springframework.stereotype.Component;

/**
 * Date: 2019/7/1
 * Time: 19:25
 * Author: vincent-Dou
 * Description：管理员实体类
 */

@Component
public class Contor {
    private Integer contorid;
    private String  contorname;
    private String password;

    public Integer getContorid() {
        return contorid;
    }

    public void setContorid(Integer contorid) {
        this.contorid = contorid;
    }

    public String getContorname() {
        return contorname;
    }

    public void setContorname(String contorname) {
        this.contorname = contorname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Contor{" +
                "contorid=" + contorid +
                ", contorname='" + contorname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
