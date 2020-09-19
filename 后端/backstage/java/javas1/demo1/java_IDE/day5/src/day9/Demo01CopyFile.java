package day9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
文件复制练习:一读一写
明确：
    数据源：c://1.jpg
    数据的目的地：d://1.jpg
    文件复制的步骤
    1、创建一个字节输入流对象，构造方法中绑定要读取的数据源
    2、创建一个字节输出流对象，构造方法中绑定要写入的目的地
    3、使用字节输入的方法read读取文件
    4、使用字节输出流中的方法write，把读取到的字节写入到目的地的文件中
    5、释放资源
 */
public class Demo01CopyFile {
    public static void main(String[] args) throws IOException {
//        1、创建一个字节输入流对象，构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("1.txt");
//        2、创建一个字节输出流对象，构造方法中绑定要写入的目的地
        FileOutputStream fops = new FileOutputStream("2.txt");
         //读取一个字节写入一个字节的方式
//        3、使用字节输入的方法read读取文件
//        int len = 0;
//        while ((len = fis.read()) != -1){
////            4、使用字节输出流中的方法write，把读取到的字节写入到目的地的文件中
//            fops.write(len);
//        }
        // 使用数组缓冲 读取多个字节 写入多个字节
        byte[] bytes = new byte[1024];
//        3、使用字节输入的方法read读取文件
        int len = 0; // 每次读取有效字节个数
        while ((len = fis.read(bytes))!= -1) {
//            4、使用字节输出流中的方法write，把读取到的字节写入到目的地的文件中
                fops.write(bytes,0,len);
        }

//        5、释放资源（先关写的，在管读的）
        fops.close();
        fis.close();

    }
}
