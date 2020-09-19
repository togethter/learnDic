package Demo9;

public class MyInterfaceImpl implements MyInterfaceA,MyInterfaceB{
    @Override
    public void methodA() {
        System.out.println("覆盖重写了A方法");
    }

    @Override
    public void methodAbs() {
        System.out.println("覆盖重写了A,B接口都有的抽象法方法");
    }

    @Override
    public void methodDefault() {
        System.out.println("对多个接口当中冲突的默认接口进行覆盖重写");
    }

    @Override
    public void methodB() {
        System.out.println("覆盖重写了B方法");
    }
}
