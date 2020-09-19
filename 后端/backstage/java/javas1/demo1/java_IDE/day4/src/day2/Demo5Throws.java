package day2;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
    使用throws关键字，异常处理的一种方式，交给别人处理
    作用：
    当方法内部抛出异常对象的时候，那么我们就必须处理这个异常对象
    可以使用throws关键字处理异常对象，会把异常对象声明抛出给方法的调用者处理
    自己不处理，给别人处理，最终交给JVM处理--->终端处理
    使用格式：
    在方法声明时使用
    修饰符 返回值类型 方法名(参数列表) throws {
    throw new AAAException("产生的原因")
    throw new BBBException("产生的原因")
    ...
    }
    注意：
    1、throws关键字必须写在方法声明处
    2、throws关键字后边声明的异常必须是Exception或者Exception子类
    3、方法内部如果抛出了多个异常对象，那么throws后边也必须声明多个异常
    如果抛出的多个异常对象如果有子父类关系，那么直接声明父类即可
    4、调用了一个声明抛出异常的方法，我们就必须处理声明的异常
    要么继续使用throws申明抛出,交给方法的调用者处理，最终交给JVM处理
    要么try...catch自己处理异常

 */
public class Demo5Throws {

    public static void main(String[] args) throws Exception {
//        readFile("c:\\a.txt");
        Double money = test(30);
        System.out.println(money);

    }

    private static Double test(int month) {
        double money = 0.01;
        double totalMoney = 0;
        for (int i = 0; i < month; i++) {
            if (i == 0) {
                money = (money * 1);
            } else {
                money = money * 2;
            }

            System.out.println(money);
            totalMoney += money;
        }
        return totalMoney;
    }


    /*对传递的文件路径进行合法性判断
     * 如果路径不是c:\\a.txt路径，那么我们就抛出文件找不到异常，告知方法的调用者
     * 注意：FileNotFoundException是编译异常，抛出了编译异常，就必须处理 这个编译异常
     * 可以使用throws继续声明抛出异常FileNotFoundException，这个异常对象，让方法的调用者处理
     * */
    public static void readFile(String fileName) throws FileNotFoundException, IOException {
        if (!fileName.equals("c:\\a.txt")) {
            throw new FileNotFoundException("文件的传递的路径不是c:\\a.txt"); // FileNotFoundException: 文件的传递的路径不是c:\a.txt
        }
        /*
          如果传递的路劲不是.txt结尾，那么我们就抛出IO异常对象，
          告知方法的调用者，方法的后缀名不对
         */

        if (!fileName.endsWith(".txt")) {
            throw new IOException("文件的后缀名异常"); //文件的传递的路径不是c:\a.txt
        }
    }
}

