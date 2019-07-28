package com.dgy.domain;

import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * Date: 2019/7/1
 * Time: 10:28
 * Author: vincent-Dou
 * Description：借阅信息实体类
 */
@Component
public class Borrow {
    private Integer readerid;
    private Integer bookid;
    private Date borrowdate;


    public Integer getReaderid() {
        return readerid;
    }

    public void setReaderid(Integer readerid) {
        this.readerid = readerid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Date getBorrowdate() {
        return borrowdate;
    }

    public void setBorrowdate(Date borrowdate) {
        this.borrowdate = borrowdate;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "readerid=" + readerid +
                ", bookid=" + bookid +
                ", borrowdate=" + borrowdate +
                '}';
    }
}
