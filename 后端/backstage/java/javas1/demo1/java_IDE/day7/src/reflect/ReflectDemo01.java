package reflect;

import java.lang.reflect.Field;

/*
Class对象功能：
    *获取功能
    1、获取成员变量们
        *Field[] getFields():获取所有public修饰的成员变量
        *Field getField(String name):获取指定名称的public修饰的成员变量
        *Field[] getDeClaredField()：获取所有的成员变量 不考虑修饰符
        *Field[] getDeClaredField(String name) 获取指定名称的成员变量 不考虑修饰符

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
Constructor:构造方法
    *创建对象：
        *T newInstance(object...initarges)

        *如果使用空参数构造方法创建对象，操作是可以简化：Class.newInstance方法

*Method:方法对象
    *执行方法：
    *Object invoke(Object obj,Object...args)
    *获取方法的名称：
    * String getName:获取方法名

*案例
    *需求：写一个框架，可以帮我们创建任意类的对象，并且执行其中任意方法

 */
public class ReflectDemo01 {
    public static void main(String[] args) throws Exception {
        // 0.获取Person的Class对象
        Class personClass = Person.class;
        /*
         1、获取成员变量们
         *Field[] getFields[]
         *Field getField(String name)
         *Field[] getDeClaredField(String name)
         */
        // 1. Field[] getFields[] ：获取所有public修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("----------------------");
        //2、Field getField(String name):获取指定名称的 public修饰的成员变量
        Field a = personClass.getField("a");
        System.out.println(a);

        // void set(Object obj,Object value)
        // 获取a变量的值
        Person ps = new Person();
        Object value = a.get(ps);
        System.out.println(value);
        // 设置值
        // get(Object obj)
        a.set(ps,"张三");
        System.out.println(ps);
        System.out.println("========================");
//        Field[] getDeClaredField() :获取所有的成员变量 不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        Field c = personClass.getDeclaredField("c");
        // 忽略访问权限修饰符的安全检查
        c.setAccessible(true); // 暴力反射
        Object value2 = c.get(ps);
        System.out.println(value2);



    }
}
