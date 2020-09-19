package com.bjpowernode.ba01;

import com.bjpowernode.ba02.School;

public class Student {
    private String name;
    private int age;
    // 声明一个引用类型
    private School school;
    public Student() {
        System.out.println("spring会调用类的无参数构造方法创建对象");
    }

    public void setSchool(School school) {
        System.out.println("setSchool:"+school);
        this.school = school;
    }

    public void setEmail(String email){
        System.out.println("setEmail="+email);
    }
    /*
    需要有set方法，没有set方法时报错的
    Bean property 'name' is not writable or has an invalid setter method
     */
    public void setName(String name) {
        System.out.println("setName:"+name);
        this.name = name;
    }

    public void setAge(int age) {
        System.out.println("setAge:"+age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
