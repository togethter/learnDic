package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("容器中对象的名称:" + name+ "!"+ctx.getBean(name));
        }
    }
    @Test
    public void testDaoInsert() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        // 获取spring容器中的dao对象
        StudentDao dao = (StudentDao) ctx.getBean("studentDao");
        Student student = new Student();
        student.setId(1013);
        student.setName("周峰");
        student.setEmail("zhoufeng@qq.com");
        student.setAge(20);
        int nums = dao.insertStudent(student);
        System.out.println("nums"+nums);
    }

    @Test
    public void testServiceInsert() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        // 获取spring容器中的dao对象
        StudentService service = (StudentService) ctx.getBean("studentService");
        StudentDao dao = (StudentDao) ctx.getBean("studentDao");
        Student student = new Student();
        student.setId(1014);
        student.setName("周峰7");
        student.setEmail("zhoufeng@qq.com");
        student.setAge(27);
        int nums = service.addStudent(student);
        // spring和mybatis整合在一起使用，事务是自动提交的，无需执行SqlSession.commit();
        System.out.println("nums"+nums);
    }

    @Test
    public void testServiceSelect() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        // 获取spring容器中的dao对象
        StudentService service = (StudentService) ctx.getBean("studentService");
        List<Student> students = service.queryStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

}
