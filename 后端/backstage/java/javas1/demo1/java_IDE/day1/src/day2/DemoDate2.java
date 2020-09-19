package day2;

import java.util.Date;

public class DemoDate2 {

    public static void main(String[] args) {
        demo03();

    }

    /*
    Date类的成员方法
    Long getTime() 把日期转换称毫秒
    返回子1970-01-01-00:00:00 以来次Date代表的毫秒数
     */
    private static void demo03() {
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time); // 1594200207872
    }

    /*
     Date类的带参数构造方法
     Date(long date) 传递毫秒值，把毫秒转换为date日期
     */
    private static void demo02() {
        Date d1 = new Date(0L);
        Date d2 = new Date(158111111111L);
        System.out.println(d1);// Thu Jan 01 08:00:00 CST 1970
        System.out.println(d2);// Sun Jan 05 07:45:11 CST 1975
    }

    /*
    Date 类空参数构造方法
     Date() 获取当前的系统时间
     */
    public static void demo01() {
        Date date = new Date();
        System.out.println(date); // Wed Jul 08 17:12:32 CST 2020
    }
}
