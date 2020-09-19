package Demo8;
/*
1、接口的默认方法，可以通过接口实现类对象，直接调用
2、接口的默认方法，也可以被接口实现类进行覆盖重写
 */
public class Demo2Interface {
    public static void main(String[] args) {
        MyinterfaceDefalutA a = new MyinterfaceDefalutA();
        a.methodAbs(); // 实现了抽象方法，AAA
        // 调用默认方法,如果实现类当中没有，会向上找接口
        a.methodDefult(); // 这是新添加的默认方法
        MyinterfaceDefalutB b = new MyinterfaceDefalutB();
        b.methodAbs(); // 实现了抽象方法，BBB
        b.methodDefult(); // 实现类B覆盖重写了接口的默认方法
    }
}
