package cn.itcast.dataSource.jdbcTemplate;

import cn.itcast.dataSource.utils.JDBCUtils;
import cn.itcast.domain.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * jdbcTemplate
 */
public class jdbcTemplateDemo2 {
    //Junit单元测试，可以让方法独立执行

				/*
				2、添加一条记录
				3、删除刚才添加的记录
				4、查询id为1的记录，将其封装为Map集合
				5、查询所有记录，将其封装为List集合
				6、查询所有记录，将其封装为Emp对象的List集合
				7、查询所有记录数*/



    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 1、需改1号数据的 salary 为10000
     */

    @Test
    public void test1() {
        // 定义sql
        String sql = "update emp set salary = ? where id = ?";
        // 执行sql
        int update = jdbcTemplate.update(sql, 10000,1);
        // 查看运行结果
        System.out.println(update);
    }

    /**
     * 2、添加一条记录
     */
    @Test
    public void test2() {
        // 定义sql
        String sql = "insert into emp (id,name,dept_id)values(?,?,?)";
        int update = jdbcTemplate.update(sql,8,"蔡依林",2);
        System.out.println(update);
    }
    /**
     * 3、删除刚才添加的记录
     */
    @Test
    public void test3() {
        // 定义sql
        String sql = "delete from emp where id = ?";
        int update = jdbcTemplate.update(sql,8);
        System.out.println(update);
    }
    /**
     * 4、查询id为1的记录，将其封装为Map集合
     * 注意这个方法查询出来的结果集长度只能是1
     */
    @Test
    public void test4() {
        // 定义sql
        String sql = "select *from emp where id = ?";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, 1);
        System.out.println(map);
    }

    /**
     * 5、查询所有记录，将其封装为List集合
     *
     */
    @Test
    public void test5() {
        // 定义sql
        String sql = "select *from emp where id = ? or id = ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, 1,2);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }
    /**
     * 6、查询所有记录，将其封装为Emp对象的List集合
     *
     */
    @Test
    public void test6() {
        // 定义sql
        String sql = "select *from emp";
        /*
        List<Emp> query = jdbcTemplate.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp emp = new Emp();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                int dept_id = resultSet.getInt("dept_id");
                emp.setId(id);
                emp.setName(name);
                emp.setGender(gender);
                emp.setDept_id(dept_id);
                return emp;
            }
        });
         */
        List<Emp> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : query) {
            System.out.println(emp);
        }
    }

    /**
     * 7、查询总记录数
     *
     */
    @Test
    public void test7() {
        // 定义sql
        String sql = "select count(id) from emp";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }
}
