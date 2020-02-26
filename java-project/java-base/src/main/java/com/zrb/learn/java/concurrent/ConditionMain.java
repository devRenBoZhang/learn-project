package com.zrb.learn.java.concurrent;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionMain {
    private static Integer num = 0;

    private static ExecutorService executor = Executors.newCachedThreadPool(new NamedThreadFactory("zrb-learn"));
    public static ReentrantLock reentrantLock = new ReentrantLock(true);
    public static Condition numLarge140 = reentrantLock.newCondition();

    public Integer numAdd() {
        System.out.println(Thread.currentThread().getName() + " invoke");
        return num++;
    }

    public static boolean numLarge() {
        return num > 7;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Integer> submit = null;
        for (int i = 0; i < 200; i++) {
            submit = executor.submit(() -> new ConditionMain().numAdd());
        }
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                reentrantLock.lock();
                try {
                    new ConditionMain().numAdd();
                    while (!ConditionMain.numLarge()) {
                        try {
                            System.out.println("await some times. "+Thread.currentThread().getName());
                            numLarge140.await(1, TimeUnit.SECONDS);
                            if (ConditionMain.numLarge()) {
                                System.out.println("await thread condition allow. "+Thread.currentThread().getName());
                                break;
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("invoke finish. threadName:" + Thread.currentThread().getName());
                }finally {
                    reentrantLock.unlock();
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(50);


//        Integer result = submit.get();
//        System.out.println("invoke Result is get success: " + result);


//        ReentrantLock reentrantLock = new ReentrantLock(true);
//        Condition condition = reentrantLock.newCondition();
//        reentrantLock.tryLock();
    }
}
