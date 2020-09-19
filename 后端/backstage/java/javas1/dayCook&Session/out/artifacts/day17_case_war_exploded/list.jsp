<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%--网页使用的语言--%>
<html lang="zh-CN">
<head>
    <%--    指定字符集--%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>用户信息管理系统</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function deleteUser(id) {
            // 用户安全提示
            if (confirm("您确定要删除吗?")) {
                location.href = "${pageContext.request.contextPath}/delUserServlet?id=" + id;
            }
        }

        function changeUser(id) {
            location.href = "${pageContext.request.contextPath}/findUserServlet?id=" + id;
        }

        window.onload = function () {
            // 给删除选中的按钮添加单击事件
            document.getElementById("delSelected").onclick = function () {
                if (confirm("您确定要删除选中条目吗?")) {
                    //
                    var flag = false;
                    // 判断是否有选中条目
                    var cbs = document.getElementById("uid");
                    for (var i = 0; i < cbs.length; i++) {
                        if (cbs[i].checked) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) { // 有条目被选中
                        // 表单提交
                        document.getElementById("form").submit();
                    }
                }
            }
            // 1 获取第一个cb
            document.getElementById("firstCd").onclick = function () {
                // 2 获取下边列表的所有的cb
                var cbs = document.getElementsByName("uid");
                // 3 遍历
                for (var i = 0; i < cbs.length; i++) {
                    // 4、设置这些cbs[i]的checked状态 = firstCb.checked
                    cbs[i].checked = this.checked;

                }

            }
        }

    </script>
</head>
<body>
<div class="container">
    <h3 style="...">用户信息列表</h3>
    <div>
        <form class="form-inline" action="${pageContext.request.contextPath}/findUserByPageServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="name" value="${condition.name[0]}" class="form-control" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" name="address" value="${condition.address[0]}" class="form-control" id="exampleInputName3">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">Emiail</label>
                <input type="email" name="email" value="${condition.email[0]}" class="form-control" id="exampleInputEmail2">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>
    </div>

    <form id="form" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="firstCd"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pb.list}" var="user" varStatus="s">
                <tr>
                    <th><input type="checkbox" name="uid" value="${user.id}"></th>
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}< /td>
                    <td>
                        <a class="btn btn-danger btn-small" href="javascript:changeUser(${user.id})">修改</a>&nbsp;
                        <a class="btn btn-danger btn-small" href="javascript:deleteUser(${user.id});">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pb.currentPage == 1}">
                <li class="disabled">
                    </c:if>
                    <c:if test="${pb.currentPage != 1}">
                <li>
                    </c:if>

                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage -1 }&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}"
                       aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <c:if test="${pb.currentPage == i}">
                        <li class="active"><a
                                href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a>
                        </li>
                    </c:if>
                    <c:if test="${pb.currentPage != i}">
                        <li>
                            <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a>
                        </li>
                    </c:if>
                </c:forEach>
                <li>
                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage + 1 }&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}"
                       aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 5px">
                    共${pb.totalCount}条记录，共${pb.totalPage}页
                </span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
