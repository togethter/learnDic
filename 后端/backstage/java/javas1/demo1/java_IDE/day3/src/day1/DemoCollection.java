package day1;

import java.util.ArrayList;
import java.util.Collections;

/*
java.util.Collections 是集合工具类，是用来对集合进行操作。部分方法如下：
public static<T> bollean addAll(Collection<T> c,T...elements):望集合中添加一些元素
public static void shuffle(List<?>list) 打乱顺序：打乱集合顺序
 */
public class DemoCollection {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
//        public static<T> bollean addAll(Collection<T> c,T...elements):望集合中添加一些元素
        Collections.addAll(list,"a","b","c","d","e"); // 望集合中添加一些元素
        System.out.println(list);
//        public static void shuffle(List<?>list) 打乱顺序：打乱集合顺序
        Collections.shuffle(list);
        System.out.println(list);
    }
}
