package Demo10;
/*
这个接口有当中有几个方法? 4个
methodA来源于接口A
methodB来源于接口B
methodCommon来源接口A，B
method来源接口MyInterface

 */
public interface MyInterface extends MyInterfaceA,MyInterfaceB {
    public abstract void method();

    @Override
    default void methodDefault() {

    }
}
