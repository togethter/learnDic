package Demo4;
/*
静态代码块的格式
静态代码块,使用到本类的时候,执行唯一一次。

用途：
1、用来一次性的对静态成员变量进行赋值
 */
public class Person {
        static {
            System.out.println("静态代码块执行！");
        }
        public Person(){
            System.out.println("构造方法执行了");
        }
}
