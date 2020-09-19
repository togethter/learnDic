package day6;

import java.nio.file.FileAlreadyExistsException;

/*
java.io.file类
文件和目录路径名的抽象表示形式
java把电脑中的文件和文件夹封装成了一个File类，我们可以使用file类对文件和文件夹进行操作
我们可以使用File的方法
创建一个文件/文件夹
删除文件/文件夹
获取文件夹/文件
判断文件/文件夹是否存在
对文件夹进行遍历
获取文件的大小
File类是一个与系统无关的类
任何操作系统都可以使用这个类中的方法

重点：记住三个单词
file:文件
directory:文件夹
path:路径

 */
public class File {
    public File(String s) {
    }

    public static void main(String[] args) {
        /*
        static String pathSeparator 与系统有关的路径分隔符，为了方法，它被表示为一个字符串
        static String pathSeparatorChar 与系统有关的路径分隔符
        static String Separator 与系统有关的默认名称分隔符，为了方便，他被表示为一个字符串
        static String SeparatorChar 与系统有关的默认名称分隔符

         操作路径：不能写死了
         window: c:\develop\a\a.txt
         linux:  c:/develop/a/a.txt
         "c:"+java.io.File.separator + "develop" + java.io.File.separator + "a" + java.io.File.separator + "a" + ".txt"
         */

        String pathSeparator = java.io.File.pathSeparator;
        System.out.println(pathSeparator); // `:` 路径分隔符 ， window系统是`;` linux系统是`:`
        String sp = java.io.File.separator;
        System.out.println(sp); // `/ `文件名称分隔符 window系统是`/` linux系统是`/`



    }
}
