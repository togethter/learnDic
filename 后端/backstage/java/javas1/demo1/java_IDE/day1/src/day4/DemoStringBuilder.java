package day4;

/*
String 字符串时常量，他们的值在创建之后不能改变
字符串的底层是一个呗final修饰的数组，不能改变
private final bete[] value;
进行字符串的相加，内存中就会有多个字符串，占用空间多，效率低下

StringBuilder类
字符串的缓冲区，可以提高字符串的操作效率(看做一个长度可以变化的字符串)
底层也是一个数组，没有被final修饰 可以改变长度
byte[] value = new byte[16];
StringBuilder，在内存中始终是一个数组，占用空间少，效率高
如果超出StringBuilder的容量，可以自动扩容

java.lang.StringBuilder类,字符串的缓冲区，可以提高字符串的效率

构造方法
-public stringBuilder() 构造一个空的StringBuilder容器
-public stringBuilder(String str)构造一个StringBuilder容器，并将字符串添加进去
 */
public class DemoStringBuilder {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer();
        System.out.println("sb1：" + sb1);
        StringBuffer sb2 = new StringBuffer("abc");
        System.out.println("sb2:" + sb2);

    }

}
