package cn.itcast.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 选择器查询
 */
public class JsoupDemo5 {
    @Test
    public void test1() throws IOException {
        // 1获取文件路径
        String path = JsoupDemo5.class.getClassLoader().getResource("student.xml").getPath();
        // 2获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 3查询name标签
        Elements elements = document.select("name");
        System.out.println(elements);
        System.out.println("--------+++-------++++++---------+++---------");
        // 4查询id值为itcast的元素
        Elements elements1 = document.select("#itcast");
        System.out.println(elements1);
        // 5获取studen标签并且number属性值为heima_0001的age子标签
        // 5.1获取studen标签并且number属性值为heima_0001
        System.out.println("---哈哈哈哈啊啊哈哈哈哈哈哈------------------");
        Elements elements2 = document.select("student[number='heima_0001']");
        System.out.println(elements2);
        System.out.println("----------------------------------");
        // 5.2获取studen标签并且number属性值为heima_0001的age子标签
        Elements elements3 = document.select("student[number='heima_0001'] > age");
        System.out.println(elements3);
        System.out.println("----------------------------------");
    }


}
