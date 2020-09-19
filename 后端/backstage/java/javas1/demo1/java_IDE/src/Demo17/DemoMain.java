package Demo17;

/*
接口的实现类，（或者父类的子类），只需要使用唯一的一次，
那么这种情况下，就可以省略掉该类的定义，而改为使用【匿名内部类】
匿名内部类定义格式：
接口名称 对象名 = new 接口名称(){
// 覆盖重写所有抽象方法
}；

对格式"new 接口名称(){...}" 进行解析
1、创建对象的动作
2、接口就是匿名内部类实现哪个接口
3、这才是匿名内部类的内容

另外还需要注意几点内容
 1、匿名内部类在创建对象的时候只能使用唯一一次。
 如果希望多次创建对象，而且类的内容一样的话，那么就必须使用单独定义的实现类了
 2、匿名对象，在【调用方法】的时候，只能调用唯一一次。如果希望同一个对象，调用多次方法，那么
 必须给对象起一个名字
 3、匿名内部类是省略了【实现类\子类名称】，匿名对象是省略了对象【对象名称】。
 强调：
 匿名内部类和匿名对象不是一回事
 */
public class DemoMain {
    public static void main(String[] args) {
        MyInterface obj = new MyInterfaceImpl();
        obj.method();
        // 错误写法！
//        MyInterface obj1 = new MyInterface();
        // 使用匿名内部类,但不是匿名对象，对象名称就叫objA
        MyInterface objA = new MyInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类实现了A方法！");
            }

            @Override
            public void method2() {
                System.out.println("匿名内部类实现了A222方法！");
            }
        };
        objA.method();
        objA.method2();

        // 使用匿名内部类，而且省略对象名称
         new MyInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类实现了B方法！");
            }

            @Override
            public void method2() {
                System.out.println("匿名内部类实现了B222方法！");
            }
        }.method();
        // 因为匿名对象无法调用第二次方法，所以需要在创建一个匿名内部类匿名对象
        new MyInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类实现了B方法！");
            }

            @Override
            public void method2() {
                System.out.println("匿名内部类实现了B222方法！");
            }
        }.method2();



    }
}
