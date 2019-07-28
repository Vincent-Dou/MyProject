package com.dgy.sercices;

import com.dgy.dao.BookDao;
import com.dgy.dao.BorrowDao;
import com.dgy.domain.Book;
import com.dgy.domain.Borrow;
import com.dgy.domain.ReaderBorrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Date: 2019/7/2
 * Time: 13:40
 * Author: vincent-Dou
 * Description：
 */
@Service
public class BorrowServices {
    @Autowired
    private BorrowDao borrowDao;

    @Autowired
    private BookDao bookDao;

    //查询所有借阅信息
    public List<Borrow> getAllBorrow(){
        return borrowDao.getAllBorrow();
    }

    //根据用户查询借阅信息（个人借阅信息）
    public List<ReaderBorrow> getReaderBorrowByReader(int readerid){
        return borrowDao.getReaderBorrowByReader(readerid);
    }

    //插入借阅一条借阅记录
    public void insertBorrow(Borrow borrow){
        borrowDao.insertBorrow(borrow);
    }

    //修改借阅信息
    public void  updateBorrow(Borrow borrow){
        borrowDao.updateBorrow(borrow);
    }

    //根据用户id和书id确定一条借阅记录
    public void getBorrowByReaderidBookid(int readerid, int bookid){
        borrowDao.getBorrowByReaderidBookid(readerid, bookid);
    }

    //删除一条借阅记录
    public void delBorrow(int readerid, int bookid){
        Book book = bookDao.findBookByBookId(bookid);
        book.setBookstate(true);
        bookDao.updateBook(book);
        borrowDao.delBorrow(readerid, bookid);
    }
}
