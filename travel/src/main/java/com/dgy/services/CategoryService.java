package com.dgy.services;

import com.dgy.dao.CategoryDao;
import com.dgy.domain.Category;
import com.dgy.utils.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Date: 2019/7/31
 * Time: 14:13
 * Author: vincent-Dou
 * Description：旅游分类业务
 */
public class CategoryService {

    private CategoryDao categoryDao = new CategoryDao();

    public List<Category> findCategoryList(){
        List<Category> categoryList = new ArrayList<>();
        Jedis jedis = JedisUtil.getJedis();
        //获取分类id
        Set<Tuple> categories = jedis.zrangeWithScores("category",0,-1) ;
        if (categories == null || categories.isEmpty()) {
            //从数据库中获取分类信息
            categoryList = categoryDao.findAll();
            for (int i = 0; i < categoryList.size(); i++) {
                jedis.zadd("category", categoryList.get(i).getCid(), categoryList.get(i).getCname());
            }
        }else {
            //从jedis中获取信息
            for (Tuple tuple : categories){
                Category category = new Category();
                category.setCid((int) tuple.getScore());
                category.setCname(tuple.getElement());
                categoryList.add(category);
            }
        }
        return categoryList;
    }

    public static void main(String[] args) {
        CategoryService categoryService = new CategoryService();
        List<Category> categoryList = categoryService.findCategoryList();
        for (Category category : categoryList){
            System.out.println(category);
        }
    }
}
