package Demo4;
/*
Static，如果一个成员变量使用了static关键字，那么变量不在属于对象自己，而是属于所在的类，多个对象共享
 */
public class Student {
    private String name;
    private int age;
    static  String room;
    private int Id;
    static  int idCounter;
    public  Student(){
        this.Id = ++idCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.Id = ++idCounter;
    }
}
