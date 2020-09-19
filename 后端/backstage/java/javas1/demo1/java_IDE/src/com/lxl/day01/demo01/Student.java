package com.lxl.day01.demo01;

public class Student {
    String name;
    int age;
    String sex;
    // 构造方法
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public  Student() {
        System.out.println("构造方法执行了");
    }
    public Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
