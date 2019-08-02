package com.dgy.services;

import com.dgy.dao.RouteDao;
import com.dgy.domain.PageBean;
import com.dgy.domain.Route;
import com.sun.tools.javac.tree.JCTree;
import redis.clients.jedis.BinaryClient;
import sun.tools.jstat.RawOutputFormatter;

import javax.print.attribute.standard.MediaSizeName;
import java.util.List;

/**
 * Date: 2019/7/31
 * Time: 14:15
 * Author: vincent-Dou
 * Description：
 */

public class RouteService{

    private RouteDao routeDao;

    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String name){
        PageBean<Route> pageBean = new PageBean<>();
        //当前页码
        pageBean.setCurrentPage(currentPage);
        //页面路线条数
        pageBean.setPageSize(pageSize);
        //总记录数
        int totalCount = routeDao.findTotalPage(cid, name);
        pageBean.setTotalCount(totalCount);
        int start = (currentPage-1) * pageSize ;

        List<Route> list =routeDao.findByPage(cid, start, pageSize, name);
        pageBean.setList(list);

        //计算总页数
        int totalPage = totalCount % pageSize== 0 ? totalCount/pageSize :(totalCount/pageSize)+1 ;
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }
}
