package day6;

import java.io.File;

/*
File类获取功能的方法
    -public String getAbsolutePath() 返回此File的绝对路劲名字符串
    -public String getPath() 将此File转换为路径名字符串
    -public String getName() 返回由此File表示的文件或目录的名称
    -public Long length() 返回由此File表示的文件的长度
 */
public class Demo02File {
    public static void main(String[] args) {
        show04();
    }

    /*
     * -public Long length() 返回由此File表示的文件的长度
     *  获取的是构造方法指定的文件的大小，以字节为单位
     * 注意：
     * 文件夹没有大小概念的，不能获取文件夹大小
     * 如果构造方法中给出的路径不存在，那么Length方法返回0
     * */
    private static void show04() {
    File f1 = new File("/Users/gd/Desktop/dd.png");
        long lg = f1.length();
        System.out.println(lg); // 2105370 字节
        File f2 = new File("/Users/gd/Desktop/dd1.png");
        long lg2 = f2.length();
        System.out.println(lg2);// 0
        File f3 = new File("/Users/gd/Desktop/");
        long lg3 = f3.length();
        System.out.println(lg3);// 0 文件夹没有大小概念

    }

    /*
     * -public String getName() 返回由此File表示的文件或目录的名称
     * 获取的就是构造方法传递路径的结尾部分(文件/文件夹)
     *
     * */
    private static void show03() {
        File f1 = new File("/Users/gd/Desktop/NH/github/learnDic/后端/java/java_IDE");
        System.out.println(f1.getName());
        File f2 = new File("/Users/gd/Desktop/NH/github/learnDic/后端");
        System.out.println(f2.getName());
    }

    /*
     * -public String getPath() 将此File转换为路径名字符串
     * 获取的构造方法中传递的路径
     *
     * */
    private static void show02() {
        File f1 = new File("/Users/gd/Desktop/NH/github/learnDic/后端/java/java_IDE");
        File f2 = new File("a.txt");
        System.out.println(f1.getPath());// /Users/gd/Desktop/NH/github/learnDic/后端/java/java_IDE
        System.out.println(f2.getPath());// a.txt
    }

    /*
    -public String getAbsolutePath() 返回此File的绝对路劲名字符串
    获取的构造方法中传递的路径
    无论路径是绝对的还是相对的getAbsolutePath返回的都是绝对路径
     */
    private static void show01() {
        File f1 = new File("/Users/gd/Desktop/NH/github/learnDic/后端/java/java_IDE");
        String ap = f1.getAbsolutePath();
        System.out.println(ap);

        File f2 = new File("a.txt");
        String ap2 = f2.getAbsolutePath();
        System.out.println(ap2);

    }
}
