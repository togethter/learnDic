package Demo17;

public class MyInterfaceImpl implements  MyInterface {
    @Override
    public void method() {
        System.out.println("实现类覆盖重写了方法");
    }

    @Override
    public void method2() {
        System.out.println("实现类覆盖重写了222方法");
    }
}
