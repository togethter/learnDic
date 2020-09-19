package day4;
/*
    Lambda表达式的标椎格式
    由三部分组成
    a：一些参数
    b：一个箭头
    c：一段代码
    格式
    (参数列表)->{重写方法的代码};
    解释说明的格式：
    ():接口中抽象方法的参数列表，没有参数，就空着；有参数就写出参数，多个参数使用逗号分隔
    ->:传递的意思，把参数传递给方法体{}
    {}：重写接口的抽象方法的方法体
 */
import day3.RunnableImpl;

public class Demolambda {
    public static void main(String[] args) {
        // 使用匿名内部类的方式，实现多线程
        new Thread(new RunnableImpl(){
            @Override
            public void run() {
                System.out.println("匿名内部类创建子线程" + Thread.currentThread().getName());
            }
        }).start();

        // 使用lambda表达式，实现多线程
        new Thread(() ->{
            System.out.println("lambda创建的多线程" + Thread.currentThread().getName());
        }).start();
    }
}
