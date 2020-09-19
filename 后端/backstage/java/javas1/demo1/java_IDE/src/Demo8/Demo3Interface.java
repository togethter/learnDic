package Demo8;
/*
不能通过接口实现类对象，来调用接口当中的静态方法
正确用法：通过接口名称直接调用其中的静态方法
接口名称.静态方法名(参数 )
 */
public class Demo3Interface {
    public static void main(String[] args) {
    MyInterfaceStaticImpl impl = new MyInterfaceStaticImpl();
    // 错误的写法
    // impl.methodStatic();
        // 接口名称代用静态方法
        MyInterfaceStatic.methodStatic();
    }
}
