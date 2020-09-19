package com.bjpowernode.ba02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
// 省略value
@Component("myStudent")
public class Student {
    /**
     * @Value：简单类型的属性赋值：
     *    属性：value 是string类型的，表示简单类型的属性值
     *    位置：1、在属性定义的上面，无需set方法，推荐使用。
     *         2、在set方法的上面
     */
//    @Value("张飞")
      @Value("${myname}")
    private String  name;
//    @Value("20")
    @Value("${myage}")
    private Integer age;

    public Student() {
        System.out.println("===student无参数构造方法===");
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
