package day4;

import java.util.Arrays;
import java.util.Comparator;

/*
lambda有参数有返回值的练习
需求：
    使用数组存储多个Person对象
    对数组中的Person对象使用Arrays的sort方法通过年龄进行升序排列


 */
public class Demo3Arrays {
    public static void main(String[] args) {
//        使用数组存储多个Person对象
        Person[] arr = {
            new Person("ly",32),
            new Person("dlrb",21),
            new Person("jsy",30)
        };
//        对数组中的Person对象使用Arrays的sort方法通过年龄进行升序(前边减后边)排列
//        Arrays.sort(arr, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge()-o2.getAge();
//            }
//        });
//        for (Person p :
//                arr) {
//            System.out.println(p);
//        }
//
        // 使用lambda表达式，简化匿名内部类
        // 优化省略
        Arrays.sort(arr,(p1,p2)-> p1.getAge() - p2.getAge());
        // 遍历数组
        for (Person p :
                arr) {
            System.out.println(p);
        }
    }
}
