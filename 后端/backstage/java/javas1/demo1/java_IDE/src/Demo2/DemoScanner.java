package Demo2;

import java.util.Scanner;

/*
 键盘输入两个int求出其和值
 思路：
 1、既然需要键盘输入，那么就用Scanner
 2、Scanner步骤:导包，创建，使用
 3、需要的两个数字，需要量词nextInt()
 4、得到两个数字，需要加在一起
 5、将打印输出
*/
public class DemoScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int result = num1 + num2;
        System.out.println("两个输入值相加为" + result);
    }
}
