package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import com.itheima.mybatis.SqlSession.SqlSession;
import com.itheima.mybatis.SqlSession.SqlSessionFactoryBuilder;
import com.itheima.mybatis.io.Resources;
import com.itheima.mybatis.SqlSession.SqlSessionFactory;

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
        // 3、使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        // 4、使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        // 5、使用代理对象执行方法
        List<User>users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        // 6、释放资源
        session.close();
        in.close();
    }
}
