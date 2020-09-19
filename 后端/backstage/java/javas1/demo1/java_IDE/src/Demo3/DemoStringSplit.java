package Demo3;
/*
分割字符串的方法
public String[] split(String regex):按照字符串的规则，将字符串切分成为若干部分
split 方法的参数其实是一个正则表达式，如果按照`.`分割，必须写`\\.`才可以 
 */
public class DemoStringSplit {
    public static void main(String[] args) {
    String str1 = "aaa,bbb,ccc";
        String[] array = str1.split(",");
        System.out.println(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
