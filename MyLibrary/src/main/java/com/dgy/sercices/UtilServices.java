package com.dgy.sercices;

import com.dgy.dao.UtilDao;
import com.dgy.domain.LibraryInFoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Date: 2019/7/2
 * Time: 10:25
 * Author: vincent-Dou
 * Description：工具服务层
 */
@Service
public class UtilServices {

    @Autowired
    private UtilDao utilDao;

    //获取用户总数
    public int getReaderSum(){
        return utilDao.getReaderSum();
    }

    public int getBookSum(){
        return utilDao.getBookSum();
    }

    public int getBorrowSum(){
        return utilDao.getBorrowSum();
    }

    public int getContorSum(){
        return utilDao.getContorSum();
    }

    public int getReaderMaxId(){
        return utilDao.getReaderMaxId();
    }

    public LibraryInFoVo getLibraryInfo(){
        LibraryInFoVo libraryInFoVo = new LibraryInFoVo();
        libraryInFoVo.setBookSum(utilDao.getBookSum());
        libraryInFoVo.setReaderSum(utilDao.getReaderSum());
        libraryInFoVo.setBorrowBookSum(utilDao.getBorrowSum());
        return libraryInFoVo;
    }
}
