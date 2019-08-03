package com.dgy.dao;

import com.dgy.domain.Category;
import com.dgy.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Date: 2019/7/28
 * Time: 18:39
 * Author: vincent-Dou
 * Description：
 */
public class CategoryDao {

    //声明模板对象,执行查询
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource()) ;

    public List<Category> findAll() {
        //准备sql
        String sql = "select * from tab_category" ;
        List<Category> list = null;
        try {
            list = template.query(sql,new BeanPropertyRowMapper<Category>(Category.class));
        } catch (Exception e) {
            return list;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new CategoryDao().findAll());
    }

}
