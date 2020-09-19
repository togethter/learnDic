package Demo15;

public class Body { // 外部类
    public class Heart { // 成员内部类

        public void beat() {
            System.out.println("心脏蹦蹦跳");
            System.out.println("我的名字叫" + name); // 正确的写法
        }

    }

    private String name;

    public Body() {
    }

    public Body(String name) {
        this.name = name;
    }

    public void methodBody(){
        new Heart().beat();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
