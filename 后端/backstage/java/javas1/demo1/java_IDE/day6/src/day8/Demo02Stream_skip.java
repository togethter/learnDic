package day8;

import java.util.stream.Stream;

/*
Stream流中常用的方法_skip:用于跳过元素
如果希望跳过前几个元素，可以使用skip方法获取一个截取之后的新流
Stream<T> skip(long n)
如果流的当前元素大于n,则跳过前n个；否则将会得到一个长度为0的空流
 */
public class Demo02Stream_skip {
    public static void main(String[] args) {
        // 获取一个Stream流
        String[] arr = {"美羊羊","喜洋洋","懒洋洋","灰太狼","红太狼"};
        Stream<String> stream = Stream.of(arr);
        // 使用skip方法跳过前三个元素
        Stream<String> stream2 = stream.skip(3);
        stream2.forEach(str->System.out.println(str));

    }
}
