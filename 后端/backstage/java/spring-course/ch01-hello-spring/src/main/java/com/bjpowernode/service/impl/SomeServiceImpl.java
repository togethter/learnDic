package com.bjpowernode.service.impl;

import com.bjpowernode.service.SomeService;

public class SomeServiceImpl implements SomeService {
    public SomeServiceImpl(){
        System.out.println("SomeServiceImpl的无参数构造方法");
    }
    @Override
    public void dosome() {
        System.out.println("执行了someServiceImpl的doSome()方法");
    }
}
