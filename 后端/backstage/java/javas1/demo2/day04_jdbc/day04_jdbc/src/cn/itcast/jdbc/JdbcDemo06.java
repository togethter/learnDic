package cn.itcast.jdbc;

import java.sql.*;

/**
 * 删除表一条记录
 */
public class JdbcDemo06 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            //1 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2 获取连接对象
            connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "qwe123456");
            //3 定义sql
            String sql = "select *from account";
            //4 获取执行sql对象
            stmt = connection.createStatement();
            //5 执行sql
             rs = stmt.executeQuery(sql);
             //6 处理结果
//             6.1 让游标向下移动一行
            rs.next();
            int id = rs.getInt(1);
            String name = rs.getString("name");
            double balance = rs.getDouble(3);
            System.out.println(id + "---" + name + balance);
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
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }
}
