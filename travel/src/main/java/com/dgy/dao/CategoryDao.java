package com.dgy.dao;

import com.dgy.domain.Category;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Date: 2019/7/23
 * Time: 12:10
 * Author: vincent-Dou
 * Description：
 */
public interface CategoryDao {
    @Select("select * from tab_category")
    List<Category> findAll();
}
