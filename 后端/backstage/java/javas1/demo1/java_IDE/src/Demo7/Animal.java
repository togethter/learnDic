package Demo7;
/*
抽象就是加上abstract关键字,然后去掉大括号，直接分号结束
抽象类，抽象方法的所在类必须是必须是抽象类才行，在class之前写上abstract即可
eg:
public abstract class Animal {
// 抽象方法代表吃东西
public abstract void eat();
// 普通的成员方法
public void method() {}
}
如何使用抽象类和抽象方法
1、不能直接创建抽象类对象
2、必须用一个子类继承抽象父类
3、子类必须覆盖重写抽象父类当中的所有抽象方法
子类去掉抽象方法的abstract关键字，然后不上方法体和大括号
4、创建子类对象进行使用
 */
public abstract class Animal {
    public abstract void eat();
    public  Animal(){
        System.out.println("父类抽象构造执行!");
    }
    public void method(){

    }
}
