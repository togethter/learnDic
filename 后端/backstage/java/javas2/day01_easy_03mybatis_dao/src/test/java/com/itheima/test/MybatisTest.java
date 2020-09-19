package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis的入门案例
 */
public class MybatisTest {
    /**
     * 入门案例
     */
    public static void main(String[] args) throws IOException {
        // 1、读取配置文
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2、创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 3、使用工厂创建dao对象
        UserDaoImpl userDao = new UserDaoImpl(factory);

        // 5、使用代理对象执行方法
        List<User>users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        // 6、释放资源
        in.close();
    }
}
