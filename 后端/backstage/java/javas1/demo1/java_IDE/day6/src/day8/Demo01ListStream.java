package day8;

import java.util.ArrayList;
import java.util.List;

/*
使用传统的方式，遍历集合，对集合进行过滤
 */
public class Demo01ListStream {
    public static void main(String[] args) {
        // 创建一个List集合，对集合中的数据进行遍历
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张倩");
        list.add("宋远桥");
        list.add("张三丰");
        // 对list的元素进行过滤,只要以张开头的元素，存储到一个新的集合中。
        // 对listA集合中进行遍历，只要姓名长度为3的人，存储到一个新集合中
        // 遍历listB集合
//        list.stream().filter(str-> str.startsWith("张")).filter(str->str.length()==3).forEach(str-> System.out.println(str));
        list.stream().filter((str) -> str.startsWith("张") && str.length() == 3).forEach(s -> System.out.println(s));
    }

}
