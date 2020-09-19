package Demo20;

import Demo19.Skill;

public class Hero {
    private String name; // 英雄的名称
    private Skill sill; // 英雄的法术技能

    public Hero() {
    }

    public Hero(String name, Skill sill) {
        this.name = name;
        this.sill = sill;
    }

    public void attack() {
        System.out.println("我叫"+ name + "正在施放技能,");
        sill.use();
        System.out.println("施放技能完成");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skill getSill() {
        return sill;
    }

    public void setSill(Skill sill) {
        this.sill = sill;
    }
}
