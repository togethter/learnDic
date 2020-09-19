package com.bjpowernode;

import com.bjpowernode.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        // 从容器获取service
        BuyGoodsService service = (BuyGoodsService) ctx.getBean("buyService");
        // 调用方法
        service.buy(1001, 60);
    }
}
