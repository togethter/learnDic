package cn.itcast.jdbc;

import cn.itcast.domain.Emp;
import cn.itcast.util.JDBCUtils;
import com.sun.source.tree.BreakTree;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 需求
 * 1、通过键盘录入用户名和密码
 * 2、判断用户是否是否登录成功
 */
public class JdbcDemo09 {
    public static void main(String[] args) {
        // 1键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        boolean login = new JdbcDemo09().login2(username, password);
        if (login){
            System.out.println("登录成功");
        } else {
            System.out.println("用户名和密码错误！");
        }


        // 2调用方法

        // 3判断结果，输出不同语句
    }
    /**
     * 登录方法
     */
    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        // 连接数据库判断是否登录成功
        try {
            //1.获取连接
            connection = JDBCUtils.getConnection();
            //2.定义sql
            String sql = "select *from user where username = '" + username + "' and password = '" + password + "' ";
            System.out.println(sql);
            //3、获取执行sql对象
            statement = connection.createStatement();
            //4、执行查询
            rs = statement.executeQuery(sql);
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs, statement, connection);
        }
        return false;
    }
    /**
     * 登录方法 使用PreParedStatement实现
     */
    public boolean login2(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        // 连接数据库判断是否登录成功
        try {
            //1.获取连接
            connection = JDBCUtils.getConnection();
            //2.定义sql
            String sql = "select *from user where username = ? and password = ?";
            System.out.println(sql);
            //3、获取执行sql对象
             statement = connection.prepareStatement(sql);
             // 给?赋值
            statement.setString(1,username);
            statement.setString(2,password);
            //4、执行查询,不需要传递sql
            rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs, statement, connection);
        }
        return false;
    }
}
