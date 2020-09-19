package day1;

import java.util.Objects;
/*
Object类的介绍：
object类是所有类的根类，一个类都会直接或者间接的继承该类。
1、toString方法
作用
1、打印对象的信息
2、重写前，打印的时类地址
3、重写后，打印的是对象当中的属性值
2、equals方法
作用
1、比较两个对象
2、重写前，比较是两个地址值
3、重写后，比较的是属性的值

Object equals方法
比较两个对象的方法是否相等

 */
public class Demo3Object {
    public static void main(String[] args) {
        String s1 = null;
        String s2 = "abc";
        boolean b = s1.equals(s2); // java.lang.NullPointerException 是不能调用方法的，会抛出空指针异常
        System.out.println(b);
        boolean b2 = Objects.equals(s1, s2);
        /*
        Objects的equals方法，对两个对象进行比较，防止空指针异常，
         public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }
         */
        System.out.println(b2);


        String str = "abc";
        System.out.println(str);

    }
}
