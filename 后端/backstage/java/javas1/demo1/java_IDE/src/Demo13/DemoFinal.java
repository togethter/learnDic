package Demo13;
/*
final关键字代表最终，不可变变
常见的4中用法
1、可以用来修饰一个类
2、也可以用来修饰一个方法
3、还可以用来修饰一个局部变量
4、还可以用来修饰一个成员变量
 */
public class DemoFinal {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(num);
        num = 20;
        System.out.println(num);
        final int num1 = 10;
        System.out.println(num1);
        // final 修饰的局部变量不能修改，一次赋值，终生不变
//        num1 = 33; // 错误写法！不能改变


    final int num2;
    num2 = 39;// 正确的写法！只要保证有一次唯一一次赋值即可

        // 对于基本类型来说，不可变的是变量当中的数据不可改变
        // 对于引用类型来说，不可变的是变量当中的地址值不可改变

        Student stu = new Student("赵丽颖");
        System.out.println(stu.getName());// 赵丽颖

        stu = new Student("霍建华");
        System.out.println(stu.getName());// 霍建华
        final Student stu1 = new Student("小四毛");
//        stu1 = stu; // stu1 的地址值不能修改



    }
}
