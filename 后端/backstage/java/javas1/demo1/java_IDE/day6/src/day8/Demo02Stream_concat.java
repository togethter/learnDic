package day8;

import java.util.stream.Stream;

public class Demo02Stream_concat {
    public static void main(String[] args) {
        // 创建一个stream流
        Stream<String> stream = Stream.of("张三丰", "张翠山", "张无忌", "赵敏", "周芷若");
        // 获取一个Stream流
        String[] arr = {"美羊羊","喜洋洋","懒洋洋","灰太狼","红太狼"};
        Stream<String> stream1 = Stream.of(arr);
        // 把以上两个流组合为一个流
        Stream<String> stream3 = Stream.concat(stream, stream1);
        stream3.forEach(str-> System.out.println(str));
    }
}
