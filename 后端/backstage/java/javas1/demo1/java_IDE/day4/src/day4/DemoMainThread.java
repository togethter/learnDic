package day4;
/*
主线程，执行主方法的线程
单线程程序：java线程中只有一个线程，执行从main方法开始，从上到下依次执行。

JVM执行main方法，main方法会进入到栈内存
JVM会找操作系统，开辟一条main方法，通过cpu的执行路径
cpu就会通过这个路径来执行main方法
而这个路径有一个名字叫做，叫做main(主)线程
 */
public class DemoMainThread {
    public static void main(String[] args) {
        Person p1 = new Person("小强");
        p1.run();
        Person p2 = new Person("旺财");
        p2.run();

    }
}
