package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * cook的快速入门
 */
@WebServlet("/cookDemo4")
public class CookDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1创建Cookie对象
        Cookie c1 = new Cookie("msg","setMaxAge");
        // 2设置cookie的存活时间
        // c1.setMaxAge(30); // 将cookie持久化硬盘,30秒后自动删除cookie文件
        // c1.setMaxAge(-1);
        c1.setMaxAge(300);

        // 3发送cookie
        response.addCookie(c1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
