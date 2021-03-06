package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
在服务器中的Servlet判断是否有一个名为lastTime的cookie
1、有：不是第一次访问
    1：响应数据：欢迎回来，您上次访问时间为2018年6月10日11：20：20
    2：写回Cookie：lastTime=2018年6月10：12：21：21
2、没有：是第一次访问
    1：响应数据：您好，欢迎您首次访问
    2：写回Cookie：lastTime=2018年6月10：22：12：22
 */

@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应消息体的数据格式以及编码
        response.setContentType("text/html;charset=utf-8");
        // 1获取所有的cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false; // 没有cookie为lastTime
        // 2遍历cookie数组
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                // 3获取cookie名称
                String name = cookie.getName();
                // 4判断名称是否是lastTime
                if ("lastTime".equals(name)) {
                    // 有该cookie，不是第一次访问
                    flag = true; // 有lastTime的cookie
                    // 设置cookie的value
                    // 获取当前时间的字符串，重新设置cookie的值，重新发送cookie
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);
                    System.out.println("编码前的结果:"+str_date);
                    // URL编码
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    System.out.println("编码后的结果："+str_date);
                    cookie.setValue(str_date);
                    // 设置cookie的存活时间
                    cookie.setMaxAge(60 * 60 * 24 * 30);// 一个月
                    response.addCookie(cookie);
                    // 响应数据
                    // 获取cookie的value，时间
                    String value = cookie.getValue();
                    System.out.println("解码前："+value);
                    // URL解码：
                    value = URLDecoder.decode(value,"utf-8");
                    System.out.println("解码后："+value);
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为:" + value + "</h1>");
                    break;
                }
            }
        }
        if (cookies == null || cookies.length == 0 || flag == false) {
            // 没有第一次访问
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            // URL编码
            str_date = URLEncoder.encode(str_date, "utf-8");
            Cookie cookie = new Cookie("lastTime",str_date);
            cookie.setValue(str_date);
            // 设置cookie的存活时间
            cookie.setMaxAge(60 * 60 * 24 * 30);// 一个月
            response.addCookie(cookie);
            response.getWriter().write("<h1>您好，欢迎您首次访问</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
