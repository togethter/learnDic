package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.management.Query;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 测试mybatis的crud操作
 */
public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before // 用于在测试方法执行之前执行
    public void init() throws Exception {
        //1、读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3、获取SqlSession对象
        sqlSession = factory.openSession();
        //4、获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After // 用于在测试方法执行之后执行
    public void destroy() throws Exception {
        //提交事务
        sqlSession.commit();
        //6、释放资源
        sqlSession.close();
        in.close();

    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() throws Exception {
        //1、读取配置文件，生成字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3、获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4、获取dao的代理对象
        IUserDao userdao = sqlSession.getMapper(IUserDao.class);
        //5、执行查询所有的方法
        List<User> users = userdao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }
    /**
     * 测试查询一个操作
     */
    @Test
    public void testFindOne() {
        // 删除操作
        User user = userDao.findById(43);
        System.out.println(user);
    }
    /**
     * 测试模糊查询一个操作
     */
    @Test
    public void testFindByName() {
        // 删除操作
//        List<User> users = userDao.findByName("%王%");
        List<User> users = userDao.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }
    /**
     * 测试使用QueryVo作为查询条件
     */
    @Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        // 删除操作
        List<User> users = userDao.findUserByVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }
    /**
     * 测试查询所有
     */
    @Test
    public void testFindByCondition() throws Exception {
        User u = new User();
        u.setUsername("mybatis saveuser");
        u.setSex("女");
        //5、执行查询所有的方法
        List<User> users = userDao.findUserByCondition(u);
        for (User user : users) {
            System.out.println(user);
        }
    }
    /**
     * 测试foreach标签的使用
     */
    @Test
    public void testFindInIds() throws Exception {
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(42);
        list.add(43);
        list.add(44);
        vo.setIds(list);
        //5、执行查询所有的方法
        List<User> users = userDao.findUserInIds(vo);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
