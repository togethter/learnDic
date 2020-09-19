package cn.itcast.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int width = 100;
        int height = 50;
        // 1、创建一个对象，在内存中图片(验证码的图片对象)
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        // 2、美化图片
        // 2.1填充背景色
        Graphics g = image.getGraphics();// 画笔对象
        g.setColor(Color.pink); // 设置画笔颜色
        g.fillRect(0,0,width,height);
        // 2.2画边框
        g.setColor(Color.blue);
        g.drawRect(0,0,width-1,height-1);
        String str = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        Random ran = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 1; i <= 4; i++) {
            // 生成随机交表
            int index = ran.nextInt(str.length());
            // 获取字符
            char ch = str.charAt(index);// 随机字符
            sb.append(ch);
            // 2.3写验证码
            g.drawString(ch+"",width/5 * i,height/2);
        }
        String checkCode_session = sb.toString();
        // 将验证码存入session
        request.getSession().setAttribute("checkCode_session",checkCode_session);
        // 2.4画干扰线
        g.setColor(Color.green);
        for (int i1 = 0; i1 < 10; i1++) {
            // 随机生成坐标点
            int x  = ran.nextInt(width);
            int x1 = ran.nextInt(width);
            int y = ran.nextInt(height);
            int y1 = ran.nextInt(height);
            g.drawLine(x,x1,y,y1);
        }
        // 3、将图片输出到页面中展示
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
