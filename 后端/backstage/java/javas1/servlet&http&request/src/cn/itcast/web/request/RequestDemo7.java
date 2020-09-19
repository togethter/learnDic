package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * 演示Request对象获取请求行数据
 */
@WebServlet("/requestDemo7")
public class RequestDemo7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("post");
        // 设置流的编码
        request.setCharacterEncoding("utf-8");

        // 获取请求参数username
        String username = request.getParameter("username");
        System.out.println(username);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get");
        // 1、根据参数名称获取参数值
//        String username = req.getParameter("username");
//        System.out.println(username);
        // 2、根据参数名称获取参数值的数组
         /* String[] hobbys = request.getParameterValues("hobby");
        for (String hobby : hobbys) {
            System.out.println(hobby);
        }*/
    }
}
