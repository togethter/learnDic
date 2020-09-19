package day1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HasMapSavePerson {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("张三","18");
        map.put("lisi","21");
        map.put("lisi","22");

        Set<Map.Entry<String,String>> set = map.entrySet();
        for (Map.Entry<String, String> entry:set
         ){
            System.out.println(entry.getKey() + entry.getValue());
        }

        Map<Person,String> map1 = new HashMap<>();
        map1.put(new Person("张三",14),"22");
        map1.put(new Person("xiaoer",33),"33");
        map1.put(new Person("xiaoer",33),"33");
        Set<Map.Entry<Person, String>> set2 = map1.entrySet();
        for (Map.Entry<Person, String> entry :
                set2) {
            System.out.println(entry.getKey() + entry.getValue());

        }
    }
}
