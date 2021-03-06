package day5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/*
文件上传案例服务器端，读取客户端上传的文件，保存到服务器的硬盘，给客户端回写上传"成功"
明确：
数据源:客户端上传的文件
目的地：服务器的硬盘
实现步骤
1、创建一个服务器ServerSocket对象和系统指定的端口号
2、使用ServerSocket对象中的方法accept获取到请求的客户端Socket对象
3、使用Socket对象中的方法getInputStream，获取网络输入流InputStream对象
4、判断d:下的文件夹是否存在，如果不存在则创建
5、创建一个本地字节输出流FileOutputStream对象，构造方法中要输出的目的地
6、使用网络字节输入流InputStream对象中的方法read，读取客户端上传的文件
7、使用本地字节输出流FileOutputStream对象中的方法write,把读取的文件保存到服务器的硬盘上
8、使用ServerSocket对象中的方法getOutputStream,获取到网络输出流OutputStream对象
9、使用网络输出流OutputStream对象中的方法write，给客户端回写上传成功
10、释放资源（FileOutputStream，Socket，ServerSocket）
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws IOException {
//        1、创建一个服务器ServerSocket对象和系统指定的端口号
        ServerSocket server = new ServerSocket(8888);
//        2、使用ServerSocket对象中的方法accept获取到请求的客户端Socket对象
        /*
        让服务器一直处于监听状态(死循环accept方法)
        有一个客户端上传一个文件就保存一个文件
         */
        while (true) {
            Socket socket = server.accept();
            /*
            使用多线程提高程序的效率
            有一个客户端上传一个文件，就开启一个线程，完成文件的上传
             */
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
//         3、使用Socket对象中的方法getInputStream，获取网络输入流InputStream对象
                        InputStream is = socket.getInputStream();
//        4、判断d:下的文件夹是否存在，如果不存在则创建
                        File file = new File("upload");
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        System.out.println("哈哈哈哈哈");
        /*
        自定义一个文件的命名规则：防止同名的文件被覆盖掉
        规则：域名+毫秒值+随机数

         */
                        String filename = "/itcast" + System.currentTimeMillis() + new Random().nextInt(999999) + ".jpg";
                        socket.getOutputStream().write("确定接收客户端的数据...".getBytes());
//        5、创建一个本地字节输出流FileOutputStream对象，构造方法中要输出的目的地
                        FileOutputStream fos = new FileOutputStream(file + filename);
//        6、使用网络字节输入流InputStream对象中的方法read，读取客户端上传的文件
                        int len = 0;
                        byte[] bytes = new byte[1024];
        /*1111111
        读取客户端上传的文件，永远也读取不到文件的结束标志
        read方法进入到阻塞状态，一直死循环等待结束标记
         */
                        while ((len = is.read(bytes)) != -1) {
//            7、使用本地字节输出流FileOutputStream对象中的方法write,把读取的文件保存到服务器的硬盘上
                            fos.write(bytes, 0, len);
                        }
        /*2222222
         8，9，10代码就不会执行到，也不会给客户端回写上传成功
         */
//        8、使用ServerSocket对象中的方法getOutputStream,获取到网络输出流OutputStream对象
//        9、使用网络输出流OutputStream对象中的方法write，给客户端回写上传成功
                        socket.getOutputStream().write("服务端已经接收完客户端的数据，上传成功。88".getBytes());
                        fos.close();
                        socket.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();

        }
        // 服务器就不用关闭了
//        server.close();


    }
}
