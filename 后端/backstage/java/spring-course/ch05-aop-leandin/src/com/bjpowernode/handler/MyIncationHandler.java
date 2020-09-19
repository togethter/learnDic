package com.bjpowernode.handler;

import com.bjpowernode.util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyIncationHandler implements InvocationHandler {
    private Object target; // SomeServiceImpl类

    public void setTarget(Object target) {
        this.target = target;
    }

    public MyIncationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 通过代理对象执行方法时，会调用执行这个invoke()
        System.out.println("执行MyIncationHandler中的invoke()");
        Object res = null;
        String methodName = method.getName();
        if ("doSome".equals(methodName)){// JoinPoint Pointcut
            ServiceTools.doLog();
            // 执行目标类的方法，通过Method类实现
            res = method.invoke(target, args); // SomeServiceImpl,doSome()
            // 目标方法的执行结果
            ServiceTools.doTrans();
        } else {
            res = method.invoke(target,args);// SomeServiceImpl.doOther()
        }
        return res;
    }
}
