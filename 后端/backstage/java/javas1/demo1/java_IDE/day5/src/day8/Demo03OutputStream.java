package day8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*

追加写/续写：使用两个参数的构造方法
FileOutputStream(String name,boolean append) 创建一个向具有指定name的文件中写入数据的输出文件流
FileOutputStream(File file,boolean append) 创建一个指向具有指定File对象表示的文件中写入数据的文件输出流
参数
String name, File file写入数据的目的地
boolean append 追加写开关
true：创建对象不会覆盖源文件，继续在文件的末尾追加写数据
false:创建一个新文件覆盖源文件
写换行:写换行符号
window: \r \n
linux: /n
mac /r
 */
public class Demo03OutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fops = new FileOutputStream("/Users/gd/Desktop/NH/github/learnDic/后端/java/java_IDE/3.txt", true);
        for (int i = 0; i < 10; i++) {
            fops.write("你好".getBytes());
            fops.write("\n".getBytes());
        }
        fops.close();
    }

}
