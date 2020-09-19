package cn.itcast.jsoup;

import jdk.jfr.StackTrace;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class JsoupDemo1 {
    @Test
    public void test1() throws IOException {
        //2 获取Document对象，根据xml获取
        //2.1 获取student.xml的path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取dom树，--->Document
        Document document = Jsoup.parse(new File(path),"utf-8");
        //3 获取元素对象 Element
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        //4 获取第一个name的Element对象
        Element element = elements.get(0);
        //4.1 获取数据
        String text = element.text();
        System.out.println(text);


    }
}
