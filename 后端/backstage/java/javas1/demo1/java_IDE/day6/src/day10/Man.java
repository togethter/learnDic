package day10;

public class Man extends HuMan {
    // 子类重写父类sayHello方法
    @Override
    public void sayHello() {
        System.out.println("hello,我是man");
    }

    // 定义一个方法参数传递Greetable接口
    public void method(Greetable g) {
        g.greet();
    }

    public void show() {
        // 调用method方法，方法的参数Greetable是一个函数式接口，所以可以传递lambda表达式

//        method(()->{
//            // 创建父类对象
//            HuMan hman = new HuMan();
//            // 调用父类的sayhello方法
//            hman.sayHello();
//        });
        // 因为有字符类关系，所以存在一个关键字super，代表父类，所以我们可以直接调用super调用父类的成员方法
        method(() -> {
            super.sayHello();
        });
        /*
         使用super引用父类的成员方法,super是已经存在的
         父类的成员方法sayHello也是已经存在的
         所以我们可以直接使用super引用父类的成员方法
         */
        method(super::sayHello);
    }

    public static void main(String[] args) {
        new Man().show();
    }
}
