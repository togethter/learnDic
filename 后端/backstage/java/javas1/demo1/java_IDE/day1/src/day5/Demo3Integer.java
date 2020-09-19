package day5;

/*
基本类型->字符串
1、基本类型的值 + ""
2、使用包装类中的静态方法
static String toString(int i)
使用String类的静态方法
sttic String valueof(int i)

字符串->基本类型
使用包装类的静态方法 parseXX("字符串")
Integer类 static Int parseInt(String s)
Double类 static Double parseDouble(String s)

 */
public class Demo3Integer {
    public static void main(String[] args) {
        //基本类型->字符串
        String s1 = 124 + "";
        System.out.println(s1);

        String s2 = Integer.toString(123);
        System.out.println(s2);

        Integer s3 = Integer.valueOf("123");
        System.out.println(s3);


        // 字符串->基本类型
        int i = Integer.parseInt("123");
        System.out.println(i);

//        int a = Integer.parseInt("a"); NumberFormatException: For input string: "a"
//        System.out.println(a);




    }
}
