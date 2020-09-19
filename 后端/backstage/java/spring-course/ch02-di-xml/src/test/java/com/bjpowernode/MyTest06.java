package com.bjpowernode;

import com.bjpowernode.ba06.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest06 {

    /**
     * spring默认创建对象的时间，在创建spring的容器时，会创建配置文件中的所有的对象。
     * spring创建对象：默认调用的是无参数的构造方法
     */
    @Test
    public void test01() {
        // 加载的是总的文件
        String config = "/ba06/total.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        // 从容器中获取Student对象
        Student myStudent = (Student) ac.getBean( "myStudent");
        System.out.println("student对象=" + myStudent);

    }

}
