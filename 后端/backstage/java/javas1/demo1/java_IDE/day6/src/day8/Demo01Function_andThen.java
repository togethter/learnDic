package day8;

import java.util.function.Function;

/*
Function接口中的默认方法andThen:用来进行组合操作
需求：
把String类型的"123"转换为Integer类型，把转换后的结果+10
把增加之后的Integer类型数据，转换为String类型
分析：
转换了两次
第一次把String类型转换为Integer类型
    所以我们可以使用Function<String,Integer> fun1
    Integer i =fun1.apply("123");
第二次把Integer类型转换为String类型
    所以我们可以使用Function<Integer,String> fun2
    String i_str =fun2.apply(123);
我们可以使用andThen方法，把两次转换组在一起使用。
String s = fun1.andThen(fun2).apply("123");

fun1先调用字符串方法，把字符串转换为Integer，
在调用fun2把Integer转换为字符串方法

 */
public class Demo01Function_andThen {
    /*
    定义一个方法
    方法的参数传递一个字符串类型的整数
    方法的参数传递两个function接口
        第一中类型Function<String,Integer>
        第二种类型Function<Integer,String>
     */

    public static void change(String s, Function<String, Integer> fun1, Function<Integer, String> fun2) {
        String ss = fun1.andThen(fun2).apply(s);
        System.out.println(ss);
    }

    public static void main(String[] args) {
        // 定义一个字符串类型的整数
        String s = "123";
        // 调用change方法，传递字符串类型的整数和lambda表达式
        change(s, (String str) -> {
            // 把字符串类型的整数，转换为Integer类型的整数返回
            return Integer.parseInt(str) + 10;
        },(Integer num)->{
            // 把整数转换为字符串，转换为String类型字符串返回
            return num +"";
        });
        // 优化lambda
        change(s, (str)->Integer.parseInt(str)+10,(num)->num+"");
    }
}
