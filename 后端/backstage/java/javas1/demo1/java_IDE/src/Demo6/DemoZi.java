package Demo6;

public class DemoZi extends DemoFu {
    public DemoZi() {
//        super(20);
//        System.out.println("子类构建方法创建！");
        this(20,10);// 本类的无参构造调用本类的有参构造
    }

    public DemoZi(int a) {
        super(20);
    }

    public DemoZi(int b, int c) {
        super(20);

    }

}
