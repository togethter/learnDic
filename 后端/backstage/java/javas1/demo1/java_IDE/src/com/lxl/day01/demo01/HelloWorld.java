package com.lxl.day01.demo01;

import java.text.MessageFormat;
import java.util.Scanner; // 1、导包

public class HelloWorld {
    public static void main(String[] args) {
        int a = 20, b = 26;
        String resultStr = "MessageFormat.format {0} + {1} = {2}";
        String strFormat = "String.format %s + %s = %s";
        System.out.println(MessageFormat.format(resultStr, a, b, sum(a, b)));
        System.out.println(String.format(strFormat, a, b, sum(a, b)));
        int[] arrA = new int[]{2, 3, 1, 5};
        System.out.println(arrA[0]);
        Student student = new Student("张三", 12);
        System.out.println(student.name + student.age);
        Student student1 = new Student();
        // 2、创建
        // 备注 System.in 代表从键盘输入
        Scanner sc = new Scanner(System.in);
        // 3、获取键盘输入的数字
        int num = sc.nextInt();
        System.out.println("输入的int数字是: " + num);
        // 4、获取键盘输入字符串
        String str = sc.next();
        System.out.println("输出入的String是: " + str);

    }

    public static int sum(int a, int b) {
        System.out.println("方法开始执行");
        return a + b;
    }
}




