package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * account表添加一条记录
 */
public class JdbcDemo02 {
    public static void main(String[] args)  {
        Statement stmt = null;
        Connection conn = null;
        try {
            //1、 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2、定义sql
            String sql = "insert into account values(NULL,'王五',9000)";
            //3、获取Connection对象
             conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "qwe123456");
            //4、获取执行sql的对象 Statement
             stmt = conn.createStatement();
            //5执行sql
            int count = stmt.executeUpdate(sql); // 影响的结果
            //6 处理结果
            System.out.println(count);
            if (count > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 为了避免空指针异常
            //7 释放资源
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


    }
}
