<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--请求参数绑定--%>
<%--
<a href="param/testParam?username=hehe&password=123456">请求参数绑定</a>
--%>
<%--
把数据封装到Account类中，类中存在list和map的集合
<form action="param/saveAccount" method="post">
姓名：<input type="test" name="username"/><br>
密码：<input type="test" name="password"/><br>
金额：<input type="test" name="money"/><br>
用户姓名：<input type="test" name="user.uname"/><br>
用户年龄:<input type="test" name="user.age"/><br>
<input type="submit" value="提交"/>
</form>
--%>
<%--把数据封装到Account类中，类中存在list和map的集合
<form action="param/saveAccount" method="post">
    姓名：<input type="test" name="username"/><br>
    密码：<input type="test" name="password"/><br>
    金额：<input type="test" name="money"/><br>
    用户姓名：<input type="test" name="list[0].uname"/><br>
    用户年龄:<input type="test" name="list[0].age"/><br>
    用户姓名：<input type="test" name="map['one'].uname"/><br>
    用户年龄:<input type="test" name="map['one'].age"/><br>
    <input type="submit" value="提交"/>
</form>
--%>
<%--自定义类型转换器
<form action="param/saveUser" method="post">
    用户姓名：<input type="test" name="uname"/><br>
    用户年龄:<input type="test" name="age"/><br>
    用户生日:<input type="test" name="date"/><br>
    <input type="submit" value="提交"/>
</form>
--%>
<a href="param/testServlet">servlet原生的API</a>

</body>
</html>
