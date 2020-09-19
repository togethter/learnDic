package cn.itcast.dataSource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0的演示
 */
public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        testNameConfig();

    }

    public static void testConfig() throws SQLException {
        //1 创建数据库连接对象，什么都没串使用默认的配置
        DataSource ds = new ComboPooledDataSource();
        //1.1获取dataSource使用指定名称
        //2 获取连接对象
        for (int i = 0; i < 10; i++) {
            Connection connection = ds.getConnection();
            System.out.println(i + ":" + connection);
            if (i == 5) {
                connection.close();// 归还连接到连接池中
            }
        }
    }

    public static void testNameConfig() throws SQLException {
        //1 创建数据库连接对象，什么都没串使用默认的配置
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        //1.1获取dataSource使用指定名称
        //2 获取连接对象
        for (int i = 0; i < 10; i++) {
            Connection connection = ds.getConnection();
            System.out.println(i + ":" + connection);
        }
    }
}
