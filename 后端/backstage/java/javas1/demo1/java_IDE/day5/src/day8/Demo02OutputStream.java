package day8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
public void write(byte[] b):将b.length字节从指定的字节数组写入此输出流
public void write(byte[] b，int off,int len):从指定的字节数组写入 len字节，从偏移量off开始输出到此输出流
 */
public class Demo02OutputStream {
    public static void main(String[] args) throws IOException {
        //1、 创建FileOutputSteam对象，构造方法中绑定要写入数据的目的地
        FileOutputStream fops =
                new FileOutputStream(new File("/Users/gd/Desktop/NH/github/learnDic/后端/java/java_IDE/2.txt"));
        //2、调用FileOutputSteam对象方法write，把数据写入到文件中
        // 在文件中显示100,写几个字节
//        fops.write(49);
//        fops.write(48);
//        fops.write(48);
        /*
        public void write(byte[] b):将b.length字节从指定的字节数组写入此输出流
        1次写多个字节
        如果写的第一个字节是正数(0-127)，那么显示的时候会查询ASCII表
        如果第一个字节是负数，那第一个字节会和第二个字节，两个字节组成一个中文显示，查询系统默认码表(GBK)
         */
        byte[] bytes = {65, 66, 67, 68, 69};
//        byte[] bytes = {-65,-66,-67,68,69};
        fops.write(bytes);
/*
        public void write(byte[] b，int off,int len):
        从指定的字节数组写入 len字节，从偏移量off开始输出到此输出流
        int off:数组的开始索引
        int len:写几个字节
 */

        fops.write(bytes, 1,2); // BC
/*
      写入字符的方法：可以使用String类中方法把字符串，转换为字节数组
           byte[] getBytes()把字符串转换为字节数组
 */
        byte[] bytes1 = "你好".getBytes();
        System.out.println(Arrays.toString(bytes1)); // [-28, -67, -96, -27, -91, -67]
        fops.write(bytes1);

        //3、释放资源
        fops.close();
    }

}
