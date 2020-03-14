package com.zrb.learn.java.base.test;

import java.math.BigDecimal;

public class AddTest {
    public class NunObj{
        private BigDecimal value;

        public NunObj(BigDecimal value) {
            this.value = value;
        }

        public void add(BigDecimal value) {
            this.value = this.value.add(value);
        }

        public BigDecimal getValue() {
            return this.value;
        }
    }

    public static void main(String[] args) {
        AddTest addTest = new AddTest();
        AddTest.NunObj nunObj = addTest.new NunObj(new BigDecimal(2.1));
//        NunObj nunObj = new NunObj(new BigDecimal(2.1));
        nunObj.add(new BigDecimal(1.6));
        System.out.println(":::::::"+nunObj.value.toString());
    }
}
