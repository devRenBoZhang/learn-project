package com.zrb.learn.java.exception.interrupt;

import java.util.concurrent.TimeUnit;

public class InterruptMain {
    public static void main(String[] args) throws InterruptedException {
        Thread.interrupted();
        Thread.sleep(20L);
        Thread t = new Thread(() -> {
            System.out.println("InterruptThread invoke start");
            try {
//                Thread.sleep(20 * 1000L);
                TimeUnit.SECONDS.sleep(50L);
            } catch (InterruptedException e) {
                System.out.println("InterruptThread was interrupt by others thread");
            }
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("InterruptThread isInterrupted check true");
            } else {
                System.out.println("InterruptThread isInterrupted check false");
            }
        },"InterruptThread");
        Thread t2 = new Thread(() -> {
            System.out.println("InterruptThread2 invoke start");
            for (int i = 0; i < 8; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("InterruptThread2 isInterrupted check true but continue invoke");
                } else {
                    System.out.println("InterruptThread2 isInterrupted check true false continue invoke");
                }
//                重置中断信号
                if (Thread.interrupted()) {
                    System.out.println("InterruptThread2 isInterrupted ClearInterrupted check true but continue invoke");
                } else {
                    System.out.println("InterruptThread2 isInterrupted ClearInterrupted check false but continue invoke");
                }
            }
            System.out.println("InterruptThread2 invoke finish");

        },"InterruptThread2");
        t.start();
        t2.start();
        t.interrupt();
        t2.interrupt();

        Thread.currentThread().interrupt();

        if (Thread.interrupted()) {
            System.out.println("interrupt self but invoke");
        } else {
            System.out.println("interrupt self check false");
        }

        TimeUnit.SECONDS.sleep(10L);
        System.out.println("system exit");
    }
}
