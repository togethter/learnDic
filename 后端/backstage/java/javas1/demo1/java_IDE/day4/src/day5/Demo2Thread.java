package day5;

public class Demo2Thread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        new MyThread().start();
        new MyThread().start();


    }
}
