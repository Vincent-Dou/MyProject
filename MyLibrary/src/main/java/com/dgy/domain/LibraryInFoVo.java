package com.dgy.domain;

/**
 * Date: 2019/7/4
 * Time: 16:49
 * Author: vincent-Dou
 * Description：
 */
public class LibraryInFoVo {

    Integer readerSum;

    Integer BookSum;

    Integer borrowBookSum;


    public Integer getReaderSum() {
        return readerSum;
    }

    public void setReaderSum(Integer readerSum) {
        this.readerSum = readerSum;
    }

    public Integer getBookSum() {
        return BookSum;
    }

    public void setBookSum(Integer bookSum) {
        BookSum = bookSum;
    }

    public Integer getBorrowBookSum() {
        return borrowBookSum;
    }

    public void setBorrowBookSum(Integer borrowBookSum) {
        this.borrowBookSum = borrowBookSum;
    }

}
