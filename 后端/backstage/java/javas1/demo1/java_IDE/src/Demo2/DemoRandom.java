package Demo2;

import java.util.Random;
import java.util.Scanner;

public class DemoRandom {

    public static void main(String[] args) {
        Random rd = new Random();
        for (int i = 0; i < 10; i++) {
            int num = rd.nextInt(10);// 范围实际上是0-9
            System.out.println(num);
        }

        gussess();
    }

    public static void gussess() {
        Random rd = new Random();
        int rdNum = rd.nextInt(100);
        Scanner sc = new Scanner(System.in);
        System.out.println("猜数字开始：请输入数字...");
        while (true) {
            int num = sc.nextInt();
            if (num > rdNum) {
                System.out.println("输入太大了");
            } else if (num < rdNum) {
                System.out.println("输入太小了");
            } else {
                System.out.println("恭喜猜对了");
                break;
            }
        }
    }
}
