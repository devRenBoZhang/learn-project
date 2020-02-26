package com.zrb.learn.java.lambda;

public class lambdaMain {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("run");
        };
        new Thread(runnable).start();

    }

}
