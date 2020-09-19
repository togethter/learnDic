package Demo19;

public class DemoMain {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.setName("艾希");

//        Skill skill = new Skill() {
//            @Override
//            public void use() {
//                System.out.println("~~~~~~~");
//            };
//        };
//
//        hero.setSill(skill);
        // 同时使用匿名内部类和匿名对象
        hero.setSill(new Skill() {
            @Override
            public void use() {
                System.out.println("~~~~~");
            }
        });

        hero.attack();
    }
}
