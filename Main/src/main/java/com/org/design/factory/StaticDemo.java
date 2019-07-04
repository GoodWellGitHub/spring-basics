package com.org.design.factory;

public class StaticDemo {
    public static void main(String[] args) {
        System.out.println("hello");
        A a=new A();
    }
    private static class A{
        static {
            System.out.println("A");
        }
    }
}
