package Demo3;

/*
    public boolean equals(Object obj);参数可以是任何对象，只有参数是一个字符串，内容相同才会给true，否则
    false
    注意事项
    任何对象都能用Object进行接收
    如果比较双方一个常量，一个变量，推荐常量字符串写在前面。
    因为变量有可能为null,对于null调用方法会报错

    public boolean equalsIgnoreCase(String string); 忽略大小写进行内容比较
 */
public class DemoStringEquals {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        String str3 = new String(charArray);
        System.out.println(str1.equals(str2));
        System.out.println(str2.equals(str3));
        System.out.println(str1.equals("Hello"));
        System.out.println("Hello".equals(str1));
        System.out.println("=========");
        System.out.println("忽略大小写"+"hello".equalsIgnoreCase(str1));
    }
}
