package day1;

import java.util.HashSet;

/*
Set 集合不允许重复的元素的原理
 */
public class DemoHasSetSavingString {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("abc");
        set.add("abc");
        set.add("重地");
        set.add("通话");
        set.add("bvc");
        System.out.println(set);
    }
}
