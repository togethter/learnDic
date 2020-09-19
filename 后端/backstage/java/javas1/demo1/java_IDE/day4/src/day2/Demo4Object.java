package day2;

import java.util.Objects;

/*
Object类的静态方法
public static<T> requireNonNull(T obj),查看指定引用对象不是null
源码
public static<T> requireNonNull(T obj) {
if (obj) {
throw new NullPointerException();
}
return obj;
}
 */
public class Demo4Object {


    public static void main(String[] args) {
        method(null);
    }
    // 对传递过来的参数进行合法性判断，判断是否为空
    public static void method(Object obj) {
//        if (obj == null){
//            throw new NullPointerException("传递的对象的值是null");
//        }
//        Objects.requireNonNull(obj);
        Objects.requireNonNull(obj,"传递的对象的值是null");
    }
}
