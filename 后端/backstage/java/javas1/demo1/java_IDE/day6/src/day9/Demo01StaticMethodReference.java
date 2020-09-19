package day9;

/*
通过类名引用静态成员方法
类已经存在，静态成员方法也已经存在
就可以直接通过类名直接引用成员方法
 */
public class Demo01StaticMethodReference {
    // 定义一个方法，方法的参数传递要计算绝对值的整数和函数式接口，calcable
    public static int method(int number, Calcable c) {
       return c.calsABs(number);
    }

    public static void main(String[] args) {
        // 定义method方法，传递计算绝对值的整数和lambda表达式
        int method = method(-10, (n) -> {
            // 对参数进行绝对值计算得计算并返回计算结果
            return Math.abs(n);
        });

        System.out.println(method);

        /*
        使用方法引用优化lambda表达式
        Math类是存在的
        abs计算静态方法也是已经存在的
        所以我们可以直接通过类名引用静态方法
         */
        int num = method(-110, Math::abs);
        System.out.println(num);
    }

}
