package day8;

import day2.Person;

import java.util.ArrayList;

public class Demo03StreamTest {
    public static void main(String[] args) {
        // 第一支队五
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");
        // 1、第一个队伍只要名字为3个字的成员姓名；存储到一个新的集合中
        ArrayList<String> one1 = new ArrayList<>();
        for (String name : one) {
            if (name.length() == 3){
                one1.add(name);
            }
        }
        // 2、第一个队伍筛选之后只要前3个人；存储到一个新集合中
        ArrayList<String> one2 = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            one2.add(one1.get(i)); // i = 0,1,2
        }
        // 第二支队五
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");
        // 3、第二支队只要姓张的成员姓名；存储到一个新集合中
        ArrayList<String> two1 = new ArrayList<>();
        for (String s : two) {
            if (s.startsWith("张")){
                two1.add(s);
            }
        }
        // 4、第二个队伍筛选之后不要前2个人；存储到一个新集合中
        ArrayList<String> two2 = new ArrayList<>();
        for (int i = 0; i < two1.size(); i++) {
            two2.add(two1.get(i)); // i 不包含0 1
        }
        // 5、将两个队伍合并成一个队伍，存储到一个集合中
        ArrayList<String> all = new ArrayList<>();
        all.addAll(one2);
        all.addAll(two2);
        // 6、根据姓名创建Person对象，存储到一个新集合中
        ArrayList<Demo03Person> list = new ArrayList<>();
        for (String name : all) {
            list.add(new Demo03Person(name));
        }
        // 7、打印整个队伍的Person对象信息
        for (Demo03Person demo03Person : list) {
            System.out.println(demo03Person);
        }





    }
}
