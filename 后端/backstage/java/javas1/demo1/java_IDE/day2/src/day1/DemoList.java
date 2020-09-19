package day1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
java.util.List接口 extends Collection接口

List接口的特点
1、有序集合，存储元素和取出元素的顺序是一致的(存储123,取出123)
2、有索引，包含了一些带索引的方法
3、允许存储重复的元素

List接口带索引的方法(特有)
- public void add(int index,E element),将指定元素添加到集合中指定的位置
- public E get(int index),返回集合中指定位置的元素
- public E remove(int index),移除列表中指定位置的元素，返回的是被移除的元素
- public E set(int index, E element),用指定元素替换集合中指定位置的元素，返回值的更新前的元素
注意：
操作索引的时候，一定防止索引越界异常
 */
public class DemoList {
    public static void main(String[] args) {
        // 创建一个list集合对象，多态
        List<String> list = new ArrayList<>();
        // 使用add方法向集合中添加元素
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        // 打印集合
        System.out.println(list);
       //  - public void add(int index,E element),将指定元素添加到集合中指定的位置
        // 在c d 之间添加一个itHeima
        list.add(3,"itHeima");
        System.out.println(list);

        //- public E remove(int index),移除列表中指定位置的元素，返回的是被移除的元素
        String s = list.remove(3);
        System.out.println(s);
        System.out.println(list);
        // - public E set(int index, E element),用指定元素替换集合中指定位置的元素，返回值的更新前的元素
        String hhhh = list.set(4, "hhhh");
        System.out.println(hhhh);
        System.out.println(list);

        // - public E get(int index),返回集合中指定位置的元素

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("--------------");

        // 使用迭代器
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String str = it.next();
            System.out.println(str);
        }
        System.out.println("============");
        // 使用foreach
        for (String str :
                list) {
            System.out.println(str);
        }


    }

}
