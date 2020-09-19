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

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }
    @After
    public void destroy() throws Exception{
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("mybatis annotation");
        user.setAddress("北京市昌平区");
        userDao.saveUser(user);
    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setAddress("山顶洞");
        user.setUsername("元谋人");
        user.setId(5);
        userDao.updateUser(user);
    }

    @Test
    public void testDelete(){
        userDao.deleteUser(6);
    }
    @Test
    public void testFindOne(){
        User user = userDao.findById(17);
        System.out.println(user);
    }
    @Test
    public void testFindOneByName(){
        // 第一种：看注解
//        List<User> users = userDao.findUserByName("%mybatis %");
        // 第二种：看注解
        List<User> users = userDao.findUserByName("mybatis");
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testFindTotal(){
        int totalUser = userDao.findTotalUser();
        System.out.println(totalUser);
    }


    @Test
    public void getUsers(){
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
