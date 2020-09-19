package day1;
/*
    进入TimeWaiting(计时等待)有两种方式
    1、使用sleep(Long m)方法,在毫秒值结束之后，线程睡醒进入到Runnable/Blocked状态
    2、使用wait(Long m)方法，wait方法如果在毫秒值结束之后，还没有被notify唤醒，就会自动醒来
    线程睡醒进入到Runnable/Blocked状态

    唤醒的方法
    1、void notify()唤醒在此对象监视器上等待的单个线程。
    2、void notifyAll()唤醒在此对象监视器上等待的所有线程。
 */
public class day2waitAndNotify {
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
                        System.out.println("告知1老板要的包子的种类和数量");
//                    调用wait方法，放弃cpu的执行进入waiting状态(无线等待状态)
                        try {
                            object.wait(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // 唤醒之后执行执行的代码
                        System.out.println("包子做好了，顾客1开吃");
                        System.out.println("---------------------------------------");
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) { // 一致等着买包子
                    //                保证等待和唤醒只能有一个在执行，需要使用同步技术
                    synchronized (object) {
                        System.out.println("告知2老板要的包子的种类和数量");
//                    调用wait方法，放弃cpu的执行进入waiting状态(无线等待状态)
                        try {
                            object.wait(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // 唤醒之后执行执行的代码
                        System.out.println("包子做好了，顾客2开吃");
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
//                        object.notify(); // 如果有多个等待线程，随机唤醒一个
                        object.notifyAll();//  唤醒所有等待的线程
                    }
                }
            }
        }.start();
    }
}
