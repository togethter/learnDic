package day8;

import java.util.function.Predicate;

/*
逻辑表达式:可以连接多个判断条件
&&:与运算符，有false则false
||:或运算符，有true则true
!:非(取反)运算符，非真则假，非假则真
需求：判断一个字符串，有两个判断条件
    判断一个字符串，是否大于5
    判断一个字符串，是否包含a
    满足一个条件即可，我们就可以使用&&运算符连接两个条件
    Predicate接口中有一个方法or，表示或者关系，也可以用于判断连接两个判断条件
    default predicate<T> or(predicate<? super T> other) {
    Objects.requireNonNull(others);
    return (t) -> this.test(t) || other.test(t);
    }
    方法内部的两个判断条件，也是使用||运算符连接起来的
 */
public class Demo01Predicate_or {
    /*
     定义一个方法 参数传递一个String类型的字符串

     传递两个Predicate接口
     一个用于判断字符串的长度是否大于5
     一个用于判断字符串是否包含a
     使用Preficate方法test对字符串进行判断，并把判断的结果返回
     满足一个条件即可
     */

    public static boolean checkString(String s, Predicate<String> pre1, Predicate<String> pre2) {
//        return  pre1.test(s) || pre2.test(s);
        return pre1.or(pre2).test(s);
    }


    public static void main(String[] args) {
        // 定义一个字符串
        String s = "bbbcdef";
        // 调用checkString方法，对字符串进行校验,参数传递字符串和lambda表达式
        boolean b = checkString(s, (str1) -> {
            // 对参数传递的字符串进行判断，判断字符串的长度是否大于5并把判断的结果返回
            return str1.length() > 5;
        }, (str2) -> {
//            一个用于判断字符串是否包含a
            return str2.contains("a");
        });
        System.out.println(b);
    }

}
