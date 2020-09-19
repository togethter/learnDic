package day7;
/*
实现卖票案例
 */

public class RunnableImpl implements Runnable {
    // 定义一个多个线程共享的票源
    private int ticket = 100;
    // 设置线程任务：卖票
    @Override
    public void run() {
       while (true) {
           // 先判断票是否存在
           if (ticket > 0) {
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               // 票存在，卖票，ticket
               System.out.println(Thread.currentThread().getName() + "----->正在卖第" + ticket + "张票");
               ticket--;
           } else  {
               break;
           }
       }
    }
}
