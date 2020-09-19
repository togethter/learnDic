package day5;

public class Demo3ThreadSetName {
    public static void main(String[] args) {
        MyThreadSetName tsn = new MyThreadSetName();
        tsn.setName("牛逼的线程");
        tsn.start();
        // 开启多线程
        new MyThreadSetName("小强").start();
    }
}
