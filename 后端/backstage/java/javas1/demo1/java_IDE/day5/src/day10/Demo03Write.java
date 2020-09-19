package day10;

import java.io.FileWriter;
import java.io.IOException;

/*
字符输出流写数据的其他方法
void write(char[] cbuf) 写入字符数组
abstract void write(char[] cbuf,int off,int len) 写入字符数组的某一部分，off数组的开始索引，lenx写的字符个数
void write(String str)写入字符串
void write(String str,int off,int len)写入字符串的某一部分，off字符串的开始索引，len写的字符个数
 */
public class Demo03Write {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("4.txt");
        char[] cs = {'a', 'b', 'c', 'd', 'e'};
//        void write(char[] cbuf) 写入字符数组
        fw.write(cs);
//        void write(char[] cbuf,int off,int len)
        fw.write(cs, 1, 3);
        fw.close();

    }
}
