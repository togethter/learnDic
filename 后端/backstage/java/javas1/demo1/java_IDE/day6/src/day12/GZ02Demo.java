package day12;

/*
数组的构造器引用
 */
public class GZ02Demo {
    /*
     定义一个方法，方法的参数传递构件数组的长度和ArrayBuilder接口
     方法的内部根据传递的长度使用ArrayBuilder中的方法创建数组并返回
     */
    public static int[] createArray(int length, GZ02ArrayBuilder ab) {
        return ab.builderArray(length);
    }

    public static void main(String[] args) {
        // 调用createArray方法，传递数组的长度和lambda表达式
        int[] array1 = createArray(10, (length) -> {
            // 根据数组的长度，创建数组并返回
            return new int[length];
        });
        System.out.println(array1.length);// 创建一个长度为10的数组
        /*
        使用方法引用优化lambda表达式
        已知就是创建的int[]数组
        数组的长度也是已知的
        就可以使用方法引用
        new[]引用new,根据参数传递的长度来创建数组
         */
        int[] array2 = createArray(100, int[]::new);
        System.out.println(array2.length);
    }

}
