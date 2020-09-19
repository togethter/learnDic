<%--
  Created by IntelliJ IDEA.
  User: gd
  Date: 2020/8/14
  Time: 2:47 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
      System.out.println("hello jsp");
      int i = 5;
      String contextPath = request.getContextPath();
      out.print(contextPath);
  %>
  <%! int i = 3; %>
  <%= i+ "hello"%>
  <% response.getWriter().write("response");%>

  <h1>hi~jsp!</h1>
  </body>
</html>
