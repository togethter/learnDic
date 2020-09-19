package day9;

public class Demo01PrintableTest {
    /*
    定义一个方法，参数传递Printable接口，对字符串进行打印
     */
    public static void printString(Demo01Printable p){
        p.print("helloWorld");
    }

    public static void main(String[] args) {
        // 调用printString方法，方法的参数是一个函数式接口，所以可以传递一个lambda表达式
        printString((str)->{
            System.out.println(str);
        });
        /*
        分析：
        lambda表达式的目的，打印参数传递的字符串，
        把参数s,传递给了SystemOut对象，对用了out对象中的方法print对字符串进行了输出
        注意：
        1、SystemOut对象是已经存在的
        2、println方法也是已经存在了的
        所以我们可以方法引用来优化Lambda表达式
        可以使用System.out方法直接引用(调用)println方法
         */
        printString(System.out::println);
        /*
        lambda表达式写法：s->System.out::println
        方法的引用写法：System.Out::println
         */
    }
}
