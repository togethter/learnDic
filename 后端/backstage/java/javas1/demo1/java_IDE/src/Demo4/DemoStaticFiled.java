package Demo4;

public class DemoStaticFiled {
    public static void main(String[] args) {
        Student.room = "101教室";
        Student stu1 = new Student("zhangsan", 24);
        Student stu2 = new Student("李四", 33);
        System.out.println("姓名" + stu1.getName() + "年龄" + stu1.getAge() + "学号" + stu1.getId());
        System.out.println("姓名" + stu2.getName() + "年龄"+stu2.getAge() + "学号"+ stu2.getId());

    }
}
