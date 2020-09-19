package day6;
/*
函数式接口使用，一般可以作为方法的参数和返回值
 */
public class Demo {
    // 定义一个方法，参数使用函数式接口MyFunctionalInterface
    public static void show(MyFunctionalInterface myinter) {
        myinter.method();
    }
    public static void main(String[] args) {

        /*
         调用show接口，方法的参数是一个接口，所以可以传递接口的实现类对象
         所以可以传递接口的实现类对象
         */
        show(new MyFunctionalInterfaceImpl());
        /*
        调用show接口，方法的参数是一个接口,所以我们可以传递接口的内名内部类
         */
        show(new MyFunctionalInterface() {
            @Override
            public void method() {
                System.out.println("使用匿名内部类重写接口的抽象方法");
            }
        });
        /*
        调用show接口，方法的参数是一个函数式接口，所以我们可以传递lambda表达式
         */
        show(()->{
            System.out.println("使用lambda表达式重写接口中的抽象方法");
        });
        /*
         简化lambda表达式
         */
        show(()->System.out.println("使用lambda表达式重写接口中的抽象方法"));


    }
}
