package day10SynchronizedStatic;
/*
实现卖票案例
卖出了不存在的票和重复的票
解决线程安全的一种方案：使用同步方法

使用步骤
1、把访问了共享数据的代码提取出来，放到一个方法中
2、把方法添加synchronized修饰符
定义方法的格式：

修饰符 synchronized 返回值类型 方法名 (参数列表) {
可能会出现线程安全问题的代码(访问了共享数据的代码)
}
 */

public class RunnableImpl implements Runnable {
    // 定义一个多个线程共享的票源
    private static int ticket = 100;
    // 创建一个锁对象
    Object object = new Object();

    // 设置线程任务：卖票
    @Override
    public void run() {
        while (true) {
            // 创建同步代码块
            if (!playTicket()) {
                break;
            }
        }
    }

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
            return  true;
        } else  {
            return false;
        }

    }
}
