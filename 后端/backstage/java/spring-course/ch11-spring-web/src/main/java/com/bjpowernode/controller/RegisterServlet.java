package com.bjpowernode.controller;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String strId = request.getParameter("id");
        String strName = request.getParameter("name");
        String strEmail = request.getParameter("email");
        String strAge = request.getParameter("age");

        // 3 种情况创建
        // 创建spring的容器对象 11111
//        String config = "applicationContext.xml";
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(config);
//        System.out.println("容器对象的信息====="+ctx);
        WebApplicationContext ctx = null;
        // 获取servletContext中的容器对象，创建好的容器对象，拿来就用 22222
       /* String key = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        Object attr = getServletContext().getAttribute(key);
        if (attr != null){
            ctx = (WebApplicationContext)attr;
        }*/

        // 使用框架中的方法，获取容器对象 33333
        ServletContext sc = getServletContext();
        ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
        System.out.println("容器对象的信息===========" + ctx);

        // 获取service
        StudentService service = (StudentService) ctx.getBean("studentService");
        Student student = new Student();
        student.setId(Integer.parseInt(strId));
        student.setName(strName);
        student.setEmail(strEmail);
        student.setAge(Integer.valueOf(strAge));
        service.addStudent(student);
        // 给一个页面
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
