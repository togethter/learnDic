package Demo13;

/*
    对于成员变量来说，如果使用final关键字修饰，那么这个变量也照样是不可变
    1、由于成员变量具有默认值，所以用了final之后，必须手动赋值，不会再给默认值了
    2、对于final的成员变量，要么使用直接赋值，要么使用通过构造方法赋值，二者选其一
    3、必须保证类中所有的重载的类方法，最终会对final成员变量进行赋值。
 */
public class Person {
    private final String name;/*= "鹿晗";*/

    public Person() {
    name = "关晓彤";
    }
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }
}
