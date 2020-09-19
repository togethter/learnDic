package day1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
    java.lang.object类
    类 object 是层次结构的根(最顶层)类，每一个类都是用object作为超类(父类)，
    所有的对象都实现了这个类的方法
 */
public class DemoToString {
    /*
    Person类继承了object类所以可以使用toString方法
    String toString() 返回该字符串的对象
     */
    public static void main(String[] args) {
        Person p = new Person("张三", 18);
        String s = p.toString();
        System.out.println(s); // day1.Person@3cb5cdba
        // 直接打印对象的名字，就是调用对象的toString方法  p = p.toString();
        System.out.println(p); // day1.Person@3cb5cdba

        /*
        看一个类是否重写了toString方法，直接打印这个类对应对象的名字即可
        如果没有重写toString方法，打印的就是对象的地址值
        如果重写了toString方法，就按照重写的方式打印
         */

        Random r = new Random();
        System.out.println(r);

        Scanner sc = new Scanner(System.in);
        System.out.println(sc);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);


    }


}
