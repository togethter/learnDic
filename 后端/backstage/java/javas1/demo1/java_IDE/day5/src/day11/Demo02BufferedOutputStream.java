package day11;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
java.io.bufferedOutputStream extends OutputStream
BufferedOutputStream
继承自父类共性成员方法：
void write(int c) 写入单个字符
void write(char[] cbuf) 写入字符数组
abstract void write(char[] cbuf,int off,int len) 写入字符数组的某一部分 off数组的开始索引，len写的字符的个数
void write(String str)写入字符串
void write(String str,int off,int len)写入字符串的某一部分，off字符串的开始索引，len写的字符个数
void flush()刷新该流的缓冲
void close()关闭此流，但要先刷新他
构造方法 BufferedOutputStream(OutputStream out) 创建一个新的缓冲输出流，以将数据写入底层的输出流
        BufferedOutputStream(OutputStream out,int size) 创建一个新的缓冲输出流，以将具有指定缓冲区大小的数据写入底层的输出流
        参数 OutputStream: 字节输出流
                我们可以传递FileOutstream,缓冲流会给FileOutstream增加一个缓冲区，提高FileOutstream的写入效率
          int size：指定缓冲流内部缓冲区的大小，不指定默认
使用步骤(重点)
1、创建FileOutputStream对象，构造方法中绑定要输出的目的地
2、创建BufferedOutputStream对象，构造方法创建FileOutstream对象，提高FileOutstream对象的效率
3、使用BufferedOutputStream对象的方法write，把数据写入到内部缓冲区中
4、使用BufferedOutputStream对象的方法flush,内部缓冲区的数据，刷新到文件中
5、释放资源(先调用flush刷新数据，第四部可以省略)
 */
public class Demo02BufferedOutputStream {
    public static void main(String[] args) throws IOException {
//        1、创建FileOutputStream对象，构造方法中绑定要输出的目的地
        FileOutputStream fos = new FileOutputStream("6.txt");
//        2、创建BufferedOutputStream对象，构造方法创建FileOutstream对象，提高FileOutstream对象的效率
        BufferedOutputStream bos = new BufferedOutputStream(fos);
//        3、使用BufferedOutputStream对象的方法write，把数据写入到内部缓冲区中
        bos.write("我把数据写入到内部缓冲区中".getBytes());
//        4、使用BufferedOutputStream对象的方法flush,内部缓冲区的数据，刷新到文件中
        bos.flush();
//        5、释放资源(先调用flush刷新数据，第四部可以省略)
        bos.close();


    }
}
