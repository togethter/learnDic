package Demo3;

/*
    String 获取相关的常用的方法
    public Int length(),获取字符串的长度
    public String concat(String str) 拼接后返回一个新的字符串
    public charAt(Int index) 获取索引位置的单个字符
    public int indexof(String str) 查找字符串的索引位置，没有返回-1
 */
public class DemoStringGet {
    public static void main(String[] args) {
        String str1 = "jdaiosjdaoidjaJo";
        System.out.println("字符串的长度:" + str1.length());
        // 拼接字符串
        String str2 = str1.concat(",状元才，英雄胆，城墙厚的一张脸!");
        System.out.println("拼接后的字符串:" + str2);
        System.out.println("字符串:" + str1);
        // 获取指定索引位置下的字符
        char hr = str1.charAt(1);
        System.out.println("在1号索引位置的索引为:" + hr);

        // 查找给定的字符串在源字符串的位置
        String originalStr = "HelloWorld";
        int indexOf = originalStr.indexOf("llo");
        System.out.println("索引位置为:" + indexOf);

    }
}
