package Demo4;

/*
static 修饰方法，静态方法，
静态方法不属于对象，属于类
 */
public class DemoStaticMethod {
    public static void main(String[] args) {
        MyClass my = new MyClass();
        my.method();
        MyClass.methodStatic();
        my.methodStatic();// 正确不推荐使用，java翻译成为类方法
    }

}
