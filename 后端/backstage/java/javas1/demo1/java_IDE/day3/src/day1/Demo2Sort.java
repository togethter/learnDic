package day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
java.util.Collections 是集合工具类，是用来对集合进行操作。部分方法如下：
public static<T> void sort(List<T> list,Comparator<? super T>):将集合中的元素按照指定规则排序

Comparator 和 Comparable 区别
Comparable： 自己（this）和别人（参数）进行比较，自己需要实现 Comparable借口，重写比较的规则
Comparator：相当于找一个第三方的裁判，比较两个

 */
public class Demo2Sort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        System.out.println(list);// [1, 3, 2]
        Collections.sort(list, new Comparator<Integer>() {
            // 重写比较的规则
            @Override
            public int compare(Integer o1, Integer o2) {
//                return o1-o2;// 升序
                return o2-o1;// 降序

            }
        }); // 默认是升序
        System.out.println(list);// [1, 2, 3]


        ArrayList<Student> list3 = new ArrayList<>();
        list3.add(new Student("张三",15));
        list3.add(new Student("李四",10));
        list3.add(new Student("王五",10));
        System.out.println(list3);
        Collections.sort(list3, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int result =  o1.getAge() - o2.getAge(); // 按照年龄升序排序
                if (0 == result) {
                    result = o1.getName().charAt(0) - o2.getName().charAt(0);
                }
                return result;
            }
        });
        System.out.println(list3);
    }
}
