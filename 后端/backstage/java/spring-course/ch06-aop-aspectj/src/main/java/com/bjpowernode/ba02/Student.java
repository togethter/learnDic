package com.bjpowernode.ba02;

public class Student {
    private String name;
    private int age;
    // 声明一个引用类型

    public void setEmail(String email){
        System.out.println("setEmail="+email);
    }
    /*
    需要有set方法，没有set方法时报错的
    Bean property 'name' is not writable or has an invalid setter method
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
