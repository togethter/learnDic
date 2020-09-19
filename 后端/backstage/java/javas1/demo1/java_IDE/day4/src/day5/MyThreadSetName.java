package day5;
/*
设置线程的名称:(了解)
    1、使用Thread类中的方法setName(名字)
        void setName(String name),改变线程的名称，使之与参数name相同
    2、创建一个带构造的方法参数传递线程的名称，调用父类带参构造方法，把线程名称传递给父类，让父类(Thread)给子线程起一个名字
        Thread(String name) 分配新的Thread对象

 */
public class MyThreadSetName  extends Thread{

    public MyThreadSetName() {
    }
    public MyThreadSetName(String name) {
        super(name);//把线程名称传递给父类，让父类(Thread)给子线程起一个名字
    }

    @Override
    public void run() {
    // 获取线程的名称
        System.out.println(Thread.currentThread().getName());
    }
}
