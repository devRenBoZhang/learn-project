package com.zrb.learn.java.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockMain {
    public static Integer num = 0;

    public void add() {
        num++;
    }

    public static ReentrantLock reentrantLock = new ReentrantLock(true);

    public void ReentrantlockAdd() throws InterruptedException {
//        boolean tryLock = reentrantLock.tryLock(20L,TimeUnit.SECONDS);
        try {
//            if (tryLock) {
            reentrantLock.lock();
                num = num + 1;

//            }
        }finally {
            reentrantLock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2000; i++) {
            new Thread(() -> {
//                new ReentrantLockMain().add();
                try {
                    new ReentrantLockMain().ReentrantlockAdd();
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(10L);
        System.out.println("unSafe add result. num:" + num);
    }
}
