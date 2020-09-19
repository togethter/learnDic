package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 演示Request对象获取请求行数据
 */
@WebServlet("/requestDemo2")
public class RequestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 演示获取请求头数据

        // 1获取所有请求头名称
        Enumeration<String> headers = request.getHeaderNames();
        // 2遍历
        while (headers.hasMoreElements()){
            String name = headers.nextElement();
            // 根据名称获取请求头的值
            Enumeration<String> value = request.getHeaders(name);
            System.out.println(name+ "----" +value);


        }





    }
}
