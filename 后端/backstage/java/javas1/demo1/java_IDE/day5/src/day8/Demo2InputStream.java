package day8;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/*
字节输入流一次读取多个字节的方法
int read(byte[] b) 从输入流一次读取一定数量的字节，并将其存储到缓冲区数组b中。
明确两件事
1方法的参数byte[]作用?
起到缓冲作用，存储每次读取到的多个字节
数组的长度一般定义为1024(1kb)或者1024的整数倍
2方法的返回值int是什么?
每次读取到的有效字节个数
String类的构造方法
Stirng(byte[] bytes) 把字节数组转换为字符串
Stirng(byte[] bytes，int offset,int Length) 把字节数组的一部分转换为字符串 offset：数组的开始索引 Length：转换的字节个数


 */
public class Demo2InputStream {
    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();
        //创建fileInputStream对象，构造方法中绑定要读取的数据
        FileInputStream fis = new FileInputStream("2.txt");
        // 使用FileInputStream对象中的方法read读取文件
//        int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储到缓冲区数组b中。
        byte[] bytes = new byte[1024]; // 存储读取到的多个字节
//        int len = fis.read(bytes);
//        System.out.println(len);
//        System.out.println(Arrays.toString(bytes));//[-28, -67]
//        System.out.println(new String(bytes)); // AB
//
//        len = fis.read(bytes);
//        System.out.println(len); // 1
//        System.out.println(Arrays.toString(bytes));//[67, 66]
//        System.out.println(new String(bytes)); // CB
//
//        len = fis.read(bytes);
//        System.out.println(len); // -1
//        System.out.println(Arrays.toString(bytes));//[67, 66]
//        System.out.println(new String(bytes)); // CB

        int len = 0; // 记录每次读取的有效字节个数
        while ((len = fis.read(bytes)) != -1) {
//            Stirng(byte[] bytes，int offset,int Length)
            System.out.println(new String(bytes,0,len));
        }
        // 释放资源
        fis.close();
        Long e = System.currentTimeMillis();
        System.out.println("复制文件共耗时:"+(e-s)+ "毫秒");
    }
}
