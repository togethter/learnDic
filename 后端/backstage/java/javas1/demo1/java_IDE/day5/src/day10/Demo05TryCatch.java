package day10;

import java.io.FileWriter;
import java.io.IOException;

/*
在jdk1.7之前使用 try catch finally处理流中的异常
格式：
try {
可能会长生异常的代码
} catch(异常类的变量 ){
异常的处理逻辑
}finnaly{
一定会执行的代码
资源示释放
}
 */
public class Demo05TryCatch {
    public static void main(String[] args) {
        // 提高变量fw的作用域，让finally可以使用
        // 变量在定义的时候可以没有值，但是使用的时候必须有值
//        fw = new FileWriter("5.txt", true); 如果执行失败 fw就没有值fw.close就会报错
        // 创建失败了 fw默认的值是null,null是不能调用方法的，会抛出nullpointerException需要增加一个判断不是null把资源释放
        FileWriter fw = null;

        try {
            fw = new FileWriter("5.txt", true);
            for (int i = 0; i < 10; i++) {
                fw.write("HelloWorld" + i + "\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (fw != null){
                try {
                    // fw.close方法声明抛出了IOException异常对象，所以我们就处理这个异常对象，要么throws，要么try...catch
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
