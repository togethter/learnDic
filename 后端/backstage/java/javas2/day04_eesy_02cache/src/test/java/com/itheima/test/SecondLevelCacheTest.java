package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * 测试mybatis的crud操作
 */
public class SecondLevelCacheTest {
    private InputStream in;
    private SqlSessionFactory factory;

    @Before // 用于在测试方法执行之前执行
    public void init() throws Exception {
        //1、读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、获取SqlSessionFactory
        factory = new SqlSessionFactoryBuilder().build(in);
    }

    @After // 用于在测试方法执行之后执行
    public void destroy() throws Exception {

        in.close();
    }

    @Test
    public void testFirstLevelCache() {
        SqlSession sqlSession1 = factory.openSession();
        IUserDao dao1 = sqlSession1.getMapper(IUserDao.class);
        User user1 = dao1.findById(8);
        System.out.println(user1);
        sqlSession1.close();    // 一级缓存消息

        SqlSession sqlSession2 = factory.openSession();
        IUserDao dao2 = sqlSession2.getMapper(IUserDao.class);
        User user2 = dao2.findById(8);
        sqlSession2.close();
        System.out.println(user2);//

    }

}
