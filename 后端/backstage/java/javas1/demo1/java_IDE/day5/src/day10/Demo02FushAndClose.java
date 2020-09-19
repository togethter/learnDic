package day10;

import java.io.FileWriter;
import java.io.IOException;

/*
 fush方法和close方法的区别
 -fush:刷新缓冲区，流对象可以继续使用
 -close先刷新缓冲区，然后通知系统释放资源，流对象不可以在被使用
 */
public class Demo02FushAndClose {
    public static void main(String[] args) throws IOException {
        //        1、创建FileWrite对象，构造方法中绑定要写入数据的目的地
        FileWriter fw = new FileWriter("1.txt");
//        2、使用FileWrite中的方法write,把数据写入到内存缓冲区中(字符转换字节的过程)
//        void write(int c) 写入单个字符
        fw.write(97);
        fw.write(99);
//        3、使用FileWrite中的方法Flush，把内存缓冲区的数据，刷新到文件中
        fw.flush();
//        4、释放资源(会先把内存缓冲区的数据刷新到文件中)
        fw.close();
    }
}
