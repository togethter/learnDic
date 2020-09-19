<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--HTML5文档--%>
<!DOCTYPE html>
<%--网页使用的语言--%>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
<%--    使用Edge最新的浏览器的渲染方式--%>
    <meta http-equiv="X-UA-Compatible" content="IE-edge">
<%--    viewport视口：网页可以根据设置的宽度进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
width:默认宽度与设备的宽度相同
initial-scale:初始化的缩进比，为1:1
--%>
    <meta name="viewport" content="width=device-with,initial-scale=1">
    <title>添加用户</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <center><h3>添加联系人页面</h3></center>
    <form action="${pageContext.request.contextPath}/addUserServlet" method="post">
        <div class="form-group">
            <label for="name">姓名</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
        </div>
        <div class="form-group">
            <label> 性别</label>
            <input type="radio" name="gender" value="男" checked="checked">男
            <input type="radio" name="gender" value="男">女
        </div>
        <div class="form-group">
            <label for="age">年龄</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
        </div>
        <div class="form-group">
            <label for="address">籍贯</label>
            <select name="address" class="form-control" id="address">
                <option value="陕西">陕西</option>
                <option value="北京">北京</option>
                <option value="上海">上海</option>
            </select>
        </div>
        <div class="form-group">
            <label for="qq">QQ:</label>
            <input type="text" class="form-control" id="qq" name="qq" placeholder="请输入QQ号码">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱地址">
        </div>
        <div class="form-group" style="...">
            <input type="submit" class="btn btn-primary" value="提交"/>
            <input type="reset" class="btn btn-default" value="重置"/>
            <input type="button" class="btn btn-default" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>
