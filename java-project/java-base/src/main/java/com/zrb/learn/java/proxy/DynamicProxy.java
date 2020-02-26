package com.zrb.learn.java.proxy;

import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static void main(String[] args) {
        NormalInterface needProxy = new NormalImpl();
        NormalJoinAopImpl normalJoinAop = new NormalJoinAopImpl();
        ProxyHandle handle = new ProxyHandle(needProxy);

        NormalInterface normalInterface = (NormalInterface)Proxy.newProxyInstance(handle.getClass().getClassLoader(), needProxy.getClass().getInterfaces(), handle);
        normalInterface.executeOne();
        normalInterface.executeTwo();

        handle.setObj(normalJoinAop);
        normalInterface.executeOne();
        normalInterface.executeTwo();


    }
}
