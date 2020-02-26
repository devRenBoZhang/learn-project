package com.zrb.learn.java.proxy;

public class NormalJoinAopImpl implements NormalJoinAopInterface{

    @Override
    public String executeOne() {
        System.out.printf("NormalJoinAopImpl实例执行executeOne");
        return "NormalJoinAopImpl实例执行executeOne";
    }

    @Override
    public String executeTwo() {
        System.out.printf("NormalJoinAopImpl实例执行executeTwo");
        return "NormalJoinAopImpl实例执行executeTwo";
    }
}
