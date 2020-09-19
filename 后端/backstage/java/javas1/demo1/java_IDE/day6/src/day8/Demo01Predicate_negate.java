package day8;

import java.util.function.Predicate;

/*
需求：判断一个字符串长度是否大于5
如果字符串的长度大于5则返回false
如果字符串的长度不大于5则返回true
所有我们应该使用取反！符号，对判断结果进行取反
Predicate接口有一个方法negate，也叫取反的意思
default Predicate<T> negate() {
return (t) -> !test(t);
}
 */
public class Demo01Predicate_negate {
    /*
     定义一个方法,传递一个字符串
     使用Predicate接口
     一个用于判断字符串的长度是否大于5
     */

    public static boolean checkString(String s, Predicate<String> pre) {
//        return !pre.test(s);
        return pre.negate().test(s); //等效于pre.test(s)
    }


    public static void main(String[] args) {
        // 定义一个字符串
        String s = "bbbcdef";
        // 调用checkString方法，对字符串进行校验,参数传递字符串和lambda表达式
        boolean b = checkString(s, (str) -> {
            // 对参数传递的字符串进行判断，判断字符串的长度是否大于5并把判断的结果返回
            return str.length() > 5;
        });

        System.out.println(b);
    }

}
