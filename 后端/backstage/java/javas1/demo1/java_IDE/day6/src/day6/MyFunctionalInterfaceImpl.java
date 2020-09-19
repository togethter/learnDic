package day6;
/*
@Override
检测方法是否为重写的方法
是：编译成功
否：编译失败
 */
public class MyFunctionalInterfaceImpl implements MyFunctionalInterface{
    @Override
    public void method() {
        System.out.println("接口的实现类中重写抽象方法");
    }

//    @Override
//    public void method2() {
//
//    }
}
