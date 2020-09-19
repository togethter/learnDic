package day1;
/*
哈希值是一个十进制的整数，由系统随机给出(就是一个对象的地址值，是一个逻辑地址值
，是模拟出来的地址值，不是数据实际存储的物理地址)
在Object类有一个方法获取对象的哈希值

hashCode的源码
public native int hashCode();
native：代表的时本地操作系统的方法
 */
public class DemoHashCode {
    public static void main(String[] args) {
        // Person类继承了 Object类，所以所以可以使用HasCode的方法。
        Person per = new Person();
        System.out.println(per.hashCode());
        Person per2 = new Person();
        System.out.println(per2.hashCode());
        /*
        public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
         */
        System.out.println(per); // day1.Person@5a39699c
        System.out.println(per2);// day1.Person@3cb5cdba
        System.out.println(per == per2);


        // 字符串的HasCode

        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1.hashCode()); // 96354
        System.out.println(s2.hashCode()); // 96354

        System.out.println("重地".hashCode()); // 1179395
        System.out.println("通话".hashCode()); // 1179395
    }
}
