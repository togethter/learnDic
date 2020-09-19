package day2;

import java.io.Serializable;

/*
序列化或者反序列化会抛出NotSerializableException会抛出没有序列化异常
类通过实现java.io.serializable接口以启用其序列化功能，未实现此接口的类将无法使其任何状态序列化或反序列化
Serializable接口也叫标记型接口
要进行序列化和反序列化的类必须实现Serializable接口，就会给类添加一个标记
当使用序列化或者反序列化的时候，就会检测类上是否有这个标记
有：就可以列化或者反序列化
没有：就会抛出NotSerializableException
 */
public class Person implements Serializable {
    private static final long serialVersionUID = -3763142356764564266L;
    public String name;
    //    private static int age;
//    private  int age;
    private transient int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
