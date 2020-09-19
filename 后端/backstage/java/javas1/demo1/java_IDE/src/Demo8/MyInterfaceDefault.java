package Demo8;
/*
java8开始，接口允许定义默认方法
格式：
public defalut 返回值类型 方法名称 (参数列表) {
方法体...
}
备注
接口当中的方法可以j接口升级的问题
 */
public interface MyInterfaceDefault {
    // 抽象方法
    public abstract void  methodAbs();
    // 新添加的抽象方法
//    public abstract void  methodAbs2();
    // 新添加的方法改成defalut方法
    public  default void methodDefult() {
        System.out.println("这是新添加的默认方法");
    }
}
