package day11Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
卖票案例实现了线程安全的问题
卖出了不存在的票和重复的票
解决线程安全安全问题的三种方案：使用Lock锁
java.lang.concurrent.locks.lock接口
lock实现了提供比使用synchronized方法和语句可获得的更广泛的锁定操作
lock接口中的方法：
void lock()获取锁
void unlock()释放锁
java.util.concurrent.locks.ReentrantLock implements Lock接口

使用步骤
1、在成员未知创建一个ReentrantLock对象
2、在可能会在出现安全问题的代码前调用Lock接口的方法Lock获取锁
3、在可能会出现安全问题的代码前，调用Lock接口的方法unlock获取锁
 */
public class RunnableImpl implements Runnable {
    // 定义一个多个线程共享的票源
    private static int ticket = 100;
    //1、在成员未知创建一个ReentrantLock对象
    Lock l = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
//            2、在可能会在出现安全问题的代码前调用Lock接口的方法Lock获取锁
            l.lock();
            try {
//                 创建同步代码块
                if (ticket > 0) {
//                     票存在，卖票，ticket
                    System.out.println(Thread.currentThread().getName() + "----->正在卖第" + ticket + "张票");
                    ticket--;
                } else {
                    break;
                }
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
//                3、在可能会出现安全问题的代码前，调用Lock接口的方法unlock获取锁
                l.unlock(); // 无论程序是否一场都会把锁示释放掉
            }
        }
    }
    // 设置线程任务：卖票
//    @Override
//    public void run() {
//        while (true) {
////            2、在可能会在出现安全问题的代码前调用Lock接口的方法Lock获取锁
//            l.lock();
//            // 创建同步代码块
//            if (ticket > 0) {
//                // 票存在，卖票，ticket
//                System.out.println(Thread.currentThread().getName() + "----->正在卖第" + ticket + "张票");
//                ticket--;
//            } else {
//                break;
//            }
////            3、在可能会出现安全问题的代码前，调用Lock接口的方法unlock获取锁
//            l.unlock();
//        }
//    }

    /*
     定义一个同步方法
     同步方法内部也会把方法内部锁住
     只让一个线程执行
     同步方法的锁对象是谁？
     就是实现类对象
     new RunnableImpl()
     也就是this
     */
    //
    public static synchronized boolean playTicket() {
        if (ticket > 0) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            // 票存在，卖票，ticket
            System.out.println(Thread.currentThread().getName() + "----->正在卖第" + ticket + "张票");
            ticket--;
            return true;
        } else {
            return false;
        }

    }
}
