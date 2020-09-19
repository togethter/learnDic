package day1;

import java.util.LinkedList;

/*
java.util.LinkedList集合  implements List接口
1、LinkedList底层是一个链表结构，查询慢，增删快
2、里面包含了大量的操作收尾元素的方法
 注意：
 使用LinkedList集合特有的方法，不能使用多态。
 -public void addFirst(E e),将指定的元素插到列表的开头
 -public void addList(E e),将指定的元素插到列表的结尾
 -public E push(E e),将元素推入此列表所表示的堆栈 和 public oid addFirst(E e)类似
 -public E getFist(),返回此列表的第一个元素
 -public E getLast(),返回此列表的最后一个元素
 -public E removeFist(),删除此列表的第一个元素
 -public E removeLast(),删除此列表的最后一个元素
 -public E pop(),从此列表所表示的堆栈处弹出一个元素, 和 -public E removeFist(),删除此列表的第一个元素相似
 -public bollean isempty,列表是否为空


 */
public class DemoLinkedList {


    public static void main(String[] args) {
        //     -public void addFirst(E e),将指定的元素插到列表的开头
//     -public void addList(E e),将指定的元素插到列表的结尾
//     -public E push(E e),将元素推入此列表所表示的堆栈
        LinkedList<String> linked = new LinkedList<>();
        linked.add("a");
        linked.add("b");
        linked.add("c");
        System.out.println(linked); // [a, b, c]
        linked.push("d");
        linked.push("e");
        System.out.println("==========");
        System.out.println(linked); // [e, d, a, b, c]
//        -public void addList(E e),将指定的元素插到列表的结尾 此方法等效于 add
        System.out.println("==========");
        linked.addLast("f");
        linked.addLast("g");
        System.out.println(linked);
//        -public E getFist(),返回此列表的第一个元素
//        -public E getLast(),返回此列表的最后一个元素


//        linked.clear(); // 清空集合中的元素，在获取集合中的元素会抛出N oSuchElementException
//        -public bollean isempty,列表是否为空
        if (!linked.isEmpty()) {
            System.out.println("============");
            String first = linked.getFirst();
            String last = linked.getLast();
            System.out.println(first);
            System.out.println(last);
        }

        System.out.println(linked);
// -public E removeFirst(),删除此列表的第一个元素
// -public E removeLast(),删除此列表的最后一个元素
// -public E pop(),从此列表所表示的堆栈处弹出一个元素 此方法相当于 removeFirst

        String str_f = linked.removeFirst();
        System.out.println("被移除的第一个元素:" + str_f);
        String str_l = linked.removeLast();
        System.out.println("被移除的最后一个元素:" + str_l);
        String str_pop = linked.pop();
        System.out.println("被移除的第一个元素:" + str_pop);
        System.out.println("移除后剩余的元素:" + linked);


    }


}
