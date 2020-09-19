package day12;
/*
类的构造器(构造方法)引用
 */
public class GZ01Demo {
    // 定义一个方法，传输传递姓名和PersonBulider接口
    // 方法中通过姓名创建Person对象

    public static void printName(String name, GZ01PersonBulider pb){
        GZ01Person ps = pb.builderPerson(name);
        System.out.println(ps.getName());
        System.out.println(ps);
    }
    public static void main(String[] args) {
        // 调用printname方法，方法的参数personBuilder接口是一个函数式接口，可以传递lambda
        printName("类的构造器",(name)->{
            return   new GZ01Person(name);
        });
        /*
        使用方法引用优化lambda表达式
        构造方法new Person(String name)已知
        创建对象已知
        就可以使用Person引用new创建对象
         */
        printName("古力娜扎", GZ01Person::new);// 通过使用Person类带参构造方法，通过传递姓名创建对象
    }
}
