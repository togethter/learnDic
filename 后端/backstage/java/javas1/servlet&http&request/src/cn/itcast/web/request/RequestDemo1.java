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
@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /*
    			    1、获取请求方式：GET
						* String getMethod()
					2、(*)获取虚拟目录：/day
						* String getContextPath()
					3、获取Servlet路径：/requestDemo1
						* String getServletPath()
					4、获取get方式的请求参数：name=zhangsan
						 * String getQueryString()
					5、(*)获取请求的URI:
						* String getRequestURI()：/day/requestDemo1
						* String getRequestURL()：http://localhost:8080/day/requestDemo1
					6、获取协议和版本： HTTP/1.1
						* String getProtocol()
					7、获取客户机的IP地址：0:0:0:0:0:0:0:1
					 	* String getRemoteAddr()
     */
        // 1、获取请求方式：GET
        String method = request.getMethod();
        System.out.println(method);
        //2、(*)获取虚拟目录：/day
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //3、获取Servlet路径：/requestDemo1
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        //4、获取get方式的请求参数：name=zhangsan
        String queryString = request.getQueryString();
        System.out.println(queryString);
        //5、(*)获取请求的URI:
        String requestURI = request.getRequestURI();// /day/requestDemo1
        System.out.println(requestURI);
        // 、获取全路径
        StringBuffer requestURL = request.getRequestURL();// http://localhost:8080/day/requestDemo1
        System.out.println(requestURL);
        //6、获取协议和版本： HTTP/1.1
        String protocol = request.getProtocol();
        System.out.println(protocol);
        //7、获取客户机的IP地址：0:0:0:0:0:0:0:1
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);



    }
}
