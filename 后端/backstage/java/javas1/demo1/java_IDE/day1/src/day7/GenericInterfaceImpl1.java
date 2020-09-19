package day7;
/*
    含有泛型的接口，第一种使用方式：定义接口的实现类，实现接口，指定接口的泛型

    public Interface Iterator<E>{
    E next();
    }

    Scanner类实现类Iterator接口,并指定接口的泛型为String，所以重写的next方法泛型默认就是String
    public final class Scanner implements Iterator<String> {

    }
 */
public class GenericInterfaceImpl1 implements GenericInterface<String>{

    @Override
    public void method(String s) {

    }
}
