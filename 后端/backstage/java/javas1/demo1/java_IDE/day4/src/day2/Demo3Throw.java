package day2;

/*
    throw关键字
    可以使用throw关键字，在指定的方法中抛出指定的异常
    使用格式：
    throw new xxxException("异常产生的原因")
    注意：
    1、throw关键字必须写在方法的内部
    2、throw关键字后边new的对象必须是Exception或者Exception的子类对象
    3、throw关键字抛出的异常对象，我们必须处理这个异常对象
        throw关键字后边创建的是RunTimeException或者RunTimeException的子类
        我们可以不处理，默认交给JVM处理(打断异常对象，中断程序)
        throw关键字后边创建的是编译异常(写代码的时候报错)，我们就必须处理这个异常，要么throws,要么try...catch

 */
public class Demo3Throw {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int e =  getElement(arr, 2);
        System.out.println(e);
    }

    /*
  定义一个方法，获取数组指定索引出的元素
  参数：
  int[] arr
  int index
  首先对参数校验，如果参数不合法，那么我们就必须使用抛出异常的方式，
  告知方法的调用者，传递的参数有问题
  注意：
  NullPointerException，是一个运行期异常，默认不处理，交给JVM处理
   */
    public static int getElement(int[] arr, int index) {
        /*
        对传递过来的参数数组进行合法性校验
        如果数组arr值null,抛出异常的方式,告知调用者("传递的数组是是null")
        */
        if (arr == null) {
            throw new NullPointerException("传递的数组是是null");
        }
        /*
        对传递过来的参数，index进行合法性校验，如果index不在数组的合法的范围内，那么
        就抛出数组索引越界，告知方法的调用者传递索引超出数组的使用范围
         */
        if (index < 0 || index > arr.length - 1) {
            throw new ArrayIndexOutOfBoundsException("索引超出数组的范围");
        }
        int ele = arr[index];
        return ele;
    }
}
