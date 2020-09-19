package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示Request对象获取请求行数据
 */
@WebServlet("/requestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 演示获取请求头数据 referer
        String referer = request.getHeader("referer");
        System.out.println(referer); // http://localhost:8080/day/login.html

        // 防盗链
        if (referer != null){
            if (referer.contains("/day14")){
                // 正常访问
//                System.out.println("播放电影...");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放电影");
            } else {
                // 倒链
//                System.out.println("想看电影吗?来优酷吧...");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("想看电影吗?来优酷吧...");
            }
        }
    }
}
