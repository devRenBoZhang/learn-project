package com.zrb.learn.java.jvm.jol;

import org.openjdk.jol.info.ClassLayout;

public class JolMain {
    public static void main(String[] args) {
        String s = ClassLayout.parseInstance(20L).toPrintable();
        System.out.println(s);

        s = ClassLayout.parseInstance(new Long(5)).toPrintable();
        System.out.println(s);

        JavaBaseType baseType = getJavaBaseType();
        s = ClassLayout.parseInstance(baseType).toPrintable();
        System.out.println(s);
        JavaBaseObjectType baseObjectType = getBaseObjectType();
        s = ClassLayout.parseInstance(baseObjectType).toPrintable();
        System.out.println(s);

        JavaBaseType nulBaseType = new JavaBaseType();
        s = ClassLayout.parseInstance(nulBaseType).toPrintable();
        System.out.println(s);

        JavaBaseObjectType nullObjectType = new JavaBaseObjectType();
        s = ClassLayout.parseInstance(nullObjectType).toPrintable();
        System.out.println(s);

    }

    public static JavaBaseType getJavaBaseType() {
        JavaBaseType javaBaseType = new JavaBaseType();
        javaBaseType.setaBoolean(true);
        javaBaseType.setaByte(Byte.MAX_VALUE);
        javaBaseType.setaChar('d');
        javaBaseType.setaShort(Short.MAX_VALUE);
        javaBaseType.setaInt(Integer.MAX_VALUE);
        javaBaseType.setaLong(Long.MAX_VALUE);
        javaBaseType.setaDouble(Double.MAX_VALUE);
        javaBaseType.setaFloat(Float.MAX_VALUE);
        return javaBaseType;

    }
    public static JavaBaseObjectType getBaseObjectType() {
        JavaBaseObjectType javaBaseObjectType = new JavaBaseObjectType();
        javaBaseObjectType.setaBoolean(Boolean.TRUE);
        javaBaseObjectType.setaByte(Byte.MAX_VALUE);
        javaBaseObjectType.setaChar('c');
        javaBaseObjectType.setaShort(Short.MAX_VALUE);
        javaBaseObjectType.setaInt(Integer.MAX_VALUE);
        javaBaseObjectType.setaLong(Long.MAX_VALUE);
        javaBaseObjectType.setaDouble(Double.MAX_VALUE);
        javaBaseObjectType.setaFloat(Float.MAX_VALUE);
        return javaBaseObjectType;


    }
}
