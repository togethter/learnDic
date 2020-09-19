package day10;

import java.io.FileWriter;
import java.io.IOException;

/*
续写和换行
续写，追加写：使用两个参数的构造方法，
FileWrite(String fileName,boolean append)
FileWrite(File file,boolean append)
参数
String filename,File file写入数据的目的地
boolean append 续写开关 true：不会创建新的文件覆盖源文件，可以续写，false：创建新文件覆盖源文件
换行：换行符号
window:\r\n
linux:/n
mac:/r

 */
public class Demo04Write {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("5.txt",true);
        for (int i = 0; i < 10; i++) {
            fw.write("HelloWorld" + i + "\n");
        }
        fw.close();
    }
}
