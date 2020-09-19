package cn.itcast.jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 选择器查询
 */
public class JsoupDemo6 {
    @Test
    public void test1() throws IOException, XpathSyntaxErrorException {
        // 1获取文件路径
        String path = JsoupDemo6.class.getClassLoader().getResource("student.xml").getPath();
        // 2获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 3根据document对象，创建JXDocument对象
        JXDocument jxDocument = new JXDocument(document);
        // 4结合xPath的语法查询
        // 4.1查询所有的student标签
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
        System.out.println("------------------------");
        // 4.2查询所有student标签下的name标签
        List<JXNode> jxNodes_name = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes_name) {
            System.out.println(jxNode);
        }
        System.out.println("------------------------");
        // 4.3查询student标签下带有id属性的name标签
        List<JXNode> jxNodes_id = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes_id) {
            System.out.println(jxNode);
        }
        System.out.println("------------------------");
        // 4.4查询student标签下带有id属性的name标签 并且id的属性值为itcast
        List<JXNode> jxNodes_1 = jxDocument.selN("//student/name[@id='itcast1']");
        for (JXNode jxNode : jxNodes_1) {
            System.out.println(jxNode);
        }
    }


}
