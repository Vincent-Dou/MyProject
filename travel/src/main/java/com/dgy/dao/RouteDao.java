package com.dgy.dao;

import com.dgy.domain.Route;
import com.dgy.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2019/8/1
 * Time: 19:06
 * Author: vincent-Dou
 * Description：旅游线路商品的dao的实现层
 */
public class RouteDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource()) ;

    public int findTotalPage(int cid,String rname) {
        /**
         * 通过分类id查询总记录数
         * 或者是通过线路名称模糊查询
         * @param cid
         * @return
         */
        String sql = "select count(*) from tab_route where " ;

        StringBuffer sb = new StringBuffer(sql) ;
        sb.append("cid=").append(cid);
        sb.append(" and rname like ").append("'%"+rname+"%'");
        System.out.println(sb);
        int temp = template.queryForObject(sb.toString(), Integer.class);
        System.out.println(temp);
        return temp;
    }

    public static void main(String[] args) {
        RouteDao routeDao = new RouteDao();
        routeDao.findTotalPage(5, "宁夏");
//        System.out.println(routeDao.findTotalPage(5, "宁夏"));
    }

    /**
     * 查询当前页面数据集合,通过分页查询
     * @param cid
     * @param start
     * @param pageSize
     * @return
     */
    public List<Route> findByPage(int cid, int start, int pageSize, String rname) {

        String sql = "select *  from tab_route where 1=1 " ;
        //拼接sql
        StringBuffer sb = new StringBuffer(sql) ;
        //判断并且给参数赋值
        sb.append("cid=").append(cid);
        sb.append(" and rname like ").append("'%"+rname+"%'");
        sb.toString() ;

        //创建条件List集合
        List<Route> params = new ArrayList() ;

//        return template.query(sql,new BeanPropertyRowMapper<Route>(Route.class),cid,start,pageSize) ;
        return template.query(sql,new BeanPropertyRowMapper<Route>(Route.class),params.toArray()) ;
    }
}
