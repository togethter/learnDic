package cn.itcast.dataSource.jdbcTemplate;

import cn.itcast.dataSource.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * jdbcTemplate 入门学习
 */
public class jdbcTemplateDemo1 {
    public static void main(String[] args) {
        // 1、导入jar包
        // 2、创建jdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        // 3、调用方法
        int update = jdbcTemplate.update("update account set balance = 2000 where id = ?",1);
        System.out.println(update);
    }
}
