package Demo3;

/*
String 转换相关的常用方法
public char[] toCharArra():将字符串拆分成字符数组作为返回值
public byte[] getBytes():当前字符串底层字节数组
public String replace(CharSequence oldString, CharSequence newString),将所有老的字符串替换成新的字符串，
返回替换之后的结果新字符串
备注：
CharSequence意思就是说可以接收字符串类型

 */
public class DemoStringConvert {
    public static void main(String[] args) {
        // 转换成字符数组
        char[] chars = "Hello".toCharArray();
        System.out.println(chars[0]);
        System.out.println(chars.length);
        System.out.println("==========");
        // 转换成自己字节数组
        byte[] bytes = "abc".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        System.out.println("===========");
        // 字符串内容替换
        String str1 = "how do you do?";
        String str_1 = str1.replace("o", "*");
        System.out.println(str1);
        System.out.println(str_1);
        System.out.println("===========");
    }
}
