package day7;

/*
日志案例
发现以下代码存一些性能浪费的问题
调用showLog方法传递的第二个参数是一个拼接后的字符串
先把字符串拼接号，然后在调用showLog方法，
showLog方法如果传递的日志等级不是1
拼接的字符串白拼接了，不会输出，存在浪费
 */
public class Demo01Logger {
    // 定义根据日志级别，显示日志信息的方法

    public static void showLog(int level, String message) {
        // 根据日志的等级进行判断，如果是1级别，那么输出日志信息
        if (level == 1) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        // 调用showLog，传递日志级别和日志信息
        String msg1 = "Hello";
        String msg2 = "World";
        String msg3 = "Java";
        showLog(1, msg1 + msg2 + msg3);
    }
}
