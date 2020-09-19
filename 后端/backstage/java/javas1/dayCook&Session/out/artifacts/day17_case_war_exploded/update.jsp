<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <title>修改用户</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

<%--    <script type="text/javascript">--%>
<%--        function refreshCode() {--%>
<%--            // 1、获取验证码图片--%>
<%--        var vcode = document.getElementById("vcode");--%>
<%--            // 2、设置其src属性，加时间戳--%>


<%--        }--%>
<%--    </script>--%>
</head>
<body>
<div class="container" style="...">
    <h3 style="...">修改联系人</h3>
    <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">
    <%-- 隐藏域提交id--%>
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" value="${user.name}" readonly="readonly" placeholder="请输入姓名:">
        </div>
        <div class="form-group">
            <label>性别：</label>
<%--            <input type="radio" name="sex" value="男"/>男--%>
<%--            <input type="radio" name="sex" value="女"/> 女--%>
            <c:if test="${user.gender == '男'}">
                <input type="radio" name="gender" value="男" checked /> 男
                <input type="radio" name="gender" value="女" /> 女
            </c:if>
            <c:if test="${user.gender == '女'}">
                <input type="radio" name="gender" value="男" /> 男
                <input type="radio" name="gender" value="女" checked /> 女
            </c:if>
        </div>
        <div class="form-group">
            <label for="age">年龄</label>
            <input type="text" class="form-control" id="age" name="age" value="${user.age}" placeholder="请输入年龄">
        </div>
        <div class="form-group">
            <label for="address">籍贯</label>
            <select name="address" class="form-control" id="address">
                <c:if test="${user.address == '陕西'}">
                    <option value="陕西" selected>陕西</option>
                    <option value="北京">北京</option>
                    <option value="中国香港">中国香港</option>
                </c:if>
                <c:if test="${user.address == '北京'}">
                    <option value="陕西">陕西</option>
                    <option value="北京" selected>北京</option>
                    <option value="中国香港">中国香港</option>
                </c:if>
                <c:if test="${user.address == '中国香港'}">
                    <option value="陕西">陕西</option>
                    <option value="北京">北京</option>
                    <option value="中国香港" selected>中国香港</option>
                </c:if>

            </select>
        </div>
        <div class="form-group">
            <label for="qq">QQ:</label>
            <input type="text" class="form-control" id="qq" name="qq" placeholder="请输入QQ号码" value="${user.qq}">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱地址" value="${user.email}">
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
