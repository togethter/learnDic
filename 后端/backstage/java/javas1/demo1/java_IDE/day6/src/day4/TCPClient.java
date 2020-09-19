package day4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
TCP通信的客户端：向服务器发送的连接请求，给服务器发送数据，读取服务器回写的数据
表示客户端的类：
java.net.Socket:此类实现类客户端的套接字(也可以叫"套接字")。套接字是两台机器间通信的端点
套接字：包括了IP地址和端口号的网络单位
构造方法
socket(String host,int port) 创建一个流套接字并将其连接到指定主机上的指定端口号
参数
String host:服务器主机的名称/服务器的ip地址
int port:服务器的端口号
成员方法
OutputStream getOutputStream() 返回套接字输出流
InputStream getInputStream() 返回套接字输入流
void close()关闭此套接字
实现步骤：
1、创建一个客户端对象socket,构造方法绑定服务器的ip地址和端口号
2、使用socket对象中的方法getOutputStream()获取网路输出流OutputStream对象
3、使用网络字节输出流OutputStream对象中的方法write，给服务器发送数据
4、使用socket对象中的方法getInputStream()获取网络输入流InputStream对象
5、使用网络字节输入流InputStream对象中的方法read,读取服务器回写的数据
6、释放资源(socket)
注意：
1、客户端和服务端进行交互，必须使用socket提供的网络流，不能使用自己创建的流对象
2、当我们创建客户端的对象的Socket的时候，就会请求服务器和服务器进行3此握手建立连接通路
        这时如果服务器没有启动就会抛出异常ConnectException: Connection refused (Connection refused)
        如果服务器已经启动，就可以进行交互了
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
//        1、创建一个客户端对象socket,构造方法绑定服务器的ip地址和端口号
        Socket socket = new Socket("127.0.0.1",8888);
//        2、使用socket对象中的方法getOutputStream()获取网路输出流OutputStream对象
        OutputStream ops = socket.getOutputStream();
//        3、使用网络字节输出流OutputStream对象中的方法write，给服务器发送数据
        ops.write("你好服务器".getBytes());
//        4、使用socket对象中的方法getInputStream()获取网络输入流InputStream对象
        InputStream is = socket.getInputStream();
//        5、使用网络字节输入流InputStream对象中的方法read,读取服务器回写的数据
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes, 0, len));
//        6、释放资源(socket)
        ops.close();
    }
}
