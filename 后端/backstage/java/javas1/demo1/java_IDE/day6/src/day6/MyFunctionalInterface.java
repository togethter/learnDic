package day6;
/*
函数式接口：有且只有一个抽象方法的接口，称为函数式接口
当然接口中可以包含其他的方法(默认静态私有)
@FunctionalInterface注解
作用：可以检测一个接口是否是函数式接口
是：编译成功
否：编译失败(接口中没有抽象方法，接口中的抽象方法多余1个)
 */
@FunctionalInterface
public interface MyFunctionalInterface {
    // 定义一个抽象方法
    public abstract void method();
}
