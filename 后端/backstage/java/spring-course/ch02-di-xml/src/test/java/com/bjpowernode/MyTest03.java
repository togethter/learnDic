package com.bjpowernode;

import com.bjpowernode.ba03.School;
import com.bjpowernode.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class MyTest03 {

    /**
     * spring默认创建对象的时间，在创建spring的容器时，会创建配置文件中的所有的对象。
     * spring创建对象：默认调用的是无参数的构造方法
     */
    @Test
    public void test01() {
        String config = "/ba03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        // 从容器中获取Student对象
        Student myStudent = (Student) ac.getBean( "myStudent3");
        System.out.println("student对象=" + myStudent);
        File myfile = (File) ac.getBean("myfile");
        System.out.println("myFile=="+myfile.getName());
    }

}
