package com.zrb.learn.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandle implements InvocationHandler {
    private Object obj;


    public ProxyHandle(Object obj) {
        this.obj = obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行<aop切面>：执行前");
        Object invoke = method.invoke(obj, args);
        System.out.println("\n代理执行<aop切面>：执行后");
        return invoke;
    }
}
