package day6;

import java.io.File;

/*
       File类遍历(文件夹)目录功能
       public String[] list():返回一个string数组，表示该file目录中所有子文件或目录
       public File listFiles():返回一个file数组，表示该file目录中的所有子文件或目录
       注意
       list方法和listFiles方法遍历的时构造方法中给出的目录
       如果构造方法中给出的目录的路径不存在，就会抛出空指针异常。
       如果构造方法中给出的路径不是一个目录，也会抛出空指针异常，
        */
public class Demo05File {
    public static void main(String[] args) {
        demo02();
    }

    /*
    public File listFiles():返回一个file数组，表示该file目录中的所有子文件或目录
    遍历构造方法中给出的目录，会获取目录中所有的文件/文件夹，把文件/文件夹封装为File对象
    多个File对象存储到File数组中
     */
    private static void demo02() {
        File f1 = new File("/Users/gd/Desktop/NH/github/learnDic/后端/java/java_IDE");
        File[] f_arr = f1.listFiles();
        for (File f :
                f_arr) {
            System.out.println(f);
        }
    }

    /*
    public String[] list():返回一个string数组，表示该file目录中所有子文件或目录
    遍历构造方法给出的目录，会获取目录中所有文件/文件夹的名称，把获取到的多个名称存储到一个String类型数组中
     */

    private static void demo01() {
       File f1 = new File("/Users/gd/Desktop/NH/github/learnDic/后端/java/java_IDE/1.txt"); // NullPointerException
        String[] f_list = f1.list();
        for (String s1 :
                f_list) {
            System.out.println(s1);

        }

    }

}
