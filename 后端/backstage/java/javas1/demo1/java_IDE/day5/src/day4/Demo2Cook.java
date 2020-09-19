package day4;

/*
    给定一个厨子接口，内含一个唯一的抽象方法makeFood,且无参数，无返回值。
    使用lambda标椎格式调用invokeCook方法，打印输出"吃饭了"字样

 */
public class Demo2Cook {
    public static void main(String[] args) {
// 调用invokeCook方法，参数Cook接口，传递Cook接口的匿名内部类对象
        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("使用匿名内部类吃饭了");
            }
        });

        // 使用Lambda表达式，简化匿名内部类的书写
        // 优化省略
        invokeCook(()-> System.out.println("使用lambda表达式吃饭了")
        );
    }
    // 定义一个方法，参数传递Cook接口，方法内部调用Cook接口的方法makeFood

    public static void invokeCook(Cook cook) {
        cook.makeFood();
    }
}
