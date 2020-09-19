package day2;
/*
java.util.Date：表示日期和时间的类，精确到毫秒 1000ms = 1s
日期转换成毫秒
当前日期：2088-01-01
毫秒转换成日期
0毫秒 1917-01-01 00:00:00(英国格林威治)
把毫秒转换成日期
1天 = 24 * 60 * 60 = 86400秒 = 86400 * 1000 = 86400000ms
注意中国是东8区，会把事件增加8个小时
1970-01-01-08：00：00

计算当前日期到时间零点经历了多少毫秒

 */
public class DemoDate {
    public static void main(String[] args) {
        // 获取系统事件到1917-01-01 00:00:00一共经历了多少毫秒
        System.out.println(System.currentTimeMillis());
    }
}
