package day4;
/*
StringBuilder和String可以相互转换
String -> StringBuilder，可以使用StringBuilder的构造方法
StringBuilder(String str)构造一个字符串生成器，并初始化为指定字符串内容
StringBuilder->String，可以使用StringBuilder中的toString方法
public String toString():将当前StringBuilder对象转换为String对象
 */
public class Demo3StringBuilder {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println("str" + str);
        StringBuilder bu1 = new StringBuilder(str);
        // 向bu1中添加数据
        bu1.append(1).append(2.2).append("qwe").append(true);
        System.out.println("bu1:" + bu1);
        // StringBuilder->String
        String buString = bu1.toString();
        System.out.println("s:" + buString);

    }
}
