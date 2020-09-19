package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 删除表一条记录
 */
public class JdbcDemo04 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection connection = null;
        try {
            //1 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2 获取连接对象
            connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "qwe123456");
            //3 定义sql
            String sql = "delete from account where id = 3";
            //4 获取执行sql对象
            stmt = connection.createStatement();
            //5 执行sql
            int count = stmt.executeUpdate(sql);
            // 处理结果
            System.out.println(count);
            if (count > 0) {
                System.out.println("删除一条记录成功");
            } else {
                System.out.println("修改一条记录失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {

        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
