<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>牛逼人物，好香</title>
</head>
<body>
<table>
    <tr>
        <td>学号</td>
        <td><input type="text" name="id" value="${requestScope["students"][0]["id"]}"></td>
    </tr>
    <tr>
        <td>姓名：</td>
        <td><input type="text" name="id" value="${requestScope["students"][0]["name"]}"></td>
    </tr>
    <tr>
        <td>email:</td>
        <td><input type="text" name="id" value="${requestScope["students"][0]["email"]}"></td>
    </tr>
    <tr>
        <td>年龄：</td>
        <td><input type="text" name="id" value="${requestScope["students"][0]["age"]}"></td>
    </tr>

</table>
我还是从前那个少年，没有一丝丝改变！
</body>
</html>
