package Demo3;

/*
    java.lang.String类代表字符串
    字符串的特点
1、字符串的内容永远不变
2、正是因为字符串的内容不可改变，所以字符串内容可以共享使用
3、字符串效果上相当于是char[]字符数组，但是底层原理是byte[]字节数组

创建字符串的创建的3中方法
1、public String();创建一个空白字符串不含有任何内容
2、public String(char[] array);根据字符数组来创建对应的字符串
3、public String(byte[] array);根据字节数组来创建对应的字符串
*/
public class DemoString {

    public static void main(String[] args) {
        // 使用空参构造
        String str1 = new String();// 小括号留空说明字符串什么内容都没有
        System.out.println("第一个字符串:" + str1);
        // 根据字符数组创建字符串
        char[] charArray = {'A', 'b', 'c'};
        String str2 = new String(charArray);
        System.out.println("第二个字符串:" + str2);

        // 根据字节数组出创建字符串
        byte[] byteArray = {97, 98, 99};
        String str3 = new String(byteArray);
        System.out.println("第三个字符串:" + str3);
        // 直接创建
        String str4 = "helloWorld";
        System.out.println("第四个字符串:" + str4);
    }
}
