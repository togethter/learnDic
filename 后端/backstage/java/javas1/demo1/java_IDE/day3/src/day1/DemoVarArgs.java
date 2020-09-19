package day1;

/*
可变参数是JDk1.5之后出现的新特性

使用前提：
当方法列表类型已经确定，但是参数的个数不确定，就可以使用可变参数
使用格式：定义方法时使用

 修饰符 返回值 方法名(数据类型... 变量名) {}
 可变参数的原理：
 可变参数底层就是一个数组，根据传递参数的个数不同，会创建不同长度的数组， 来存储这些参数，
 传递参数的个数可以是0个(不传递参数)，1，2...多个。

 */
public class DemoVarArgs {
    public static void main(String[] args) {
        int i = add(10,20);
        System.out.println(i);
     }

    /*
    定义0-n个整数和的方法
    已知计算整数的和，数据类型已经确定Int
    单数参数的个数不确定，不知道要计算几个整数的和，就可以使用可变参数
    add 会创建一个长度为0的数组 new Int[0]
    add(10) 会创建一个长度为1 的数组,存储传递过来的参数， new Int[] { 10 }
    add(10,20) 会创建一个长度为2 的数组,存储传递过来的参数， new Int[] { 10 ,20}

    可变参数的注意事项
    1、一个方法的参数列表，只能有一个参数列表
    public static void method(int....a,int...b){}
    2、如果一个方法的参数有多个，那么可变参数必须写在参数列表的末尾
    public static void method1(int a,int b,int...c){}
     */

    // 可变参数的终极写法
    public static void method(Object...obj){

    }
    public static int add(int...arr){
//        System.out.println(arr);// [I@2c8d66b2 底层是一个数组
//        System.out.println(arr.length); // 0
        // 第一一个初始化的变量，记录累加求和
        int sum = 0;
        // 遍历数组，获取数组中的每一个元素
        for (int i :
                arr) {
            sum += i;
        }
        return sum;
    }



}
