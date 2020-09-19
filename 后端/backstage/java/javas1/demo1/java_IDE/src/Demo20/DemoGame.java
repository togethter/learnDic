package Demo20;

public class DemoGame {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.setName("艾希");
        hero.setSill(new SkillImpl());
    }
}
