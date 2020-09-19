package day5;

/*
自动装箱与自动拆箱
基本类型的数据和包装类之间可以自动的相互转换
JDK1.5之后出现的新特性
 */
public class Demo2Integer {
    public static void main(String[] args) {
        /*
        直接把Int类型的整数赋值给包装类，
        Integer in = 1;相当于Integer in = new Integer(1);
         */
        Integer in = 1;
        /*
        自动拆箱 in是包装类无法直接参与运算，可以自动转换为基本类型的数据，在参与计算
        in + 2; 相当于 in.intValue() + 2 = 3;
        in = in + 2; 相当于 in = new Integer(3); 自动装箱
         */

        in = in + 2;
    }
}
