package day3;

import java.util.Calendar;

/*
java.until.Calendar类:日历类
Calendar类是一个抽象类，里面提供了很多提供操作日历字段的方法
（YEAR，MONTH，DAY_OF_MONTH,HOUR）
Calendar 无法直接创建对象使用，里边有一个静态方法getInstance,该方法返回了
Calendar子类对象，

Static Calendar getInstance();
使用默认时区和语言环境获得一个日历

 */
public class Demo01Calendar {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c);


    }
}
