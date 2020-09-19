<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="com.itheima.dao.IUserDao" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.itheima.domain.User" %>
<%@ page import="java.util.List" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    //1、读取配置文件，生成字节输入流
    InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
    //2、获取SqlSessionFactory
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
    //3、获取SqlSession对象
    SqlSession sqlSession = factory.openSession();
    //4、获取dao的代理对象
    IUserDao userDao = sqlSession.getMapper(IUserDao.class);
    //5、执行dao中的findAll方法
    List<User> users = userDao.findAll();
    for (User user : users) {
        System.out.println(user);
    }
    //6、释放资源
    sqlSession.close();
    in.close();
%>
</body>
</html>
