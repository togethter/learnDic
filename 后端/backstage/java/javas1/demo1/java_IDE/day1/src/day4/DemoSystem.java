package day4;

import java.util.Arrays;

/*
java.lang.System提供了大量的静态方法，可以获取与系统相关的信息或系统级操作，在System类的API当中，
常用的方法有
-public static long currentTimeMillis():返回以毫秒为单位的当前时间
-public static void arraycopy(obj src,int srcpos,obj desc, int descpos, int Length)
将数组中的指定的数据拷贝到另一个数组中
 */
public class DemoSystem {
    public static void main(String[] args) {
        demo1_2();
    }
/*
-public static void arraycopy(obj src,int srcpos,obj desc, int descpos, int Length)
 将数组中的指定的数据拷贝到另一个数组中
 参数：
 src：原数组
 srcpos：原数组的起始位置
 desc：目标数组
 descpos：目标数组的起始位置
 Length：要复制数组的数量
 练习
 将src数组的前三个位置的数据复制到dest数组的前三个位置上
 复制元素前:src数组元素 [1,2,3,4,5] des 数组元素 [6,7,8,9,10]
 复制后：src数组的元素 des 数组元素 [1,2,3,9,10]

 */
    private static void demo1_2() {
        int[] src = {1,2,3,4,5};
        int[] des = {6,7,8,9,10};
        System.out.println("复制前:"+ Arrays.toString(src));
        // 使用System方法arraycopy
        System.arraycopy(src,0,des,0,3);
        System.out.println("复制后:"+ Arrays.toString(des));


    }

    /*
     -public static long currentTimeMillis():返回以毫秒为单位的当前时间
     用来测试程序的效率
     */
    private static void demo1_1() {
        long st = System.currentTimeMillis();
        for (int i = 0; i < 99999; i++) {
            System.out.println(i);
        }
        long sp = System.currentTimeMillis();
        System.out.println("程序运行的时间:" +(sp - st) + "毫秒");

    }
}
