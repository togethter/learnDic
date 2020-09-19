package day12;
/*
定义一个创建Person对象的函数式接口
 */

@FunctionalInterface
public interface GZ01PersonBulider {
    // 定义一个方法，根据传递的姓名，创建person对象返回
    GZ01Person builderPerson(String name);
}
