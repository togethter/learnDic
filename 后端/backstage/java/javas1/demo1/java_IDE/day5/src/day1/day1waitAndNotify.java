package day1;

/*
等待唤醒案例：线程之间的通信
创建一个顾客线程(消费者):告知老板要的包子的种类和数量，调用wait方法，
放弃cpu的执行进入waiting状态(无线等待状态)
创建一个老板线程(生产者):花了5s做包子，做好包子之后，调用notify方法，唤醒顾客吃包子
注意：
    顾客和老板线程必须使用同步代码块包裹起来，保证等待和唤醒只能有一个在执行
    同步使用的锁对象必须保证唯一
    只有锁对象才能调用wait和notify方法
Object类中的方法
    void wait()
        在其他的线程调用此对象，notify()和notifyAll()方法前，导致当前线程等待
    void notify()
        唤醒在此对象监视器上等待的单个线程。
        会继续执行wait方法之后的代码

 */
public class day1waitAndNotify {
    public static void main(String[] args) {
        // 创建锁对象
        Object object = new Object();
        // 创建一个顾客线程(消费者)
        new Thread() {
            @Override
            public void run() {
                while (true) { // 一致等着买包子
                    //                保证等待和唤醒只能有一个在执行，需要使用同步技术
                    synchronized (object) {
                        System.out.println("告知老板要的包子的种类和数量");
//                    调用wait方法，放弃cpu的执行进入waiting状态(无线等待状态)
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // 唤醒之后执行执行的代码
                        System.out.println("包子做好了，开吃");
                        System.out.println("---------------------------------------");
                    }
                }
            }
        }.start();

        // 创建一个老板的线程
        new Thread() {
            @Override
            public void run() {
                while (true) { // 一直做包子
                    //                保证等待和唤醒只能有一个在执行，需要使用同步技术
                    try {
                        Thread.sleep(5000); // 花费5s做包子，
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (object) {
                        System.out.println("老板5s后做好包子,告知顾客可以吃包子");
//                    做好包子之后，调用notify方法，唤醒顾客吃包子
                        object.notify();
                    }
                }
            }
        }.start();

    }
}
