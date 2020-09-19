package day7;

/*
递归：方法自己调用自己
    递归的分类：
    递归分为两中，直接递归和间接递归
    直接递归分为方法自身调用自己
    间接递归分为A方法调用B方法，B方法调用C方法，C方法调用A方法。
    注意事项：
    1、递归一定要有条件限定，保证递归能够停止下来，否则会发生栈内存溢出
    2、在递归中虽然有限定条件，但是递归的次数不能太多，否则也会发生栈内存溢出
    3、构造方法禁止递归
    递归的使用前提
    1、当调用方法的时候，方法的主题不变，每次调用方法的参数不同，可以使用递归
 */
public class DemoRecursion {
    public static void main(String[] args) {
//        a();
//        b(1);
    }

    /*
        3、构造方法禁止递归
        编译报错，构造方法时创建对象使用的，一直递归会导致内存中创建多个对象，直接编译报错
     */
    public DemoRecursion() {
//        DemoRecursion();
    }

    /*
        2、在递归中虽然有限定条件，但是递归的次数不能太多，否则也会发生栈内存溢出
        Exception in thread "main" java.lang.StackOverflowError
     */
    private static void b(int i) {
        System.out.println(i);
        if (i == 20000) {
            return;
        }
        ;
        b(++i);

    }

    /*
    1、递归一定要有条件限定，保证递归能够停止下来，否则会发生栈内存溢出
    StackOverflowError
     */
    private static void a() {
        System.out.println("a方法！");
//        a();
    }
}
