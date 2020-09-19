package day10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
JDK7的新特性
在try的后边可以增加一个括号(),在括号中可以定义流对象，
那么这个流对象的作用域就在try中有效，try中的代码执行完毕，
会自动把流对象释放，不用谢finally
格式
try (定义流对象,定义流对象...){
可能会长生异常的代码
} catch(异常类的变量 ){
异常的处理逻辑
}
 */
public class Demo06JDK7 {

    public static void main(String[] args) {
        try (    //        1、创建一个字节输入流对象，构造方法中绑定要读取的数据源
                 FileInputStream fis = new FileInputStream("5.txt");
                 //        2、创建一个字节输出流对象，构造方法中绑定要写入的目的地
                 FileOutputStream fops = new FileOutputStream("2.txt");) {
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
            while ((len = fis.read(bytes)) != -1) {
//            4、使用字节输出流中的方法write，把读取到的字节写入到目的地的文件中
                fops.write(bytes, 0, len);
            }

//        5、释放资源（先关写的，在管读的）
            fops.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
