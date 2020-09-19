package day1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
java.io.OutputStreamWriter extends Writer
字符通向字节的桥梁，可使用指定的charset将要写入流中的字符编码成字节。(编码：把能看懂的变成看不懂的)
继承自父类共性的成员方法：
void write(int c) 写入单个字符
void write(char[] cbuf) 写入字符数组
abstract void write(char[] cbuf,int off,int len) 写入字符数组的某一部分 off数组的开始索引，len写的字符的个数
void write(String str)写入字符串
void write(String str,int off,int len)写入字符串的某一部分，off字符串的开始索引，len写的字符个数
void flush()刷新该流的缓冲
void close()关闭此流，但要先刷新他

构造方法
OutputStreamWriter(OutputStream out) 创建使用默认的字符编码的OutputStreamWriter
OutputStreamWriter(OutputStream out,String charsetname) 创建使用指定字符集的OutputStreamWriter
参数：
OutputStream：字节输出流，可以用来写转换后字节到文件中
String charsetname：指定的编码表名称，不区分大小写，可以是utf-8/UTF-8,GBK/gbk... 不指定使用utf-8

使用步骤
1、创建OutputStreamWriter对象，构造方法中传递字节输出流和指定的编码名称
2、使用OutputStreamWriter对象中的方法write,把字符转换为字节，存储到缓冲区中(编码)
3、使用OutputStreamWriter对象中的方法flush,把内存缓冲区中的字节刷新的文件中(使用字节流写字节的过程)
4、释放资源
 */
public class Demo01OutputStreamWrite {
    public static void main(String[] args) throws IOException {
//        write_utf_8();
          write_gbk();
    }

    private static void write_gbk() throws IOException {
        //        1、创建OutputStreamWriter对象，构造方法中传递字节输出流和指定的编码名称
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("gbk_8.txt"),"gbk");// 不写默认使用"utf-8"编码模式
//        2、使用OutputStreamWriter对象中的方法write,把字符转换为字节，存储到缓冲区中(编码)
        osw.write("你好");
//        3、使用OutputStreamWriter对象中的方法flush,把内存缓冲区中的字节刷新的文件中(使用字节流写字节的过程)
        osw.flush();
//        4、释放资源
        osw.close();
    }

    /*
    使用转换流OutputStreamWriter写UTF-8格式的文件
     */
    private static void write_utf_8() throws IOException {
        //        1、创建OutputStreamWriter对象，构造方法中传递字节输出流和指定的编码名称
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("utf_8.txt"));// 不写默认使用"utf-8"编码模式
//        2、使用OutputStreamWriter对象中的方法write,把字符转换为字节，存储到缓冲区中(编码)
        osw.write("你好");
//        3、使用OutputStreamWriter对象中的方法flush,把内存缓冲区中的字节刷新的文件中(使用字节流写字节的过程)
        osw.flush();
//        4、释放资源
        osw.close();
    }
}
