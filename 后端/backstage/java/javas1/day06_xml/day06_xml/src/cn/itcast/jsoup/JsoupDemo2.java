package cn.itcast.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * jsoup对象的功能
 */
public class JsoupDemo2 {
    @Test
    public void test1() throws IOException {
        //2 获取Document对象，根据xml获取
        //2.1 获取student.xml的path
        String path = JsoupDemo2.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取dom树，--->Document
        /*Document document = Jsoup.parse(new File(path), "utf-8");
        System.out.println(document);*/
        // 2 parse(String html):解析xml或html字符串的
        String str = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<students>\n" +
                "    <student number=\"s001\">\n" +
                "        <name>zhangsan</name>\n" +
                "        <age>20</age>\n" +
                "        <sex>male</sex>\n" +
                "    </student>\n" +
                "    <student number=\"s002\">\n" +
                "        <name>李四</name>\n" +
                "        <age>22</age>\n" +
                "        <sex>female</sex>\n" +
                "    </student>\n" +
                "</students>";
        Document document = Jsoup.parse(str);
        System.out.println(document);
    }


    @Test
    public void test2() throws IOException {
        //3 parse(URL url, int timeoutMillis) 通过网络路径获取指定的html或xml文档对象
        URL url = new URL("https://baike.baidu.com/item/jsoup/9012509?fr=aladdin");// 代表网络的一个资源路径
        Document document1 = Jsoup.parse(url, 1000);
        System.out.println(document1);
    }
}
