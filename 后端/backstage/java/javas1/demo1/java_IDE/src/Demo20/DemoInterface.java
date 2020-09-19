package Demo20;

import java.util.ArrayList;
import java.util.List;

/*
java.until.list正是ArrayList实现的接口
 */
public interface DemoInterface {
    public static void main(String[] args) {
        // 左边是接口名称，右边是实现类接口，这就是多台写法

        List<String> list = new ArrayList<>();
        List<String> result = addNames(list);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static List<String> addNames(List<String> list) {
        list.add("q");
        list.add("w");
        list.add("e");
        return list;
    };
}
