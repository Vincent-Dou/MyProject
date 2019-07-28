package com.dgy.sercices;

import com.dgy.dao.BookDao;
import com.dgy.dao.ContorDao;
import com.dgy.domain.Book;
import com.dgy.domain.Contor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Date: 2019/7/2
 * Time: 10:29
 * Author: vincent-Dou
 * Description：管理员服务层
 */
@Service
public class ContorServices {
    @Autowired
    private ContorDao contorDao;
    @Autowired
    private BookDao bookDao;

    public Contor getContorById(int id){
        return contorDao.getContorById(id);
    }

    public boolean login(int id, String password){
        Contor contor = contorDao.getContorById(id);
        if (contor.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public void addContor(Contor contor){
        contorDao.insertContor(contor);
    }

    public void updateBook(Book book){
        bookDao.updateBook(book);
    }

    public List<Contor> findAllContor(){
        return contorDao.findAllContor();
    }

    public void updateContor(Contor contor){
        contorDao.updeteContor(contor);
    }
}
