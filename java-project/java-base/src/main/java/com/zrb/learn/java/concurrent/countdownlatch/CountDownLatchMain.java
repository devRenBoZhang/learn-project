package com.zrb.learn.java.concurrent.countdownlatch;

import com.zrb.learn.java.concurrent.NamedThreadFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchMain {
    public static void main(String[] args) throws InterruptedException {
        Integer invokeNum = 10;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch endSignal = new CountDownLatch(10);

        NamedThreadFactory threadFactory = new NamedThreadFactory("zrb-learn-count-down");
        for (int i = 0; i < invokeNum; i++) {
            threadFactory.newThread(() -> {
                try {
                    //等主线程下发统一指令
                    startSignal.await();
                } catch (InterruptedException e) {
                    System.out.println("thread Interrupted");
                }
                System.out.println("thread invoke start. name:" + Thread.currentThread().getName());
                if ("zrb-learn-count-down-thread-8".equals(Thread.currentThread().getName())) {
                    try {
                        TimeUnit.SECONDS.sleep(15);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                endSignal.countDown();
                System.out.println("thread invoke finish and countDown. name:" + Thread.currentThread().getName() + ", num:" +endSignal.getCount());
            }).start();
        }
        System.out.println("main invoke start but sleep while");
        //子线程都开始执行
        TimeUnit.SECONDS.sleep(10);
        startSignal.countDown();

        TimeUnit.SECONDS.sleep(10);
        //等待所有子线程处理完
        endSignal.await();
        System.out.println("main invoke finish");


    }
}
