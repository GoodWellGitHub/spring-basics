package com.org.main.number;

import java.util.Random;

public class NumberMain {
    public static void main(String[] args) {
        Integer ax = 0;
        Short shortZero = 0;
        System.out.println(ax == shortZero.intValue());


        Random ra = new Random();
        for (int i = 0; i < 30; i++) {
            System.out.println(ra.nextInt(10) );
        }
    }
}
