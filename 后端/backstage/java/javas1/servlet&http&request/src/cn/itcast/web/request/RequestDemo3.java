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
@WebServlet("/requestDemo3")
public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 演示获取请求头数据：user-agent
        String agent = request.getHeader("user-agent");
        // 判断agent的浏览器版本
        if (agent.contains("Chrome")){
            // 谷歌浏览器
            System.out.println("谷歌来了....");
        } else if (agent.contains("firefox")){
            System.out.println("火狐来了...");
        } else {
            System.out.println("其他的来了...");
        }
    }
}
