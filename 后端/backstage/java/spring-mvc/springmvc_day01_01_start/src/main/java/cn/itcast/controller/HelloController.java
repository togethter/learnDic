package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 控制器类
@Controller
@RequestMapping(path = "/user")
public class HelloController {
    @RequestMapping(path="/hello")
    public String sayHello() {
        System.out.println("Hello StringMVC");
        return "success";
    }
    @RequestMapping(path = "/hello1")
    public String sayHello1(){
        System.out.println("Hello StringMVC");
        return "success1";
    }

    /**
     * RequestMapping注解
     * @return
     */
    @RequestMapping(path = "/testRequestMapping",
            method = {RequestMethod.GET},
            params = {"username=heihei"},
            headers = {"Accept"}
            )
    public String testRequestMapping(){
        System.out.println("测试RequestMapping注解...");
        return "success";
    }
}
