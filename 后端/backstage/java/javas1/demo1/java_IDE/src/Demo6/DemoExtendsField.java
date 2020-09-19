package Demo6;
/*
    继承关系中，父子类构建方法的特点
    1、子类构建方法当中有一个默认隐藏的"super()"调用，所以一定是先调用的父类构造然后执行子类构造
    2、可以通过super关键字让子类构造调用父类构造
    3、super的父类构造调用，必须是子类构造方法的第一句，不能一个子类构造调用多次super构造
    总结：
    子类必须调用父类构造方法，不写则赠送一个super(),写了则用了指定的super调用，super只能有一个，还必须是第一个


    super关键字用来访问父类的内容，而this关键字用来访问本类内容。
    this三种用法
    1、在本类的成员方法中，访问本类的成员变量
    2、在本类的成员方法中，访问本类的成员方法
    3、在本类的构造方法中，访问本类的而另一个构造方法
    在第三种方法中要注意
    A:this(...)调用也必须是构造方法的第一句，唯一一个
`   B:super和this两种调用不能同时使用
 */
public class DemoExtendsField {
    public static void main(String[] args) {
        DemoZi zi = new DemoZi();

    }
}
