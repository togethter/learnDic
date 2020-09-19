package day6;
//1、创建一个runnable接口的实现类
public class RunnableImpl implements Runnable {

    @Override
    public void run() {
//        2、在实现类中重写runnable接口的run方法，设置线程的任务
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "--->"+ i);
        }
    }
}
