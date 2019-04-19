package com.org.boolea;

public class BooleanMain {
    public static void main(String[] args){
        if (b1()||b2()||b3()){
            System.out.println("result");
        }
    }
    static boolean b1(){
        System.out.println("b1");
        return false;
    }
    static boolean b2(){
        System.out.println("b2");
        return true;
    }
    static boolean b3(){
        System.out.println("b3");
        return true;
    }
}
