package cn.itcast.util;

import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * jdbc工具类
 */
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /**
     * 文件的读取，只需要读取一次即可。使用静态代码块
     */

    static {
        try {
            // 读取资源文件，获取值
            //1、创建Property集合类
            Properties pro = new Properties();
            // 获取src路径下的文件的方式->ClassLoader
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
//            URL res = classLoader.getResource("jdbc.properties");
            InputStream is = classLoader.getResourceAsStream("jdbc.properties");
            //2 加载文件
            pro.load(is);
            //3 获取数据，赋值
            url = pro.getProperty("url");
            password = pro.getProperty("password");
            user = pro.getProperty("user");
            driver = pro.getProperty("driver");
            //4 注册驱动
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void close(Statement stmt, Connection conn) {
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

    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
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
