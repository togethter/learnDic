package day9;

/*
通过对象名引用成员方法
使用前提是对象名是已经存在的，成员方法也是已经存在的
就可以使用对象名来引用成员方法
 */
public class Demo01ObjectMethodReference {
    // 定义一个方法,方法的参数传递Demo01Printable接口
    public static void printString(Demo01Printable p) {
        p.print("hello");
    }
    public static void main(String[] args) {
        // 调用一个方法，方法的参数是一个printable是一个函数式接口，所以可以传递lambda表达式
        printString((s) -> {
            // 创建methodReferenceObj对象
            MethodReferenceObj obj = new MethodReferenceObj();
            // 调用methodReferenceObj的对象的成员方法，printUpperCaseString,把字符串按照大写输出
            obj.printUpperCaseString(s);
        });
        /*
        使用方法引用优化lambda
        对象是已经存在的MethodReferenceObj
        成员方法也是已经存在的printUpperCaseString
        所以我们可以使用对象名引用成员方法
         */
        // 创建methodReferenceObj对象
        MethodReferenceObj obj = new MethodReferenceObj();
        printString(obj::printUpperCaseString);
    }
}
