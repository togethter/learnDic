package com.bjpowernode.ba03;

import com.bjpowernode.ba02.Student;

// 目标类
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        // 给dosome方法增加一个功能，在dosome()执行之前，输出方法的执行时间
        System.out.println("==目标方法dosome()==");
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("==目标方法doOther()==");
        return "abcd";
    }

    @Override
    public Student doOther2(String name, Integer age) {
        System.out.println("======目标方法doOther2======");
        Student student = new Student();
        student.setName("lisi");
        student.setAge(20);
        return student;
    }

    @Override
    public String doFirst(String name, Integer age) {
        System.out.println("=====业务方法doFirst（）=====");
        return "doFirst";
    }
}
