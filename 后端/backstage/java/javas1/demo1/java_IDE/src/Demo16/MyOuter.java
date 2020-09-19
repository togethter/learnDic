package Demo16;

/*
局部内部类，如果希望访问所在方法的局部变量，那么这个局部变量必须是有效final的
从Java 8开始，只要局部变量事实不变，那么final的关键字可以省略

原因：
1、new来的对象在堆内存当中
2、局部变量是跟着方法走的，在栈内存当中
3、方法运行结束之后，立即出栈，局部变量就会立即消失。
4、但是new出来的对象会在堆中持续存在，直到垃圾回收为止。
 */
public class MyOuter {
    public void methodOuter(){
        int num = 10; // 所在方法的局部变量
        class MyInner{
            public void methodInnder(){
                System.out.println(num);
            }
        }
    }
}
