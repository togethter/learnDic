package cn.itcast.dataSource.druid;

import cn.itcast.dataSource.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用新得工具类
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        /**
         * 完成一个添加操作，给account表添加一条记录
         */
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            // 1、获取连接对象
            connection = JDBCUtils.getConnection();
            // 2、定义sql
            String sql = "insert into account values(null,?,?)";
            // 3、获取psmt对象
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,"王五");
            pstmt.setDouble(2,1000);
            // 5、执行sql
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,connection);
        }
    }
}
