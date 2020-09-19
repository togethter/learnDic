package cn.itcast.jdbc;

import cn.itcast.domain.Emp;
import cn.itcast.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义一个方法 查询emp表的数据将其封装为对象,然后装载集合，返回。
 */
public class JdbcDemo08 {
    public static void main(String[] args) {
        List<Emp> all = new JdbcDemo08().findAll2();
        System.out.println(all);
    }
    /**
     * 查询所有的emp对象
     *
     * @return
     */
    public List<Emp> findAll() {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
            // 1、注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2、获取连接
             connection = DriverManager.getConnection("jdbc:mysql:///db1","root","qwe123456");
            // 3、定义sql
            String sql = "select *from emp";
            //4、获取执行sql对象
             stmt = connection.createStatement();
            //5、执行sql
             rs = stmt.executeQuery(sql);
            //6 遍历结果集,封装对象，装在集合
            Emp emp = null;
            list = new ArrayList<>();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                Date join_date = rs.getDate("join_date");
                double salary = rs.getDouble("salary");
                int dept_id = rs.getInt("dept_id");
                // 创建emp对象,并赋值
                emp = new Emp();
                emp.setId(id);
                emp.setName(name);
                emp.setGender(gender);
                emp.setJoin_date(join_date);
                emp.setSalary(salary);
                emp.setSalary(salary);
                emp.getDept_id(dept_id);
                list.add(emp);
            }


        } catch (ClassNotFoundException  e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        // 2、
        return list;
    }
    /**
     * 演示JDBC工具类
     *
     * @return
     */
    public List<Emp> findAll2() {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
            // 1、注册驱动
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            // 2、获取连接
//            connection = DriverManager.getConnection("jdbc:mysql:///db1","root","qwe123456");
            connection = JDBCUtils.getConnection();
            // 3、定义sql
            String sql = "select *from emp";
            //4、获取执行sql对象
            stmt = connection.createStatement();
            //5、执行sql
            rs = stmt.executeQuery(sql);
            //6 遍历结果集,封装对象，装在集合
            Emp emp = null;
            list = new ArrayList<>();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                Date join_date = rs.getDate("join_date");
                double salary = rs.getDouble("salary");
                int dept_id = rs.getInt("dept_id");
                // 创建emp对象,并赋值
                emp = new Emp();
                emp.setId(id);
                emp.setName(name);
                emp.setGender(gender);
                emp.setJoin_date(join_date);
                emp.setSalary(salary);
                emp.setSalary(salary);
                emp.getDept_id(dept_id);
                list.add(emp);
            }


        }  catch (SQLException e){
            e.printStackTrace();
        } finally {
//            if (connection != null){
//                try {
//                    connection.close();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//            }
//            if (stmt != null){
//                try {
//                    stmt.close();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//            }
//            if (rs != null){
//                try {
//                    rs.close();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//            }
            JDBCUtils.close(rs,stmt,connection);
        }
        // 2、
        return list;
    }
}
