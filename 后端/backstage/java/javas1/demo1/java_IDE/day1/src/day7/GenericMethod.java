package day7;
/*
定义含有泛型的方法：泛型定义在方法的修饰符和返回值类型之间
格式：
修饰符<泛型> 返回值类型 方法名(参数列表(使用泛型)){
方法体;
}

含有泛型的方法，在调用方法的时候，确定泛型的类型
传递什么类型的参数，泛型就是什么类型
 */
public class GenericMethod {
    // 定义一个含有泛型的方法
    public <M> void method01(M m){
        System.out.println(m);
    }
    public static <S> void method02(S s){
        System.out.println(s);
    }

}
