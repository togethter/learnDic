package Demo18;

public class DemoMain {
    public static void main(String[] args) {
//        创建一个英雄
        Hero hero = new Hero();
        hero.setName("盖伦");
        hero.setAge(14);
        Weapon weapon = new Weapon("多兰剑");
        hero.setWeapon(weapon);
        hero.attack();
    }
}
