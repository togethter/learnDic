package Demo3;

/*
    字符串常量池：以双引号开头的字符串，就在字符串常量池中
    对于基本类型来说是： == 进行数值比较
    对于引用类型来说：   == 进行【地址值】比较
*/
public class DemoStringPool {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        char[] charArr = {'a','b','c'};
        String str3 = new String(charArr);
        System.out.println(str1 == str2); // true
        System.out.println(str1 == str3); // false
        System.out.println(str2 == str3); // false


    }
}
