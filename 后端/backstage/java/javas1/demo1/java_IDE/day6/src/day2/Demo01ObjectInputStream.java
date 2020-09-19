package day2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
java.io.ObjectInputStream extends InputStream
ObjectInputStream:对象中的反序列化流
作用：把文件中保存的对象，以流的方式读取出来使用
构造方法
1、ObjectInputStream(InputStream in) 创建从指定的InputStream读取的ObjectInputStream
参数：
InputStream in：字节输入流
特有的成员方法：
Object readObject() 从ObjectInputStream读取对象
使用步骤
1、创建ObjectInputStream对象，构造方法中传递字节输入流
2、使用ObjectInputStream对象的方法readObject保存对象的文件
3、释放资源
4、使用读取出来的对象(打印)
readObject 方法声明抛出ClassNotFoundException(class文件找不到异常)
当不存在对象的classw文件时抛出此异常
反序列化的前提：
1、类必须实现Serializable
2、必须存在类对象的class文件

static:静态关键字
静态优先于非静态加载到内存中(静态优先于对象进入到内存中)
被static修饰的成员变量不能被序列化的，序列化的都是对象
 private static int age;
 oos.writeObject(new Person("张三",14));
 Object o = ois.readObject();
Person{name='张三', age=0}

transient关键字：瞬态关键字
被transient修饰的成员变量，不能被序列化
private transient int age;
oos.writeObject(new Person("张三",14));
 Object o = ois.readObject();
Person{name='张三', age=0}
 */
public class Demo01ObjectInputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
//        1、创建ObjectInputStream对象，构造方法中传递字节输入流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"));
//        2、使用ObjectInputStream对象的方法readObject保存对象的文件
        Object o = ois.readObject();
//        3、释放资源
        ois.close();
//        4、使用读取出来的对象(打印)
        System.out.println(o);
    }
}
