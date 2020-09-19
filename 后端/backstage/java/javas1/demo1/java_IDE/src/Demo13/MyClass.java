package Demo13;
/*
当final关键字用来修饰一个类的时候格式：
public final class 类名称{
// ...
}

含义：当前这个类不能有任何的子类
注意：
一个类如果是final的，那么其中的所有的成员变量都不能覆盖重写
 */
public final class MyClass {

    public void method() {
        System.out.printf("方法执行！");
    }

}
