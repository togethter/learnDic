package day10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
JDK9新特性
try前面可以定义流对象，在try后边的()可以直接引入流对象的名称(变量名)
在try代码执行完毕后，流对象也可以直接释放掉，不用写finally
格式:
A a = new A();
B b = new B();
try(a,b){
可能会长生异常的代码
} catch(异常类的变量 ){
异常的处理逻辑
}
 */
public class Demo07JDK9 {
    public static void main(String[] args) throws FileNotFoundException {
        //        1、创建一个字节输入流对象，构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("1.txt");
//        2、创建一个字节输出流对象，构造方法中绑定要写入的目的地
        FileOutputStream fops = new FileOutputStream("2.txt");
        try (fis; fops) {
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
