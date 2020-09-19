package day6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
java.until.Iterator接口：迭代器(对集合进行遍历)
有两个常用的方法
1、boolean hasNext()如果仍后元素可以迭代，则返回true
判断集合中还有没有下一个元素，有返回true，没有返回false
2、E next()返回迭代的下一个元素
取出集合中的下一个元素
Iterator迭代器是一个接口，我们无法直接使用，需要使用Iterator接口的实现类对象，获取实现类的方式比较特殊
Collection有一个方法叫做Iterator，这个方法返回的就是迭代器的实现类对象
迭代器使用步骤：(重点)
1、使用集合类中的方法Iterator获取迭代器 的实现类对象，使用Iterator接口接收(多态)
2、使用Iterator接口类的方法hasNext判断有没有下一个元素
3、使用Iterator接口类的方法next取出集合中的下一个元素

 */
public class Demo2Iterator {
    public static void main(String[] args) {
        // 创建一个集合对象
        Collection<String> co = new ArrayList<>();
        co.add("qwe");
        co.add("asf");
        co.add("zxc");
        /*
         1、使用集合类中的方法Iterator获取迭代器 的实现类对象，使用Iterator接口接收(多态)
         注意：
         Iterator接口也是有泛型的，迭代器的泛型跟着集合走，集合的泛型是什么泛型，迭代器的泛型就是什么泛型

         */
        // 多态：接口            实现类对象
        Iterator<String> it = co.iterator();
        // 2、使用Iterator接口类的方法hasNext判断有没有下一个元素
        boolean next = it.hasNext();
        System.out.println(next);
        // 3、使用Iterator接口类的方法next取出集合中的下一个元素
        while (it.hasNext()) {
            String s12 = it.next();
            System.out.println(s12);
        }


    }

}
