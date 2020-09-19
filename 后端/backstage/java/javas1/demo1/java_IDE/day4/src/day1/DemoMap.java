package day1;

import java.util.HashMap;
import java.util.Map;

/*
java.util.Map<k,v>集合
Map集合的特点：
1、Map集合是一个双列集合，一个元素包含两个值（一个key，一个value）
2、Map集合中的元素，key和value的数据类型可以相同，也可以不同
3、Map集合中的元素，key是不允许重复的，value是可以重复的
4、Map集合中的元素，key和value是一一对应的

java.util.HashMap<k,v>集合 implements Map<k,v>接口
HashMap集合的特点：
1、HasMap的底层是哈希表，查询的速度特别快
JDK1.8之前，数组+单项链表
JDK1.8之后，数组+单项链表/红黑树(链表的长度超过8)：提高的查询速度
2、HasMap集合是一个无序的集合，存储元素和取出元素的顺序有可能不一致

java.util.LinkedHasMap<k,v>集合 extends HashMap<k,v>集合
linkedHasMap 的特点
1、linkedHasMap 的底层是哈希表+ 链表 保证迭代的顺序
2、linkedHasMap 是一个有序的集合 存储和取出元素的顺序一致

 */
public class DemoMap {
    public static void main(String[] args) {
        show04();
    }

    /*
     boolean containsKey(Object key) 判断集合中是否包含指定的键
     包含返回true,不包含返回false
     */
    private static void show04() {
        Map<String, Integer> map = new HashMap<>();
        map.put("周杰伦", 175);
        map.put("张杰", 180);
        map.put("哈林", 178);
        boolean hl1 = map.containsKey("哈林");
        boolean hl2 = map.containsKey("哈");
        System.out.println("hl1:" + hl1);
        System.out.println("hl2:" + hl2);

    }

    /*
    public V get(Object key) 根据指定的键，在Map集合中获取对应的值
    返回值
    key存在，返回对应的值value值
    key不存在，返回null

     */
    private static void show03() {
        Map<String, Integer> map = new HashMap<>();
        map.put("周杰伦", 175);
        map.put("张杰", 180);
        map.put("哈林", 178);
        Integer hl = map.get("哈林");
        System.out.println("hl:" + hl);
        Integer h2 = map.get("hahhah");
        System.out.println("h2:" + h2);


    }

    /*
    public V remove(Object key),把指定的键 所对应的键值对元素 在Map元素中删除，返回被删除元素的值。
    V：返回值
    key存在,  v返回被删除的值
    key不存在，v返回null
     */
    private static void show02() {
        Map<String, Integer> map = new HashMap<>();
        map.put("周杰伦", 175);
        map.put("张杰", 180);
        map.put("哈林", 178);
        System.out.println(map); // {哈林=178, 周杰伦=175, 张杰=180}
        Integer hl = map.remove("哈林");
//        int h2 = map.remove("哈林"); //自动拆箱  NullPointerException 尽量多使用包装类
        System.out.println("被删除的元素:" + hl); // 被删除的元素:178
        System.out.println("删除哈林后的map为:" + map);
    }

    /*
    public V put(K key,V value):把指定的键和指定的值添加到Map中
    返回v值
    存储键值对的时候，key不重复，返回v是null
    存储键值对的时候，key重复，会使用新的value替换Map中重复的value值，返回被替换的value值


     */
    private static void show01() {
        // 创建Map集合对象，多态
        Map<String, String> map = new HashMap<>();
        String v1 = map.put("李晨", "范冰冰1");
        System.out.println("v1:" + v1); // v1:null
        String v2 = map.put("李晨", "范冰冰2");
        System.out.println("v2:" + v2); // v2:范冰冰1
        System.out.println(map); // {李晨=范冰冰2}

    }
}
