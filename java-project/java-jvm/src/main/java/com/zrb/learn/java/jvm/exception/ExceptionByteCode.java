package com.zrb.learn.java.jvm.exception;

public class ExceptionByteCode {
    private static String test = "";
    public void exceptionCatch(String args) {
        try {
            if (args.length() > 3) {
                args = "d";
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            args = "a";
        }
        test = args;
//        System.out.println(args);
//        synchronized (ExceptionByteCode.class) {
//            args = "c";
//
//        }
    }

    public void invokeExceptionM(String args) throws Exception {
//        try {
            if (args.length() < 5) {
                args = "abc";
            } else {
                throw new Exception(new NullPointerException("dddddddd"));
            }
            exceptionCatch(args);
//        } catch (Exception e) {
//            args = "eee";
////            throw e;
//        }
        System.out.println(args);
    }

    public static void main(String[] args) throws Exception {
        ExceptionByteCode exceptionByteCode = new ExceptionByteCode();
        exceptionByteCode.invokeExceptionM("zrbzrbzrbzrderereer");
    }
}
