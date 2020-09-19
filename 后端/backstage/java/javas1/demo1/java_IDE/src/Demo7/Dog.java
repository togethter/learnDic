package Demo7;

public class Dog extends  Animal {
    public  Dog(){
        System.out.println("子类构造方法执行！");
    }
    @Override
    public  void eat(){
        System.out.println("狗吃骨头");
    }
}
