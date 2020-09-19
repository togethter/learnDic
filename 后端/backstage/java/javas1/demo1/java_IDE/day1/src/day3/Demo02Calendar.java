package day3;

import java.util.Calendar;
import java.util.Date;

/*
Calendar类的成员方法
public int get(int field)返回给定日历字段值
public void set(int field,int value)将给定的日历字段设置为给定的值
public abstract add(int field,int amount)：根据日历的规则，为给定的日历字段添加或减去给定的时间量
public Date getTime(),返回一个表示此calendar的时间值（从元年到现在的毫秒的偏移量）的Date对象

成员方法的参数
int field 日历类的字段，可以通过Calendar 类的静态成员变量获取

public static final int YEAR = 1;年
public static final int MONTH = 2;月
public static final int DATE = 5;月中的某一天
public static final int DATE_OF_MONTH = 5;月中的某一天
public static final int HOUR = 10；时
public static final int MINUTE = 12；分
public static final int SECOND = 12;秒

 */
public class Demo02Calendar {
    public static void main(String[] args) {
        demo0004();
    }

    /*
    public Date getTime(),返回一个表示此calendar的时间值（从元年到现在的毫秒的偏移量）的Date对象

     */
    private static void demo0004() {
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        System.out.println(date);
    }

    /*
    public abstract add(int field,int amount)：根据日历的规则，为给定的日历字段添加或减去给定的时间量
    把指定的字段增加/减少指定的值
    参数
    int field：传递指定的日历字段(YEAR,MONTH...)
    int amount)：增加/减少的值
                整数：增加
                负数：减少
     */
    private static void demo0003() {
        Calendar c = Calendar.getInstance();
        // 把年增加2年
        c.add(Calendar.YEAR,2);
        // 把月减少2个月
        c.add(Calendar.MONTH,-2);

        int year = c.get(Calendar.YEAR);
        System.out.println(year);
        int month = c.get(Calendar.MONTH);
        System.out.println(month+1);
        int date = c.get(Calendar.DATE);
        System.out.println(date);
    }

    /*
    public void set(int field,int value)将给定的日历字段设置为给定的值
    参数：
    int field：传递指定的日历字段(YEAR,MONTH...)
    int value：传递字段设置的具体的值
     */
    private static void demo0002() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH,9);
        int year = c.get(Calendar.YEAR);
        System.out.println(year);
        int month = c.get(Calendar.MONTH);
        System.out.println(month+1);
        int date = c.get(Calendar.DATE);
        System.out.println(date);
        int date_of_month = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(date_of_month);
        c.set(2019,9,20);
        int year_1 = c.get(Calendar.YEAR);
        System.out.println(year_1);
    }

    /*
    public int get(int field)返回给定日历字段值
    参数：传递指定的日历字段(YEAR,MONTH...)
    返回值，日历字段代表具体的值
     */
    private static void demo0001() {
        // 使用getInstance获取Calendar对象
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        System.out.println(year);
        int month = c.get(Calendar.MONTH);
        System.out.println(month+1);
        int date = c.get(Calendar.DATE);
        System.out.println(date);
        int date_of_month = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(date_of_month);

    }
}
