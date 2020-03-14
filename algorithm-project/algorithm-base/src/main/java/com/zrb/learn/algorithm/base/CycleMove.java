package com.zrb.learn.algorithm.base;

/**
 * 将一个大小为n的数组向左(右)循环移动k位
 * 要求：时间复杂度 O(n) 空间复杂度O(1)  临时变量2个
 */
public class CycleMove {
    public Integer[] cycleMove(Integer[] arr, Integer k) {
        if (null == arr || null == k || arr.length < 2) {
            return arr;
        }
        for (int i = 1; i <= k; i++) {
            Integer tmp = null;
            for (int j = arr.length - 1; j >= 0; j--) {
                //向左位移
                if (j == arr.length - 1) {
                    tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                } else {
                    arr[arr.length - 1] = arr[j - 1];
                    arr[j - 1] = tmp;
                    tmp = arr[arr.length - 1];
                }


                arr[j] = tmp;
            }
        }
        return arr;
    }
}
