package com.itheima.test;



import com.itheima.dao.IAccountDao;
import com.itheima.dao.IUserDao;
import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class SecondLevelCacheTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IAccountDao accountDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        accountDao = session.getMapper(IAccountDao.class);
    }
    @After
    public void destroy() throws Exception{
        session.commit();
        session.close();
        in.close();
    }

  @Test
    public void testFindOne(){
      SqlSession session = factory.openSession();
      IUserDao userDao = session.getMapper(IUserDao.class);
      User user = userDao.findById(16);
      System.out.println(user);
      session.close(); // 释放一级缓存

      SqlSession session1 = factory.openSession();// 再次开启session
      IUserDao userDao1 = session1.getMapper(IUserDao.class);
      User user1 = userDao1.findById(16);
      System.out.println(user1);
      session.close();
      System.out.println(user == user1);
  }

}
