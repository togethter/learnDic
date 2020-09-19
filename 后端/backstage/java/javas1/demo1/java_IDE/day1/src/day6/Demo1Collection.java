package day6;

import java.util.ArrayList;
import java.util.Collection;

/*
Collection

1、List,有索引，有序
ArrayList,底层数组实现，查询快，增删慢
LinkedList,底层链表实现，查询慢，增删快
Vector,

2、Set，无索引，不可以存储重复元素，存取无序
HashSet,底层是哈希表，和红黑树实现，
LinkedHashSet,底层是哈希表，链表实现，可以保证元素的存储顺序
TreeSet,底层是二叉树实现，一般用于排序

boolean add(E e) 向集合中添加元素
boolean remove(E e) 删除集合中的某个元素
void clear(); 清空集合总所有的元素
boolean contains(E e) 判断集合是否包含某个元素
boolean isEmpty() 判断集合是否为空
int size();获取集合长度
Object[] toArray();将集合转成一个数组



 */
public class Demo1Collection {
    public static void main(String[] args) {
        Collection<String> co = new ArrayList<>();
        // boolean add(E e) 向集合中添加元素
        co.add("hello");
        co.add("lxl");
        //boolean remove(E e) 删除集合中的某个元素
        System.out.println("集合添加成功了:" + co);
        boolean result = co.remove("hello");
        System.out.println("集合移除成功" + co);
        // boolean contains(E e) 判断集合是否包含某个元素
        boolean contains = co.contains("lxl");
        System.out.println("集合包含给定的值："+contains);
        // int size();获取集合长度
        int size = co.size();
        System.out.println("集合长度:"+size);
        // Object[] toArray();将集合转成一个数组
        Object[] strArray = co.toArray();
        System.out.println("集合转数组："+strArray);

        // void clear(); 清空集合总所有的元素
        co.clear();
        System.out.println("集合清空了数据:" + co);
        // boolean isEmpty() 判断集合是否为空
        boolean empty = co.isEmpty();
        System.out.println("集合是空数据" + empty);
    }

}
