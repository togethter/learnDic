package Demo2;

import java.util.ArrayList;
/**
基本类型 		包装类(java.lang下)
        byte			Byte
        short			Short
        int 			Integer
        long			Long
        float 			Float
        double 		Dobule
        char			Character
        boolean 		Boolean
 从JDK 1.5+,支持自动装箱，自动拆箱
 自动装箱：基本类型->包装类型
 自动拆箱：包装类型->基本类型
*/
public class DemoArrayListBasic {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(100);
        System.out.println(list1);
        Integer num1 = list1.get(1);
        System.out.println(num1);
    }
}
