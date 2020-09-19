package Demo3;

/*
public String subString(int index)
public String subString(int begin,int end),截取bgegin-end之间字符串[,)
 */
public class DemoStringSubsring {
    public static void main(String[] args) {
        String str1 = "HelloWorld";
        String str_1 = str1.substring(5); // World
        System.out.println(str_1);
        String str2 = str1.substring(2, 3);// l
        System.out.println(str2);

    }
}
