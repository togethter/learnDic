package day8;

import java.util.function.Supplier;

/*
求数组元素的最大值
使用Supplier接口作为方法的参数类型，通过lambda表达式求出int数组中的最大值。
提示：接口的泛型请使用java.lang.Integer
 */
public class Demo02Supplier {
    // 定义一个方法用于获取int类型数组中数组的最大值，方法的参数传递Supplier接口，泛型使用Integer
    public static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }

    public static void main(String[] args) {

        // 定义一个int类型数组，并赋值
        int[] arr = {100, 0, -99, 33};
        // 调用getmax方法
      int maxValue =  getMax(() -> {
            // 获取数组的最大值并返回
            // 定义一个变量，把数组中的第一个元素赋值给该变量，记录数组中元素的最大值
            int max = arr[0];
            for (int i :
                    arr) {
                if (max < i) {
                    // 如果i>max,则替换max作为最大值
                    max = i;
                }
            }
            return max;

        });
        System.out.println("数组中元素的最大值：" + maxValue);
    }


}
