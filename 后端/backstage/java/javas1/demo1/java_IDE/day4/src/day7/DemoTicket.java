package day7;
/*
模拟卖票案例，创建3个线程，同时开启，对共享的票进行出售
 */
public class DemoTicket {
    public static void main(String[] args) {
        // 创建Runnable接口的实现类对象
        RunnableImpl run = new RunnableImpl();
        // 创建Thread对象，构造方法中传递Runnable接口的实现类对象
        Thread to0 = new Thread(run);
        Thread to1 = new Thread(run);
        Thread to2 = new Thread(run);
        // 调用start方法开启多线程
        to0.start();
        to1.start();
        to2.start();
    }
}
