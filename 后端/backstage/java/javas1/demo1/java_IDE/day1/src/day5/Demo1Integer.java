package day5;
/*
 包装，把基本类型的数据，包装到包装类中(基本类型的数据->包装类)
 构造方法
 Integer(int value) 构造一个新分配的Integer对象，他表示一个指定的Int值
 Integer(String s) 构造一个新分配的Integer对象，他表示string参数所指定的int值
 传递的参数，必须是基本类型的字符串，否则会抛出异常。100 正确 a 抛出异常


 静态方法
 static Integer valueof(int i) 返回一个指定的Int的Integer对象
 static Integer valueof(String s) 返回保存指定的String的值得Integer对象


 拆箱
 在包装类中取出基本数据类型的数据 (包装类->基本数据类型)
 成员方法
 int intValue() 以Int类型返回该Integer的值
 */
public class Demo1Integer {
    public static void main(String[] args) {
        // 包装，把基本类型的数据，包装到包装类中(基本类型的数据->包装类)
        // 构造方法
        Integer in1 = new Integer(1);
        System.out.println(in1); // 重写了toString的方法 // 1
        Integer in2 = new Integer("1");
        System.out.println(in2); // 1

        // 静态方法
        Integer in3 = Integer.valueOf(1);
        System.out.println(in3);
        Integer in4 = Integer.valueOf("1");
        System.out.println(in4);



        // 拆箱
        // 在包装类中取出基本数据类型的数据 (包装类->基本数据类型)
        int i = in1.intValue();
        System.out.println(i);



    }
}
