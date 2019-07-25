package com.dgy;

import java.sql.Date;

/**
 * Date: 2019/7/25
 * Time: 17:44
 * Author: vincent-Dou
 * Description：
 */




public class TabCategory {
    String cname;
    int cid;

    public String getCname() {
        return this.cname;
    }
    public void setCname (String cname){
        this.cname = cname;
    }
    public int getCid() {
        return this.cid;
    }
    public void setCid (int cid){
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "TabCategory{" +
                "cname='" + cname + '\'' +
                ", cid=" + cid +
                '}';
    }
}
