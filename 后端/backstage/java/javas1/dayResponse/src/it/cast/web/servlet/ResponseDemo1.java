package it.cast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo1......");
        // 访问 /responseDemo1资源会自动跳转到/responseDemo2资源
        /*// 1设置状态码为 302
        response.setStatus(302);
        // 2 设置响应头location
        response.setHeader("location","/responseDemo2");*/
        request.setAttribute("msg","response");
        // 动态的获取虚拟目录
        String contextPath = request.getContextPath();


        // 简单的重定向方法
        response.sendRedirect(contextPath+"/responseDemo2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
