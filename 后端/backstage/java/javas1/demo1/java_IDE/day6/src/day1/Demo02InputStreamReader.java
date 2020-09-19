package day1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
java.io.InputStreamReader extends Reader
InputStreamReader:是字节流通向字符流的桥梁，他使用指定的charseet 读取字节并将其解码为字符。（解码：把看不懂的变成能看懂的）
int read(),从输入流中读取数据的下一个字节
int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中
void close() 关闭此输入流并释放与该流关联的所有的系统资源

构造方法：
1、InputStreamReader(InputStream in)创建一个使用默认字符集的InputStreamReader
2、InputStreamReader(InputStream in,String charsetname)创建使用指定字符集的InputStreamReader
参数：
InputStream in：字节输入流，用来读取文件中保存的字节
String charsetname：指定的编码表名称，不区分大小写，可以是utf-8/UTF-8,GBK/gbk... 不指定使用utf-8
使用步骤
1、创建InputStreamReader对象，构造方法中传递字节输入流和指定的编码名称
2、使用InputStreamReader对象的方法read读取文件
3、释放资源
注意事项
构造方法中指定的编码名称要和文件中的编码名称相同，否则会发生乱码

 */
public class Demo02InputStreamReader {
    public static void main(String[] args) throws IOException {
//        read_utf_8();
        read_gdk();
    }

    private static void read_gdk() throws IOException {
        //        1、创建InputStreamReader对象，构造方法中传递字节输入流和指定的编码名称
        InputStreamReader isr = new InputStreamReader(new FileInputStream("gbk_8.txt"),"gbk");// 不使用默认使用utf-8
//        2、使用InputStreamReader对象的方法read读取文件
        int len = 0;
        while ((len = isr.read())!= -1) {
            System.out.println((char) len);
        }
//        3、释放资源
        isr.close();
    }

    /*
    使用InputStreamReader读取utf_8文件
     */
    private static void read_utf_8() throws IOException {
//        1、创建InputStreamReader对象，构造方法中传递字节输入流和指定的编码名称
        InputStreamReader isr = new InputStreamReader(new FileInputStream("utf_8.txt"));// 不使用默认使用utf-8
//        2、使用InputStreamReader对象的方法read读取文件
        int len = 0;
        while ((len = isr.read())!= -1) {
            System.out.println((char) len);
        }
//        3、释放资源
        isr.close();
    }
}
