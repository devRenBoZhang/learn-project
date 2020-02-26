package com.zrb.learn.java.jvm.invoke;

import java.util.function.Predicate;

public class LambdaInvoke {
    public static void main(String[] args) {

        Predicate<Integer> predicate = i -> i.intValue() < 0 ? false : true;
        boolean test = predicate.test(50);
        System.out.println(test);
    }
}
