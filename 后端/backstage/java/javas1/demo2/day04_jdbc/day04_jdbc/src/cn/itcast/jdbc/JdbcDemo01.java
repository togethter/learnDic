package cn.itcast.jdbc;

import java.sql.*;

/**
 * JDBC快速入门
 */
public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {

//        1、导入驱动jar包
//        2、注册驱动 
//        Class.forName("com.mysql.cj.jdbc.Driver");// com.mysql.jdbc.Driver'. This is deprecated.
//        3、获取数据库连接对象
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "qwe123456");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "qwe123456");

//        4、定义sql语句
        String sql = "update account set balance = 8544";
//        5、获取执行sql的对象 Statement
        Statement stmt = connection.createStatement();
//        6、执行sql
        int count = stmt.executeUpdate(sql);
//        7、处理结果
        System.out.println(count);
//        8、释放资源
        stmt.close();
        connection.close();
        

    }
}
