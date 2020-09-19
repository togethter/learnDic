package day11;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/*
java.util.Properties集合 extends Hashtable<k,v> implements Map<k,v>
Properties 表示了一个持久的属性集 Properties可以保存在流中或从流中加载。
Properties 是集合中唯一和IO流相结合的集合
可以使用 Properties 集合中的方法store 把集合中临时数据持久化存储到硬盘中存储
可以使用 Properties 集合中的方法load 把硬盘中的文件(键值对)读取到集合中使用
属性列表中每一个键及对应的值都是一个字符串。
Properties集合是一个双列集合key和value默认都是字符串
 */
public class Demo01Properties {
    public static void main(String[] args) throws IOException {
        show03();
    }

    /*
    可以使用 Properties 集合中的方法load 把硬盘中的文件(键值对)读取到集合中使用

    void load(outputStream inStream)
    void load(Reader reader)
    参数：
    outputStream inStream 字节输入流，不能读取含有中文的键值对
    Reader reader 字符输入流，可以读取含有中文的键值对
    使用步骤
    1、创建Properties对象
    2、使用Properties对象中的方法load读取键值对的文件
    3、遍历Properties集合
    注意事项：
    1、存储键值对的文件中，键与值默认的连接符号可以使用=,空格(其他的符号)
    2、存储键值对的文件中，可以使用#进行注释，被注释的键值对不会被读取
    3、存储键值对的文件中，默认都是字符串，不用加""

     */
    private static void show03() throws IOException {
//        1、创建Properties对象
        Properties properties = new Properties();
//        2、使用Properties对象中的方法load读取键值对的文件
//        properties.load(new FileReader("prop.txt"));
        properties.load(new FileInputStream("prop.txt"));
//        3、遍历Properties集合
        Set<String> set = properties.stringPropertyNames();
        for (String key : set) {
            String value = properties.getProperty(key);
            System.out.println(key + "="+ value);
        }

    }

    /*
    可以使用 Properties 集合中的方法store 把集合中临时数据持久化存储到硬盘中存储
    void store(OupputStream out,String comments)
    void store(Write write,String comments)
    OupputStream out 字节输出流，不能写入中文
    Write write 字符输出流 可以写中文
    String comments 可以解释说明我们保存文件是做什么用的
    不能使用中文，会产生乱码，默认使用的时Unicode编码
    一般使用"" 空字符串
    使用步骤
    1、创建Properties集合对象，添加数据
    2、创建字节输出流/字符输出流对象，构造方法中绑定要输出的目的地
    3、使用Properties集合方法store，把集合中临时数据持久化存储到硬盘中存储
    4、释放资源
     */
    private static void show02() throws IOException {
        // 1、创建Properties集合对象，添加数据
        Properties properties = new Properties();
        // 使用setProperty望集合中添加数据
        properties.setProperty("赵丽颖", "168");
        properties.setProperty("江疏影", "169");
        properties.setProperty("关晓彤", "175");
//        2、创建字节输出流/字符输出流对象，构造方法中绑定要输出的目的地
//        FileWriter fileWriter = new FileWriter("prop.txt");
////        3、使用Properties集合方法store，把集合中临时数据持久化存储到硬盘中存储
//        properties.store(fileWriter,"save data");
////        4、释放资源
//        fileWriter.close();
        properties.store(new FileOutputStream("prop2.txt"), "save data");

    }

    /*
    使用 Properties 集合存储数据，遍历取出Properties集合中的数据
    属性列表中每一个键及对应的值都是一个字符串。
    Properties集合有一些操作字符串的特有方法
    Object setProperty(String key,String value) 调用Hastable方法put
    String getProperty(String key) 通过key找到value，此方法相当于Map集合中的get(key)方法
    Set<String> stringPropertyNames() 返回此属性列表中的键集，其中该键及其对应值是字符串，此方法相当于Map集合中keySet方法


     */
    private static void show01() {
        // 创建Properties集合对象
        Properties properties = new Properties();
        // 使用setProperty望集合中添加数据
        properties.setProperty("赵丽颖", "168");
        properties.setProperty("江疏影", "169");
        properties.setProperty("关晓彤", "175");
        // 使用stringPropertyNames把Properties集合中的键取出来，存储到一个set集合中
        Set<String> set = properties.stringPropertyNames();
        // 遍历set集合，取出Properties的每一个键
        for (String key : set) {
            // 使用 getProperty 方法通过key获取value
            String value = properties.getProperty(key);
            System.out.println(key + ":" + value);
        }


    }
}
