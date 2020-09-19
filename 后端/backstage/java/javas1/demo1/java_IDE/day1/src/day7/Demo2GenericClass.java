package day7;

public class Demo2GenericClass {
    public static void main(String[] args) {
        // 不写泛型默认为Object类型
        GenericClass gc = new GenericClass();
        gc.setName("张三");
        Object name = gc.getName();
        // 创建GenericClass对象，泛型使用Integer类型
        GenericClass<Integer> gc1 = new GenericClass<>();
        gc1.setName(12);
        Integer name1 = gc1.getName();
        System.out.println(name1);
        // 创建GenericClass对象，泛型使用字符串类型
        GenericClass<String> gc2 = new GenericClass<>();
        gc2.setName("关晓彤");
        String name2 = gc2.getName();
        System.out.println(name2);

    }
}
