package Demo12;
/*
在多特的代码当中，成员方法的访问规则是：
看new的时谁，就优先用谁，没有则向上找

口诀：编译看左边，运行看右边。

对比一下：
成员变量，编译看左边，运行还看左边，
成员方法，编译看左边，运行看右边


 */
public class Demo02MultiMethod {
    public static void main(String[] args) {
        Fu obj = new Zi(); // 多特
        obj.method();// 父子都有，优先用子
        obj.methodFu();// 子类没有父类有，向上找到父类
        // 编译看左边，左边是Fu，Fu当中没有methodZi方法，
        // 所以编译报错
        //obj.methodZi(); // 错误写法

    }
}
