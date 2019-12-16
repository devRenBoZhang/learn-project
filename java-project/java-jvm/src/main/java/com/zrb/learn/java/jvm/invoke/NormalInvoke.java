package com.zrb.learn.java.jvm.invoke;

public class NormalInvoke {
    public class Human {
        public String printHumanInfo() {
            return "human";
        }
        public String printHumanInfo(Integer num) {
            return "human Integer is "+num;
        }
        public String printHumanInfo(int num) {
            return "human num is "+ num;
        }
        public String printHumanInfo(int num,String str) {
            return "human num is "+ num + ". str is " + str;
        }
        public String printHumanInfo(int num, Object... objs) {
            return "human num is "+ num + ". objs siz is " + objs.length;
        }
        public String printHumanInfo(int num,String str, Object... objs) {
            return "human num is "+ num + ". str is " + str + ". objs siz is " + objs.length;
        }
    }

    public class Man extends Human {
        @Override
        public String printHumanInfo() {
            return "mam";
        }
    }

    public class Woman extends Human {
        @Override
        public String printHumanInfo() {
            return "woman";
        }
    }



    public void invokeOverride() {
        Human human = getHumanByStr("man");
        System.out.println(human.printHumanInfo());
        System.out.println(human.printHumanInfo());
    }

    private Human getHumanByStr(String w) {
        if ("man".equals(w)) {
            return new Man();
        } else {
            return new Woman();
        }
    }

    public static void main(String[] args) {
        new NormalInvoke().invokeOverride();
    }

}
