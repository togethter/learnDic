package day6;

import java.io.File;

/*
绝对
绝对路径：是一个完整的路径
     以盘符(c:,d:)开始的路径
     c:\\a.txt
     c:\\Users\\itcast\\IdeaProjects\\shungyuan\\123.txt
     d:\\demo\\b.txt
相对路径：是一个简化的路径
    相对指的是相对于当前项目的跟目录 c:\\Users\\itcast\\IdeaProjects\\shungyuan
    如果使用当前项目的更目录，路径可以简化书写
    c:\\Users\\itcast\\IdeaProjects\\shungyuan\\123.txt --->简化为123.txt(可以省略项目的根目录)
    注意：
        1、路径是不区分大小写的
        2、路径中的文件名称分割符windows使用反斜杠，反斜杠是转义字符，两个反斜杠代表一个普通的反斜杠
 */
public class Demo01File {
    public static void main(String[] args) {
        /*
        File类的构造方法
         */
        show03();
    }

    /*File(File parent,String child) 根据parent 路径字符串和child路劲字符串创建一个新的file实例
    * 参数：路径分成了两部分
    * File parent:父路径
    * child:子路径
    * 好处：
    * 父路径和子路径，可以单独书写，使用起来非常灵活，父路径和子路径都可以变化
    * 父路径是file类型，可以使用File方法对路径进行一些操作，在使用路径创建对象
    * */
    private static void show03() {
        File parent = new File("c://");
        File file = new File(parent,"hello.java");
        System.out.println(file);
    }

    /*
    * File(String parent,String child) 根据parent 路径字符串和child路劲字符串创建一个新的file实例
    * 参数：路径分成了两部分
    * String parent:父路径
    * String child:子路径
    * 父路径和子路径，可以单独书写，使用起来非常灵活，父路径和子路径都可以变化
    * */
    private static void show02(String parent,String child) {
        File file = new File(parent,child);
        System.out.println(file);
    }

    /*
    File(String pathname) 通过将给定的路径的名字字符串转换为抽象路径名来创建一个新File实例
    参数：
        String pathname:字符串的路径名称
        路径可以是以文件结尾，也可以是以文件夹结尾
        路径可以是相对路径，也可以是绝对路径
        路径可以是存在的，也可以是不存在的
        创建File对象只是把字符串路径封装为File对象，不考虑路径的真假情况
     */
    private static void show01() {
        File file = new File("/Users/gd/Desktop/未命名文件夹");
        System.out.println(file); // 重写了Object类的toString方法

        File file2 = new File("b.txt");
        System.out.println(file2); // 重写了Object类的toString方法

    }
}
