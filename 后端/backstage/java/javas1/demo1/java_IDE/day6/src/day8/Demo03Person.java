package day8;

public class Demo03Person {
    private String name;

    public Demo03Person() {
    }

    public Demo03Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Demo03Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
