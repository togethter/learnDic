package Demo5;

import java.util.ArrayList;
import java.util.Arrays;

/*
java.until.Arrays 是一个与数组相关的工具类，里面提供了大量的静态方法
用来实现数组常见的操作

public static String toString(数组):将参数数组变成字符串(按照默认格式:[元素1，元素2，元素3...])
public static void Sort(数组)  按照默认升序 对数组的元素进行排序
备注：
如果是数值，sort是按照升序从小到大
如果是字符串，sort是按照字母升序
如果是自定义类型，那么这个自定义类需要有comparable或者comparable接口的支持
 */
public class DemoArrays {
    public static void main(String[] args) {
        int[] intArray = {1,3,4,5,4};
        // 将Int[]数组按照默认格式变成字符串
        String str1 = Arrays.toString(intArray);
        System.out.println(str1);

        int[] array1 = {2,1,3};
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1)); // [1, 2, 3]

        String[] stringArray = {"aaa","ccc","bbb"};
        Arrays.sort(stringArray);
        System.out.println(Arrays.toString(stringArray)); // [aaa, bbb, ccc]

    }
}
