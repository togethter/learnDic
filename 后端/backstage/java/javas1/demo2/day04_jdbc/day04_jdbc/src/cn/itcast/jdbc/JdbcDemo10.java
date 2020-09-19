package cn.itcast.jdbc;

import cn.itcast.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * 事务操作
 */
public class JdbcDemo10 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        try {
            //1 获取连接对象
            connection = JDBCUtils.getConnection();
            // 开启事务
            connection.setAutoCommit(false);
            //2定义sql
            //2.1 张三    -500
            String sql1 = "update account set balance = balance - ? where id = ?";
            //2.2 李四    +500
            String sql2 = "update account set balance = balance + ? where id = ?";
            //3 获取执行sql对象
            preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement2 = connection.prepareStatement(sql2);
            //4 设置参数
            preparedStatement1.setDouble(1,500);
            preparedStatement1.setInt(2,1);

            preparedStatement2.setDouble(1,500);
            preparedStatement2.setInt(2,2);
            // 执行sql
            preparedStatement1.executeUpdate();
            // 手动制造异常
            int i = 3/0;
            preparedStatement2.executeUpdate();
            // 提交事务
            connection.commit();
        } catch (Exception throwables) {
            // 事务回滚
            try {
                if (connection != null){
                    connection.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(preparedStatement1,connection);
            JDBCUtils.close(preparedStatement2,null);
        }
    }

}
