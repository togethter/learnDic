package day2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import static day2.DemoDate2.demo01;

/*
java.text.DateFormat 是日期/时间格式化子类的抽象类
格式化：
格式化（日期->文本）、解析(文本->日期)
成员方法
    string format(Date date) 按照指定的模式 把Date日期，格式化为符合模式的字符串
    Date parse(String source) 把符合模式的字符串，解析成Date日期
    DateFormat是一个抽象类，我们无法直接使用它，可以直接使用DateFormat子类。
    java.text.simpleDateFormat extends DateFormat
    构造方法创建一个类
    simpleDateFormat(String pattern) 用给定的模式和默认的语言环境的日期格式符号构造simpleDateFormat
    参数 pattern 传递的指定的模式
    y-年
    M-月
    d-日
    H-时
    m-分
    s-秒
    对应的模式会把对应的模式转换为对应的日期和时间
    yyyy-MM-dd HH:ss:mm
    注意：
    模式的字母不能随便更改，连接模式的符号可以更改

 */
public class DemoDateFormat {


    public static void main(String[] args) throws ParseException {
        demo002();
    }
    /*
    使用DateFormat类中的方法parse，把文本解析为日期
     Date parse(String source) 把符合模式的字符串，解析成Date日期
     使用步骤
     1、创建simpleDateFormt对象，构造方法中传递指定的模式
     2、调用simpleDateFormt对象的方法parse,把符合构造方法中模式的字符串，解析为Date日期
     注意：
     申明了一个异常 ParseException
     如果字符串和构造方法的模式不一样，那么程序会抛出异常，
     调用抛出异常的方法，就必须处理这个异常，要么throws继续申明抛出一个异常，要么try...catch自己处理这个异常

     */
    private static void demo002() throws ParseException {
    // 1、创建simpleDateFormt对象，构造方法中传递指定的模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
        // 2、调用simpleDateFormt对象的方法parse,把符合构造方法中模式的字符串，解析为Date日期
        Date date = sdf.parse("2020-07-09 09:08:21");
        System.out.println(date);

    }
    /*
     使用DateFormat类中的方法，把日期格式化为文本。
     string format(Date date) 按照指定的模式，把Date日期，格式化为符合模式的字符串
     使用 步骤：
     1、创建simpleDateFormt对象，构造方法中传递指定的模式
     2、调用simpleDateFormt对象的方法，format,按照构造方法的指定的模式，把Date日期格式化为符合模式的字符串

     */

    private static void demo001() {
        //  创建simpleDateFormt对象
        SimpleDateFormat fdt = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
        // 创建Date日期
        Date date = new Date();
        // string format(Date date) 按照指定的模式 把Date日期，格式化为符合模式的字符串
        String str = fdt.format(date);
        System.out.println(str);
    }
}
