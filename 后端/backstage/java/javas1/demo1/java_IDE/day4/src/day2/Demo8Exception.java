package day2;

import java.util.List;

/*
异常的注意事项

 */
public class Demo8Exception {
    /*
    多个异常使用捕获，又该如何处理呢
    1、多个异常分别处理
    2、多个异常一次捕获，多次处理
    3、多个异常一次捕获，一次处理
     */
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3};
//
//        //    1、多个异常分别处理
         /*
        一个try多个catch注意事项
        catch里边是定义的异常变量，如果有子父类关系，那么子类异常变量必须写在上边，否则就会报错
        ArrayIndexOutOfBoundsException extends IndexOutOfBoundsException
         */
//        try {
//            System.out.println(arr[3]);// ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
//
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println(e);
//        }
//        List<Integer> list = List.of(1, 2, 3);
//        try {
//            System.out.println(list.get(4)); // java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
//        }catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println(e);
//        }

        //2、多个异常一次捕获，多次处理
        // 注意：子类异常放在上面，父类异常放在下边

//        try {
//            int[] arr = {1, 2, 3, 4};
//            System.out.println(arr[6]); // ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
//            List<Integer> list = List.of(1, 2, 3);
//            System.out.println(list.get(7));
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println(e);
//        } catch (Exception e) {
//            System.out.println(e);
//        }


        // 多个异常一次捕获，一次处理
//        try {
//            int[] arr = {1, 2, 3, 4};
//            System.out.println(arr[6]); // ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
//            List<Integer> list = List.of(1, 2, 3);
//            System.out.println(list.get(7));
//        } catch (Exception e) {
//            System.out.println(e);
//        }
        // 运行异常被抛出可以不处理。即不捕获也不声明抛出
        // 默认会给虚拟机处理，终止程序，什么时候不抛出运行时异常了，再继续执行程序
        int[] arr = {1, 2, 3, 4};
        System.out.println(arr[6]); // ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
        List<Integer> list = List.of(1, 2, 3);
        System.out.println(list.get(7));





        System.out.println("后续代码");

    }


}
