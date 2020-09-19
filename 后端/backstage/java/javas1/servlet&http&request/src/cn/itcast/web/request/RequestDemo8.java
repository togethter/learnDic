package cn.itcast.web.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示Request对象获取请求行数据
 */
@WebServlet("/requestDemo8")
public class RequestDemo8 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*RequestDispatcher rd = request.getRequestDispatcher("/requestDemo9");
        rd.forward(request,response);*/

        // 存储数据到request域中
        req.setAttribute("msg","hello");
        System.out.println("demo888被访问了");
        req.getRequestDispatcher("/requestDemo9").forward(req,resp);
//        req.getRequestDispatcher("http://www.baidu.com").forward(req,resp);


    }
}
