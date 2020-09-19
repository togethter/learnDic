package cn.itcast.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Document/Element对象功能
 */
public class JsoupDemo3 {
    @Test
    public void test1() throws IOException {
        // 1获取文件路径
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        // 2获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 3获取元素对象
        // 3.1获取所有的student对象
        Elements elements = document.getElementsByTag("student");
        System.out.println(elements);
        System.out.println("-------------------------");

        //3.2 获取属性名为id的元素对象们
        Elements attribute = document.getElementsByAttribute("id");
        System.out.println(attribute);
        System.out.println("---------------------------");
        //3.3 获取number属性值为heima001对象
        Elements elements1 = document.getElementsByAttributeValue("number", "s001");
        System.out.println(elements1);
        System.out.println("---------------------------");
        //3.4 获取id属性值的元素对象
        Element itcast = document.getElementById("itcast");
        System.out.println(itcast);

    }



}
