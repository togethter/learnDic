package day5;

/*
获取线程的名称
1、使用Thread类中的方法getName()返回线程的名称
2、先获取到当前正在执行的线程，使用线程中的方法getName(),获取线程的名称
    static Thread currentThread()返回当前正在执行的引用


 */
// 定义一个thread类的子类
public class MyThread extends Thread {
    // 重写Thread类中的run方法，设置线程任务
    @Override
    public void run() {
        // 获取线程名称
        System.out.println("当前的线程:" + currentThread() + ",线程的名字:" + getName());
    }


}
