package day8;

import java.util.stream.Stream;

/*
Stream流中常用方法_filter:用于对Stream流中的数据进行过滤
Stream<T>filter(Predicate<? Super ?>predicate);
filter的方法参数是一个函数式接口，所以可以传递lambda表达式，对数据进行过滤
Predicate中的抽象方法
boolean test(T t)
 */
public class Demo02Stream_filter {
    public static void main(String[] args) {
        // 创建一个Stream流
        Stream<String> stream = Stream.of("张三丰", "张翠山", "张无忌", "赵敏", "周芷若");
        // 对stream流中的数据进行过滤，只要姓张的人
        Stream<String> stream1 = stream.filter((String name) -> name.startsWith("张"));
        // 遍历stream1
        stream1.forEach(name-> System.out.println(name));
        /*
        stream流是管道流，只能消费(使用)一次
        第一个stream流调用完毕之后，数据会流转到下一个stream流
        而这时第一个stream流使用完毕，就关闭了
        所以第一个stream流就不能再调用方法了
         */

    }
}
