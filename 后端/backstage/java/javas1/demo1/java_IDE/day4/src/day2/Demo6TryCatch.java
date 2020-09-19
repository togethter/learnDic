package day2;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
    异常处理的第二种方式,自己处理异常
    格式：
    try{
    可能产生异常的代码
    } catch(定义一个异常的变量，用来接收try中抛出的异常对象){
    异常处理的逻辑，产生异常之后怎么处理异常对象，
    工作中，把异常的信息记录在一个日志中
    }
    ...
    catch(异常类名 变量名) {
    }
    注意：
    1、try中可能会抛出多个异常，那么就可以使用多个catch来处理这些异常
    2、如果try中产生了异常，那么就会执行catch中异常处理逻辑，执行完毕catch中的处理逻辑
    继续执行try...catch之后的代码，如果try中没有产生异常，那么就不会处理catch中异常处理逻辑
    执行完try中的代码，继续执行try...catch之后的代码
 */
public class Demo6TryCatch {

    public static void main(String[] args)  {
        try {
            //可能产生异常的代码
            readFile("d:\\a.tx");
        }catch (IOException e){ // try中抛出什么异常，cath定义什么异常变量，用来接收这个异常对象
            //异常处理的逻辑，产生异常之后怎么处理异常对象，
            //System.out.println("传递的文件后缀不是.txt");
            /*
            throwable类定义了3个异常处理的方法
            String getMessage()返回此 throwable详细消息字符串
            String toString()返回此 throwable的简短描述
            Void printStackTrace() JVM打印异常对象，默认此方法，打印的异常信息最全面的
             */
            //System.out.println(e.getMessage()); //文件的后缀名不对
            //System.out.println(e.toString()); //重写Object类重写toString方法，java.io.IOException: 文件的后缀名不对
            //System.out.println(e);
            /*
            java.io.IOException: 文件的后缀名不对
                at day2.Demo6Try Catch.readFile(Demo6TryCatch.java:54)
                at day2.Demo6TryCatch.main(Demo6TryCatch.java:29)
             */
            e.printStackTrace();

        }
        System.out.println("后续代码");
    }

        /*
           如果传递的路劲不是.txt结尾，那么我们就抛出IO异常对象，
           告知方法的调用者，方法的后缀名不对
          */
    public static void readFile(String fileName) throws  IOException {
        if (!fileName.endsWith(".txt")) {
            throw new IOException("文件的后缀名不对"); //文件的传递的路径不是c:\a.txt
        }
    }
}


