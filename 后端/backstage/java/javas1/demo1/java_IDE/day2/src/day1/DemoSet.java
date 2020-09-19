package day1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
        java.util.set extends Collection接口
        set接口的特点：
        1、不允许覆盖重复的元素
        2、没有索引，没有带索引的方法，也不能使用带for循环遍历，
    java.util.HashSet集合 implements Set接口
        HashSet的特点：
        1、不允许覆盖重复的元素
        2、没有索引，没有带索引的方法，也不能使用带for循环遍历，
        3、是一个无序元素，存储元素和取出元素顺序有可能不一致。
        4、底层是一个哈希表结构(查询的速度非常快)


 */
public class DemoSet  {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        // 使用add方法向set添加元素
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        System.out.println(set); // [1, 2, 3, 4]

        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String next = it.next();
            System.out.println(next);
        }
        System.out.println("=============");
        for (String str :
                set) {
            System.out.println(str);
        }

    }
}
