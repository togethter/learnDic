package day1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
Map集合第二种的遍历方式：使用Entry对象遍历
Map集合中的方法
set<map.Entry<K,V>>entrySet()返回次映射中包含的映射关系的Set视图
1、使用map集合中的方法 entrySet(),把map集合中多个Entry对象取出来，存储到一个Set集合中
2、遍历集合Set，取出每一个Entry对象
3、使用Entry对象的方法getKey(),getValue()获取键与值


 */
public class DemoEntrySet {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("周杰伦", 175);
        map.put("张杰", 180);
        map.put("哈林", 178);
//        1、使用map集合中的方法 entrySet(),把map集合中多个Entry对象取出来，存储到一个Set集合中

        Set<Map.Entry<String, Integer>> set = map.entrySet();
//        2、遍历集合Set，取出每一个Entry对象

        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
//            3、使用Entry对象的方法getKey(),getValue()获取键与值
            String key = next.getKey();
            Integer value = next.getValue();

            System.out.println(key + value);
        }
        System.out.println("==================");
        for (Map.Entry<String, Integer> entry:
                set) {
            System.out.println(entry.getKey() + entry.getValue());
        }

    }

}
