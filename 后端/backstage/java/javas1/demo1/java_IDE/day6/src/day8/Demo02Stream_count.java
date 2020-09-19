package day8;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
stream流中常用方法_count:用于统计Stream流中元素的个数
long count();
count方法是一个终结方法，返回值是一个long类型的整数
所以不能再调用stream流中的其他方法了
 */
public class Demo02Stream_count {
    public static void main(String[] args) {
        // 获取一个Stream流
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        Stream<Integer> stream = list.stream();
        long count = stream.count();
        System.out.println(count); // 6

    }
}
