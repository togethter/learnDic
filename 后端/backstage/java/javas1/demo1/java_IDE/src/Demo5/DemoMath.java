package Demo5;
/*
java.until.Math，是数学相关的工具类，里面提供了大量的工具方法，完成与数学相关的操作
pubic static double abs(double num)：获取绝对值
pubic static double ceil(double num)：向上取整
public static double floor(double num)：向下取整
public static long round(double num)：四舍五入
 */
public class DemoMath {
    public static void main(String[] args) {
        // 绝对值
        System.out.println(Math.abs(3.14));
        System.out.println(Math.abs(0));
        System.out.println(Math.abs(-3));
        // 向上取整
        System.out.println(Math.ceil(12.3));
        // 向下取整 抹零
        System.out.println(Math.floor(12.1));
        // 四舍五入
        System.out.println(Math.round(20.4));
        System.out.println(Math.round(20.5));
    }


}
