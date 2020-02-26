package com.zrb.learn.java.proxy;

public class NormalImpl implements NormalInterface{

    @Override
    public String executeOne() {
        System.out.printf("实例执行executeOne");
        return "实例执行executeOne";
    }

    @Override
    public String executeTwo() {
        System.out.printf("实例执行executeTwo");
        return "sec实例执行";
    }
}
