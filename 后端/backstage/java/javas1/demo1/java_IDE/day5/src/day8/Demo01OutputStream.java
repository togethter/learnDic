package day8;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
java.io.OutputStream:
次抽象类是表示输出字节流的所有类的超类
定义了一些子类共性的成员方法
public void close():关闭此输出流并释放与此流相关联的任何系统资源
public void flush:刷新此输出流并强制任何缓冲的输出字节被写出
public void write(byte[] b):将b.length字节从指定的字节数组写入此输出流
public void write(byte[] b，int off,int len):从指定的字节数组写入 len字节，从偏移量off开始输出到此输出流
public abstract void write(int b):从指定的字节输出流
java.io.FileOutputStream extends OutputStream
FileOutputStream:文件字节输出流
作用：把内存中的数据写到硬盘文件中

构造方法：
FileOutputStream(string name) 创建一个向具有指定名称的文件中写入数据的输出文件流
FileOutputStream(File file) 创建一个向具有指定file对象表示的文件中写入数据的文件输出流
 参数：写入数据的目的地
 string name：目的地是一个文件的路径
 File file：目的地是一个文件
 构建方法的作用
 1、创建一个FileOutputStream对象。
 2、会根据构造方法中传递的文件或者文件路径，创建一个空的文件
 3、会把FileOutputStream对象指向创建好的文件

 写入数据的原理(内存->硬盘)
 java程序->JVM(java虚拟机)->os(操作系统)->调用写数据的方法->把数据写入文件中

 字节输出流的使用步骤(重点)
 1、创建一个FileOutputStream的对象，构造方法中传递写入数据的目的地
 2、调用FileOutputStream对象的方法write把数据写入到文件中
 3、释放资源(流使用会占用补一份内存，使用完毕会把内存清空，提高程序的效率)
 */
public class Demo01OutputStream {

    public static void main(String[] args) throws IOException {
//            1、创建一个FileOutputStream的对象，构造方法中传递写入数据的目的地
        FileOutputStream fops = new FileOutputStream("/Users/gd/Desktop/NH/github/learnDic/后端/java/java_IDE/1.txt");
//        2、调用FileOutputStream对象的方法write把数据写入到文件中
        fops.write(97);
//        3、释放资源(流使用会占用补一份内存，使用完毕会把内存清空，提高程序的效率)
        fops.close();

    }

}
