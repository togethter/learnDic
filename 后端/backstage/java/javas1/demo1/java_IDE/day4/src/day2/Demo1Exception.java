package day2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/*
java.lang.throwable:类是java语言中所有错误或异类的超类
Exception:编译器异常，进行编译(写代码)java程序出现的问题
RunTimeException运行期异常，java程序运行过程中出现的问题
异常就相当于程序得了一个小毛病(感冒，发烧)，把异常处理掉，程序可以继续执行
Error:错误
错误就相当于程序得了一个无法治愈的毛病，必须修改源代码，程序才能继续执行，
 */
public class Demo1Exception {
    public static void main(String[] args) /*throws ParseException*/ {
       /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 格式化日期
        Date date = null;
        try {
            date = sdf.parse("1999-0909"); // 把字符串格式的日期，解析为Date格式的日期
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);*/
//        RunTimeException运行期异常 java程序运行过程中出现的问题
        /*int[] arr = {1,2,3};
        System.out.println(arr[0]);
        try {
            System.out.println(arr[3]);
        } catch (Exception e) {
            // 异常的处理逻辑
            System.out.println(e);
        }*/
        /*
        Error:错误
        OutOfMemoryError: Java heap space
        内存溢出的错误，创建的数组太大了，超出了JVM分配的内存
         */
//        int[] arr = new int[1024 * 1024 * 1024];
        // 必须修改代码，创建的数组小一点
        int[] arr = new int[1024 * 1024];


        System.out.println("后续代码");
    }
}
