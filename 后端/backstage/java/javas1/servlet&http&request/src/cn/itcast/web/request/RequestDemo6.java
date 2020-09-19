package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * 演示Request对象获取请求行数据
 */
@WebServlet("/requestDemo6")
public class RequestDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // POST请求获取请求参数
        // 1、根据参数名称获取参数值
        System.out.println("post");
        /*String username = request.getParameter("username");
        System.out.println(username);*/

        // 2、根据参数名称获取参数值的数组
       /* String[] hobbys = request.getParameterValues("hobby");
        for (String hobby : hobbys) {
            System.out.println(hobby);
        }*/
        // 3、获取所有请求的参数名称
        /*Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = request.getParameter(name);
            System.out.println(value);
            System.out.println("=============");
        }*/
        // 4、获取所有参数的map集合
        Map<String, String[]> parameterMap = request.getParameterMap();

        Set<String> keySet = parameterMap.keySet();
        for (String name : keySet) {
            // 获取键获取值
            String[] values = parameterMap.get(name);
            System.out.println(name);
            for (String value : values) {
                System.out.println(value);
            }
            System.out.println("-----------------");

        }

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
