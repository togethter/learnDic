package day11;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
java.io.BufferedWrite extends Write
BufferedWrite：字符缓冲输出流
继承自父类的共性成员方法：
void write(int c) 写入单个字符
void write(char[] cbuf) 写入字符数组
abstract void write(char[] cbuf,int off,int len) 写入字符数组的某一部分 off数组的开始索引，len写的字符的个数
void write(String str)写入字符串
void write(String str,int off,int len)写入字符串的某一部分，off字符串的开始索引，len写的字符个数
void flush()刷新该流的缓冲
void close()关闭此流，但要先刷新他

构造方法
BufferedWrite(Write out) 创建一个使用默认大小输出缓冲区的缓冲字符输出流
BufferedWrite(Write out,int sz) 创建一个使用给定大小输出缓冲区新缓冲字符输出流
参数
    Write out:字符输出流
        我们可以传递FileWrite，缓冲流会给FileWriter增加一个缓冲区，提高FileWriter的写入效率
    int sz：指定缓冲区的大小，不写默认大小

    特有的成员方法
    void newLine() 写一个行分隔符。会根据不同的操作系统，会获取不同的行分隔符
    换行：换行符号
    window:\r\n
    Linux:/n
    mac:/r
    newLine();
使用步骤
1、创建字符缓冲输出流对象，构造方法中传递字符输出流
2、调用字符缓冲输出流的方法write,把数据写入内存缓冲区中
3、调用字符缓冲输出流的方法flush,把内存缓冲区的数据，刷新到文件中
4、释放资源
 */
public class Demo04BufferedWrite {
    public static void main(String[] args) throws IOException {
//        1、创建字符缓冲输出流对象，构造方法中传递字符输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("6.txt"));
//        2、调用字符缓冲输出流的方法write,把数据写入内存缓冲区中
        for (int i = 0; i < 10; i++) {
            bw.write("传智播客" + i);
//            bw.write("\n");
            bw.newLine();
        }
//        3、调用字符缓冲输出流的方法flush,把内存缓冲区的数据，刷新到文件中
        bw.flush();
//        4、释放资源
        bw.close();

    }

}
