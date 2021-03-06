package day7;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/*
我们可以使用过滤器来实现
在Filter类中有两个和ListFilter重载的方法，方法的参数传递的就是过滤器
File[] = listFiles(fileFilter filter)
java.io.fileFilter接口：用于抽象路径名(Filter对象)的过滤器
作用：用来过滤文件(File对象)
抽象方法：用来过滤的文件的方法
boolean accept(File filename) 测试指定抽象路径名是否应该包含在某个路径名列表中
参数：
File pathname 使用ListFiles方法遍历目录，得到每一个文件对象

File[] = listFiles(filenameFilter filter)
java.io.FilenameFilter接口：实现此接口的类实例可用于过滤器文件名
作用：用于过滤文件的名称
抽象方法：用于过滤文件方法
boolean accept(File dir, String name) 测试指定文 件是否应该包含在某一文件列表中
File dir：构造方法中传递的被遍历的目录
String name：使用ListFiles方法遍历目录获取每一个文件夹/文件夹名称
注意：
两个过滤器接口是没有实现类的，需要我们自己写实现类，重写过滤的方法accept,在方法中自定义过滤规则

 */
public class Demo4Filter {
    public static void main(String[] args) {
        File f = new File("/Users/gd/Desktop/NH/github/learnDic/后端/java/java_IDE");
        getAllFile(f);
    }

    /*
    定义一个方法，传输传递file类型的目录
    方法中对目录进行遍历
     */
    private static void getAllFile(File dir) {
        // 传递过滤器对象 使用匿名内部类

//        File[] files = dir.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return pathname.isDirectory() ||pathname.getName().toLowerCase().endsWith(".java");
//            }
//        });
//        使用lambda表达式优化匿名内部类
        File[] files = dir.listFiles((pathname)-> pathname.isDirectory() ||pathname.getName().toLowerCase().endsWith(".java"));
//        File[] files = dir.listFiles(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                // 过滤规则 pathname是文件夹或者是.java结尾的文件返回true
//                return new File(dir,name).isDirectory() || name.toLowerCase().endsWith(".java");
//            }
//        });
        // 使用lambda表达式优化匿名内部类(接口中只有一个抽象方法)
//        File[] files = dir.listFiles((File d,String name)-> {
//                return new File(d,name).isDirectory() || name.toLowerCase().endsWith(".java");
//        });
        // 简化lambda表达式
//        File[] files = dir.listFiles((d,name)-> new File(d,name).isDirectory() || name.toLowerCase().endsWith(".java"));
        for (File f :
                files) {
            if (f.isDirectory()) {
                getAllFile(f);
            } else {
                System.out.println(f);
            }
            System.out.println(f);
        }

    }
}
