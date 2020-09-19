package day6;
/*
    创建多线程程序的第二种方法，实现Runnable接口
    java.lang.runnable接口
        runnable接口应该由那些打算通过某一线程执行其实例的类来实现，类，必须定义一个称为run的无参数方法
    java.lang.Thread类的构造方法
    Thread(Runable target)
    分配新的 Thread对象
    Thread(Runable target,String name)
    分配新的Thread对象
    实现步骤
    1、创建一个runnable接口的实现类
    2、在实现类中重写runnable接口的run方法，设置线程的任务
    3、创建一个实现runnable接口的实例对象
    4、创建Thread类对象，构造方法中传递runnable接口的实现类对象
    5、调用Thread类中的start方法， 开启新的线程执行run方法

    实现Runnable接口创建多线程程序的好处
    1、避免了单线程的局限性
        一个类只能继承一个类，类继承了Thread类不能继承其他的类
        实现了Runnable接口，它还可以继承其他的类，实现其他的接口
    2、增强了程序的扩展性，降低了程序的耦合性(解耦)
    实现Runnable接口的方式，把设置线程任务和开启新的线程进行分离(解耦)
    实现类中重写了run方法，用来设置线程任务，
    创建Thread对象，调用start方法：用来开启新的线程



 */
public class Demo01Runnable {
    public static void main(String[] args) {
//        3、创建一个实现runnable接口的实例对象
        RunnableImpl run = new RunnableImpl();
        RunnableImpl2 run2 = new RunnableImpl2();
        Thread t1 = new Thread(run);
        t1.start();
        Thread t = new Thread(run2);
        t.start();
    }
}
