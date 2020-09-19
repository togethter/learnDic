package Demo2;

import java.util.ArrayList;

// 对于ArrayList来说，有一个尖括号<E>代表泛型
// 泛型也就是装在集合里的所有的元素，全都统一的什么类型
public class DemoArrayList {
    public static void main(String[] args) {

        // 创建一个ArrayList集合，集合的名称是list，里面装的全都是String字符串类型的数据
        // 备注：JDK 1.7+ 右侧的尖括号可以不写内容但是<>本身还是要写的
        ArrayList<String> list = new ArrayList<>();
        list.add("赵丽颖");
        list.add("迪丽热巴");
        list.add("杨幂");
        list.add("李沁");
        list.add("关晓彤");
        list.add("袁姗姗");
        System.out.println(list);
        String moveStr = list.remove(0);
        System.out.println("删除的元素：" + moveStr);
        int length = list.size();
        System.out.println("size的长度:" + length);
        System.out.println("删除后新数组:" + list);
        String getStr = list.get(2);
        System.out.println("获取下表为2的Str：" + getStr);











        /* 常用的方法

        1、boolean add(E e),向集合中添加元素，参数的类型和泛型一致，返回值代表添加是否成功
        2、E get(int Index),从集合中获取元素,参数是索引编号，返回值就是对应位置的元素
        3、E remove(int Index),从集合中删除元素，参数是索引值,返回值就是对应位置的元素
        4、int size():获取集合的尺寸长度，返回值是集合中包含元素的个数

        */


    }
}
