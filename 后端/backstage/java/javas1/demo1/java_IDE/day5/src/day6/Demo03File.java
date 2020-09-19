package day6;

import java.io.File;

/*
File判断功能的方法

public boolean exists():此file表示的文件或目录是否实际存在
public boolean isDirectory():此file表示的是否为目录
public boolean isFile():此File表示的是否为文件


 */
public class Demo03File {
    public static void main(String[] args) {
        show02();
    }

    /*
    public boolean isDirectory():此file表示的是否为目录
        用于判断构造方法中给定的路径是否以文件夹结尾
            是：true
            否：false
    public boolean isFile():此File表示的是否为文件
            用于判断构造方法中给定的路径是否以文件结尾
            是：true
            否：false
       注意：
       电脑中或者硬盘中只有文件或者文件夹，两个方法时互斥的
       这两个方法的使用前提，路径必须是存在的，否则都返回false

     */
    private static void show02() {

        File f1 = new File("/Users/gd/Desktop/未命名文件夹/dd");
        // 不存在就没有必要获取
        if (f1.exists()){
            System.out.println(f1.isDirectory()); // false
            System.out.println(f1.isFile());// false
        }

        File f2 = new File("/Users/gd/Desktop/未命名文件夹");
        if (f2.exists()) {
            System.out.println(f2.isDirectory()); // true
            System.out.println(f2.isFile()); // false
        }

        File f3 = new File("/Users/gd/Desktop/NH/github/learnDic/后端/java/java_IDE/java.iml");
        if (f3.exists()) {
            System.out.println(f3.isDirectory()); // false
            System.out.println(f3.isFile()); // true
        }
    }

    /*
    public boolean exists():此file表示的文件或目录是否实际存在
    用于判断构造方法中的路径是否存在
    存在:true
    不存在:false

     */
    private static void show01() {
        File f1 = new File("/Users/gd/Desktop/未命名文件夹");
        System.out.println(f1.exists()); // true
        File f2 = new File("/Users/gd/Desktop/未命名文件夹/dd");
        System.out.println(f2.exists()); // false
        File f3 = new File("java.iml");//相对路径 /Users/gd/Desktop/NH/github/learnDic/后端/java/java_IDE/java.iml
        System.out.println(f3.getAbsolutePath());
        System.out.println(f3.exists()); // true
        File f4 = new File("a.txt");
        System.out.println(f4.exists()); // false
    }
}
