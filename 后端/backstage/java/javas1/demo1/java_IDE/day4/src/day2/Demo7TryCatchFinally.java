package day2;

import java.io.IOException;

/*
Finally代码块
 格式：
    try{
    可能产生异常的代码
    } catch(定义一个异常的变量，用来接收try中抛出的异常对象){
    异常处理的逻辑，产生异常之后怎么处理异常对象，
    工作中，把异常的信息记录在一个日志中
    }
    ...
    catch(异常类名 变量名) {
    }finally{
    无论是否出现异常都会执行
    }
    注意
    1、finally不能单独使用，必须和try一起使用
    2、finally一般用于资源释放(资源回收)无论程序是否出现异常，最后都要资源释放
 */
public class Demo7TryCatchFinally {
    public static void main(String[] args) {
        try {
            // 可能会产生异常的代码
            readFile("c://a.tx");
        } catch (IOException e) {
            // 异常处理的逻辑
            e.printStackTrace();
        }finally {
            // 无论是否异常都会处理
            System.out.println("资源释放");
        }
    }
    /*
        如果传递的路劲不是.txt结尾，那么我们就抛出IO异常对象，
        告知方法的调用者，方法的后缀名不对
       */
    public static void readFile(String fileName) throws IOException {
        if (!fileName.endsWith(".txt")) {
            throw new IOException("文件的后缀名不对"); //文件的传递的路径不是c:\a.txt
        }
        System.out.println("路径没有问题,读物文件");
    }
}
