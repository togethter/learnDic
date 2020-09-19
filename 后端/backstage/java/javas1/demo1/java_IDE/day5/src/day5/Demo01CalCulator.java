package day5;

/*
lambda表达式有参数有返回值的练习
需求：
给定一个计算器CalCulator接口，内部含计算方法calc方法可以将两个int相加得到和值，
使用lambda的标准格式调用invokeCalc方法，完成120和130的相加计算

 */
public class Demo01CalCulator {
    public static void main(String[] args) {
//    调用invokeCalc方法，方法的参数是一个接口，可以使用匿名内部类
        invokeCalc(10, 20, new CalCulator() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        });
        // 使用lambda表达式简化匿名内部类的书写
        // lambda优化省略
        invokeCalc(120,130,(a,b)-> a + b);
    }

    /*
     定义一个方法
     参数传递两个int类型的整数
     参数传递CalCulator接口
     方法内部调用CalCulator中的方法调用内部的方法调用cook方法，计算两个整数的和
     */

    public static void invokeCalc(int a, int b, CalCulator c) {
        int sum = c.calc(a, b);
        System.out.println(sum);
    }
}
