package day10;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
java.io.Write字符输出流，是所有字符输出流最顶层的父类，是一个抽象类
共性的成员方法
void write(int c) 写入单个字符
void write(char[] cbuf) 写入字符数组
abstract void write(char[] cbuf,int off,int len) 写入字符数组的某一部分 off数组的开始索引，len写的字符的个数
void write(String str)写入字符串
void write(String str,int off,int len)写入字符串的某一部分，off字符串的开始索引，len写的字符个数
void flush()刷新该流的缓冲
void close()关闭此流，但要先刷新他
java.io.FileWriter extends OutputStreamWrite extends Writer
FileWriter：文件字符输出流
作用：内存中的字符数据写入到文件中
构造方法：
FileWriter(File file) 根据给定的file对象，构造一个FileWriter对象
FileWriter(String filename) 根据给定的文件路径，构造一个fileWrite对象

参数：写入数据的目的地
        String filename 文件的路径
        File file 文件
构造方法的作用
    1、会创建一个FileWrite对象
    2、会根据构造方法中传递的文件/文件的路径，创建文件
    3、会把创建好的FileWriter指向创建好的文件

字符串出流的使用步骤(步骤)
1、创建FileWrite对象，构造方法中绑定要写入数据的目的地
2、使用FileWrite中的方法write,把数据写入到内存缓冲区中(字符转换字节的过程)
3、使用FileWrite中的方法Flush，把内存缓冲区的数据，刷新到文件中
4、释放资源(会先把内存缓冲区的数据刷新到文件中)


 */
public class Demo01Write {
    public static void main(String[] args) throws IOException {
//        1、创建FileWrite对象，构造方法中绑定要写入数据的目的地
        FileWriter fw = new FileWriter("1.txt");
//        2、使用FileWrite中的方法write,把数据写入到内存缓冲区中(字符转换字节的过程)
//        void write(int c) 写入单个字符
        fw.write(97);
//        3、使用FileWrite中的方法Flush，把内存缓冲区的数据，刷新到文件中
        fw.flush();
//        4、释放资源(会先把内存缓冲区的数据刷新到文件中)
        fw.close();
    }
}
