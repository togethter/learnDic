package day6;

import java.io.File;
import java.io.IOException;

/*
File类创建删除功能的方法
    public boolean createNewFile() 当且仅当具有该名称的文件上不存在时，创建一个新的空文件
    public boolean delete() 删除由此file表示的File或目录
    public boolean mkdir()  创建由此File表示的目录
    public boolean mkdirs() 创建由此File表示的目录，包括任何必须但不存在的父目录


 */
public class Demo04File {
    public static void main(String[] args) throws IOException {
        show01();
    }



    /*
    public boolean delete():创建由此file表示的文件或目录
    此方法，此方法可以删除构造方法中给出的文件/文件夹
    返回值：布尔值
    true:文件或文件夹删除成功
    false:文件夹中由内容，不会删除返回false,构造方法的路径不存在返回false
    注意：
    delete是直接在硬盘直接删除文件或文件夹，不走回收站，删除需谨慎
     */
    private static void show03() {
        File f1 = new File("/Users/gd/Desktop/NH/github/learnDic/后端/java/java_IDE/创建文件夹");
        boolean d_f1 = f1.delete();
        System.out.println(d_f1);

        File f2 = new File("/Users/gd/Desktop/NH/github/learnDic/后端/java/java_IDE/abc.txt");
        boolean d_f2 = f2.delete();
        System.out.println(d_f2);
        File f3 = new File("/Users/gd/Desktop/NH/github/learnDic/后端/java/java_IDE/新建文件夹");
        boolean d_f3 = f3.delete();
        System.out.println(d_f3);


    }

    /*
    public boolean mkdir()  只能创建单级空文件夹
    public boolean mkdirs() 既可以创建单级空文件夹也可以创建多级文件夹
     创建文件夹的路径和名称在构造方法中给出(构造方法的参数)
    返回值：布尔值
        true:文件夹不存在，创建文件夹，返回true
        false：文件夹存在，文件不会创建，返回false，构造方法中给出的路径不存在返回false
  注意：
    此方法，
    1、只能创建文件夹，不能创建文件
    2、创建文件的路径必须存在，否则会抛出异常
     */
    private static void show02() {
        File f1 = new File("/Users/gd/Desktop/NH/github/learnDic/后端/java/java_IDE/创建文件夹");
        boolean fir1 = f1.mkdir();
        System.out.println(fir1);

        File f2 = new File("/Users/gd/Desktop/NH/github/learnDic/后端/java/java_IDE/创建文件夹1/创建好了吗");
        boolean fir2 = f2.mkdirs();
        System.out.println(fir2);

        File f3 = new File("/Users/gd/Desktop/NH/github/learnDic/后端/java/java_IDE/abc.txt");
        boolean fir3 = f3.mkdirs(); // 看类型他是一个文件
        System.out.println(fir3);



        File f4 = new File("/Users/uu_test");
        boolean fir4 = f4.mkdirs(); // 不会抛出异常，路径不存在，不会创建
        System.out.println(fir4);
    }

    /*
    public boolean createNewFile() 当且仅当具有该名称的文件上不存在时，创建一个新的空文件
    创建文件的路径和名称在构造方法中给出(构造方法的参数)
    返回值：布尔值
        true:文件不存在，创建文件，返回true
        false：文件存在，文件不会创建，返回false
    注意：
    此方法，
    1、只能创建文件，不能创建文件夹
    2、创建文件的路径必须存在，否则会抛出异常
createNewFile申明抛出了异常IOException,我们调用这个方法，就必须处理这个异常，要么throws，要么try..cath

     */
    private static void show01() throws IOException {
        File file = new File("/Users/gd/Desktop/NH/github/learnDic/后端/java/java_IDE/1.txt");
        boolean newf1 = file.createNewFile();
        System.out.println(newf1);


        File file2 = new File("2.txt");
        boolean newf2 = file2.createNewFile();
        System.out.println(newf2);

        File file3 = new File("新建文件夹");
        boolean newf3 = file3.createNewFile();
        System.out.println(newf3);
    }
}
