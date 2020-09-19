package day1;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/*
java.util.LinkedHashSet集合 extends HashSet集合
LinkedHashSet集合特点：
底层是一个哈希列表(数组+链表/红黑树)+链表：多了一条链表（记录元素的存储顺序）保证元素有序

 */
public class DemoLinkedHashSet {
    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();
        set.add("www");
        set.add("abc");
        set.add("abc");
        set.add("itcast");
        System.out.println(set); // 无序的不允许重复

        System.out.println("==========");
        LinkedHashSet<String> linked = new LinkedHashSet<>();
        linked.add("www");
        linked.add("abc");
        linked.add("abc");
        linked.add("itcast");
        System.out.println(linked); //[www, abc, itcast] 有序的不允许重复
    }
}
