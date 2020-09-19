package day4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
TCP通信的服务器端：接收客户端的请求，读取客户端发送的数据，给客户端回写数据
表示服务器的类
java.net.ServerSocket:此类实现服务器套接字
构造方法
ServerSocket(int port) 创建绑定到特定端口号服务器套接字
服务器端必须明确的一件事情，必须知道是哪个客户端请求的服务器
所以可以使用accept方法获取到请求的客户端对象Socket
成员方法：
Socket accept()侦听并接受到此套接字的连接
服务器的实现步骤：
1、创建服务器ServerSocket对象和系统要指定的端口号
2、使用ServerSocket对象中的方法accept,获取到请求的客户端对象socket
3、使用socket对象中的方法getInputStream()获取网络输入流InputStream对象
4、使用网络输入流InputStream对象中的方法read读取客户端发送的数据
5、使用socket对象中的方法getOutputStream()获取网路输出流OutputStream对象
6、使用网路输出流OutputStream对象中的方法write，给客户端回写数据
7、释放资源(Socket,ServerSocket)
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
//        1、创建服务器ServerSocket对象和系统要指定的端口号
        ServerSocket sst = new ServerSocket(8888);
//        2、使用ServerSocket对象中的方法accept,获取到请求的客户端对象socket
        Socket accept = sst.accept();
//        3、使用socket对象中的方法getInputStream()获取网络输入流InputStream对象
        InputStream is = accept.getInputStream();
//        4、使用网络输入流InputStream对象中的方法read读取客户端发送的数据
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes, 0, len));
//        5、使用socket对象中的方法getOutputStream() 获取网路输出流OutputStream对象出流OutputStream对象
        OutputStream ops = accept.getOutputStream();
//        6、使用网路输出流OutputStream对象中的方法write，给客户端回写数据
        ops.write("你好收到了".getBytes());
//        7、释放资源(Socket,ServerSocket)
        ops.close();
        is.close();
    }
}
