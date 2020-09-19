package day1;

import java.util.ArrayList;
import java.util.Collections;

/*
java.util.Collections 是集合工具类，是用来对集合进行操作。部分方法如下：
public static<T> void sort(List<T> list):望集合中元素,按照默认规则排序

注意：
sort(List<T> list) 方法的使用前提
被排序的集合里边存储的元素，必须实现comparable,重写接口的方法 compareTo定义排序的规则

Comparable接口排序的规则
自己(this)-参数:升序

 */
public class DemoSort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        System.out.println(list);// [1, 3, 2]
        Collections.sort(list); // 默认是升序
        System.out.println(list);// [1, 2, 3]

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("v");
        list2.add("e");
        System.out.println(list2);// [a, v, e]
        Collections.sort(list2);
        System.out.println(list2);// [a, e, v]

        ArrayList<Person> list3 = new ArrayList<>();
        list3.add(new Person("张三",15));
        list3.add(new Person("李四",20));
        list3.add(new Person("王五",10));
        System.out.println(list3);
        Collections.sort(list3);
        System.out.println(list3);


    }
}
