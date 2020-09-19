package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 测试mybatis的crud操作
 */
public class MybatisTest {
    private InputStream in;
    private IUserDao userDao;

    @Before // 用于在测试方法执行之前执行
    public void init() throws Exception {
        //1、读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3、使用工厂对象，创建dao对象
        userDao = new UserDaoImpl(factory);

    }

    @After // 用于在测试方法执行之后执行
    public void destroy() throws Exception {
        //6、释放资源
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
     * 测试保存操作
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("dao impl user");
//        user.setAddress("北京市顺义区");
        user.setAddress("北京顺义区域");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存操作之前:"+user);
        //5、执行保存方法
        userDao.saveUser(user);
        System.out.println("保存操作之后:"+user);
    }
    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setUsername("dao impl use update");
        user.setId(42);
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());
        //5、执行保存方法
        userDao.updateUser(user);
    }
    /**
     * 测试删除操作
     */
    @Test
    public void testDelete() {
       // 删除操作
        userDao.deleteUser(45);
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
        List<User> users = userDao.findByName("%mybatis saveuser%");
        for (User user : users) {
            System.out.println(user);
        }
    }
    /**
     * 测试查询总记录条数
     */
    @Test
    public void testFindTotal() {
        // 删除操作
        int total = userDao.findTotal();
        System.out.println(total);
    }
}
