package reflect;

import java.lang.reflect.Constructor;

/*
    2、获取构造方法
        *Constructor<?> [] getConstructors()
        *Constructor<T> [] getConstructors(类<?>...parameterTypes)

        *Constructor<T> [] getDeclaredConstructors(类<?>...parameterTypes)
        *Constructor<?> [] getDeclaredConstructors()
    3、获取成员方法
        * Method[] getMethods()
        * Method getMethod(String name,类<?> ...parameterTypes)

        * Method[] getDeclaredMethods()
        * Method getDeclaredMethod(String name,类<?> ...parameterTypes)
    4、获取类名
        *String getName()



*Field:成员变量
    *操作：
    1、设置值
        * void set(Object obj,Object value)
    2、获取值
        *get(Object obj)
    3、忽略权限修饰符
        *setAccessible(true):暴力反射

 */
public class ReflectDemo02 {
    public static void main(String[] args) throws Exception {
        // 0.获取Person的Class对象
        Class personClass = Person.class;
        /*
        2、获取构造方法
        *Constructor<?> [] getConstructors()
        *Constructor<T> [] getConstructors(类<?>...parameterTypes)

        *Constructor<T> [] getDeclaredConstructors(类<?>...parameterTypes)
        *Constructor<?> [] getDeclaredConstructors()
         */
        // 1. Constructor<?> [] getConstructors() ：获取所有public修饰的成员变量

        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        // 创建对象
        Object person = constructor.newInstance("张三", 23);
        System.out.println(person);
        System.out.println("============================");
        Constructor constructor1 = personClass.getConstructor();
        System.out.println(constructor1);
        // 创建对象
        Object person1 = constructor1.newInstance();
        System.out.println(person1);

        Object o = personClass.newInstance();
        System.out.println(o);
        constructor1.setAccessible(true);// 暴力反射
    }
}
