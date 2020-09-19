package day7;
/*
测试含有泛型的方法
 */
public class Demo3GenericMethod {
    public static void main(String[] args) {
    // 创建一个GenericMethod对象，
        GenericMethod gm = new GenericMethod();
        gm.method01(123);
        /*
         调用含有泛型的方法method1
         传递什么类型，泛型就是什么类型
         */
        gm.method02("静态方法不建议创建对象使用");
        // 静态方法，通过类名.方法名(参数)可以直接使用
        GenericMethod.method02("静态方法");
        GenericMethod.method02(1);


    }
}
