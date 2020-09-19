package day8;

import java.util.function.Consumer;

/*
Consumer接口的默认方法 andThen
作用：需要两个Consumer接口，可以把两个Consumer接口组合到一起，在对数据进行消费
例如：
Consumer<String>con1
Consumer<String>con2
String s = "Hello";
con1.accept(s);
con2.accept(s);
连接两个Consumer接口，在进行消费
con1.andthen(con2).accept(s); // 谁写前面，谁先消费
 */
public class Demo01AndThenTest {

    // 定义一个方法，方法传递一个字符串和两个Consumer接口，Consumer接口泛型使用字符串
    public static void printInfo(String[] arr, Consumer<String> con1, Consumer<String> con2) {
        for (String message : arr) {
            con1.andThen(con2).accept(message);
        }
    }

    public static void main(String[] args) {
        // 定义一个字符串类型的数组
        String[] arr = {"赵丽颖,女", "关晓彤,女", "寒冰,女"};
        printInfo(arr, (message) -> {
            // 消费方式：对message进行切割
            String name = message.split(",")[0];
            System.out.print("姓名：" + name);
        }, (message) -> {
            String sex = message.split(",")[1];
            System.out.println("。性别：" + sex + "。");
        });
    }

}
